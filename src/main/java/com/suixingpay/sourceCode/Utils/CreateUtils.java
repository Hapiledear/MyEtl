/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 22:06
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.sourceCode.Utils;


import com.suixingpay.sourceCode.ChangeFlag;
import com.suixingpay.sourceCode.Enum.CreateEnum;
import com.suixingpay.sourceCode.Utils.Encryption.AbstractEncrypt;
import com.suixingpay.sourceCode.Utils.Encryption.EncryptFactory;
import com.suixingpay.sourceCode.Utils.Encryption.EncryptorEnum;
import com.suixingpay.sourceCode.core.source.dao.SourceRepository;
import com.suixingpay.turbo.framework.core.util.time.DateFormatUtils;
import com.suixingpay.turbo.framework.jpa.annotation.DS;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 22:06
 * @version: V1.0
 */
public class CreateUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(CreateUtils.class);

    private static AbstractEncrypt umsEnc =  EncryptFactory.getEncryption(EncryptorEnum.TYPE_UMS);

    private static final Lock lock = new ReentrantLock();
    //key = in_mno value = usrId
    private static final ConcurrentHashMap<String,String> usrIdMap =  new ConcurrentHashMap();
    private static AtomicLong usrIdSeed = new AtomicLong(900000000000001L);//900-0000-0000-0001



    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String getStringValue(Object value) throws Exception {
        if (null == value) {
            return null;
        }

        if (value instanceof String) {
            return (String) value;
        }

        if (value instanceof Character) {
            Character cValue = (Character) value;
            return cValue.toString();
        }

        if (value instanceof Date) {   // 日期的处理

            return sdf.format(value);
        }

        throw new Exception("类型不匹配");
    }
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     *
     * @param targetClazz 目标数据表的list容器
     * @param tagretResp 目标数据表的domain
     * @param sql  源数据库的sql查询语句
     * @param <T> 目标数据表的domain类
     */
    @Transactional
    @DS(name = "write")
    public static  <T extends BaseRepository,S>  void StoT(Class<S> targetClazz,T tagretResp,String sql ){
     //   LOGGER.debug("-----------开始执行数据转换------------------");
        Map<String, Object> params = new HashMap<String, Object>();
        List<S> saved ;

        saved = SpringContextUtil.getContext().getBean(SourceRepository.class).findBySQL(sql, params).stream().map(obj -> {
            S bapTableClass = null;
            try {
                bapTableClass = targetClazz.newInstance();
            }
            catch (InstantiationException e) {
                LOGGER.error("InstantiationException",e);
            }
            catch (IllegalAccessException e) {
                LOGGER.error("IllegalAccessException",e);
            }
            ////  2017/3/15 对象的转换
            S finalBapTableClass = bapTableClass;
            //<editor-fold desc="反射操作">
            Arrays.stream(targetClazz.getDeclaredFields()).forEach(field -> {
                field.setAccessible(true);
                try {
                    ChangeFlag changeType = field.getAnnotation(ChangeFlag.class);
                    Column column = field.getAnnotation(Column.class);
                //    String inMnoName = changeType.inMnoName();
                    String columnName;
                    Object columnValue;

                    if (null == changeType){
                        columnName = column.name();
                        columnValue = obj.get(columnName);
                    }else{
                        columnName = !StringUtils.isEmpty(changeType.alise()) ? changeType.alise() : column.name();
                        columnValue = !StringUtils.isEmpty(changeType.defaultValue())
                                ? changeType.defaultValue() : obj.get(columnName);

                        //usrid = SXF+别名字段
                        if ("USR_ID".equals(column.name())){
                            columnValue = "SXF"+columnValue;
                        }

                        CreateEnum createType = changeType.systemCreate();
                        if (CreateEnum.TYPE_NONE != createType){
                            columnValue = CreateUtils.create(createType);
                        }

                        EncryptorEnum sEncType = changeType.sourceEncryptType();
                        EncryptorEnum tEncType = changeType.tagertEncryptType();
                        if (EncryptorEnum.TYPE_NONE != sEncType){
                            columnValue = CreateUtils.encryption(sEncType,tEncType,columnValue);
                        }

                        String merger = changeType.mergerDate();
                        if (!StringUtils.isEmpty(merger)){
                            String[] cNames = merger.split("@");
                            String  dateValue = getStringValue(obj.get(cNames[0]));
                            String  timeValue = getStringValue(obj.get(cNames[1]));
                           columnValue = mergeDateStr(dateValue,timeValue);
                        }

                        String switchStr = changeType.switcSTS();
                        if (!StringUtils.isEmpty(switchStr)){
                            columnValue = switchState(switchStr,columnValue);
                        }

                        if (changeType.ToString()){
                            columnValue = getStringValue(columnValue);
                        }

                        //// TODO: 2017/3/16 各项uitl加在这里

                    }
                    field.set(finalBapTableClass, columnValue);
                }
                catch (Exception e) {
                    LOGGER.error("发生错误！",e);
                }

            });
            //</editor-fold>
            LOGGER.info("转换结果,{}",bapTableClass.toString());
            return bapTableClass;
        }).collect(Collectors.toList());

        LOGGER.info("数据={}",saved.get(1).toString());
        tagretResp.save(saved.get(1));
   //   List resList =   tagretResp.save(saved);
        LOGGER.info("save结束，影响{}条数据",1);
        LOGGER.info("usrId自增长到了{}",usrIdSeed);
    }

    /**
     * 系统创建
     * @param o
     * @param type uuid usrId
     * @return
     */
    public static synchronized Object create(CreateEnum type) {
        switch (type){
            case TYPE_UUID:
                return getUUID();
            case TYPE_USR_ID:{
                return usrIdSeed.incrementAndGet();
              /*   String usrId ="1234";
                lock.lock();
                try {
                   usrId = usrIdMap.get(inMno);
                    if (StringUtils.isEmpty(usrId)){
                        usrId = String.valueOf(usrIdSeed.incrementAndGet());
                        usrIdMap.put(String.valueOf(inMno),usrId);
                    }
                } finally {
                    lock.unlock();
                }

                return "SXF"+usrId;*/
            }

            default:
                return "default";
        }
    }
    /**
     * 转换状态，标识字段必须为varchar或char类型,如果字段为空，默认为现标识的正常值
     * 可以与 alise 共存
     * 格式 "源标识-现标识;源标识-现标识"
     * eg "01-00;00-01"
     * 源标识 01正常，00异常
     * 现标识 00正常，01异常
     * @return
     */
    public static String switchState(String switchStr, Object columnValue) {
        String res ;
        Map<String,String> stsMap = new HashMap<>();
        String[] dValue = switchStr.split("%");
        String[] strList = dValue[0].split(";");
        for (String str : strList) {
            String[] oAnList = str.split("-");
            stsMap.put(oAnList[0],oAnList[1]);
        }
        if (StringUtils.isEmpty(columnValue)){
            res = dValue[1];
        }else {
            res =  stsMap.get(columnValue);
        }

        LOGGER.info("转换后的标识{},转换规则{},默认值{}",res,stsMap.toString(),dValue[1]);
        return res;
    }

    /**
     * 将数据表中的 date合并
     * cName1为日期 varchar类型
     * cName2为时间 varchar类型
     * @param obj
     * @param merger 格式:cName1@cName2
     * @throws ParseException
     */
    public static Date mergeDateStr(String dateValue,String timeValue) throws ParseException {
        dateValue = StringUtils.isEmpty(dateValue) ? DateUtils.getDateNoSeparator() : dateValue;
        timeValue = StringUtils.isEmpty(timeValue) ? DateUtils.getTimeNoSeparator() : timeValue;
        String dateStr = dateValue+timeValue;
        Date res = DateFormatUtils.pareDate("yyyyMMddHHmmss",dateStr);
        LOGGER.info("合并后的date={}",res.toString());
       return  res;
    }

    /**
     * 加解密工具
     * @param sourceEncType
     * @param columnValue
     * @return
     */
    public static Object encryption(EncryptorEnum sourceEncType, EncryptorEnum targetEncType, Object columnValue)
            throws Exception {

        AbstractEncrypt sourceEnc = EncryptFactory.getEncryption(sourceEncType);
        AbstractEncrypt targetEnc = EncryptFactory.getEncryption(targetEncType);
        String decryptStr = sourceEnc.decrypt(getStringValue(columnValue));
        LOGGER.debug("源加密机{}，目的加密机{}原文{}",sourceEncType,targetEncType,decryptStr);

        return targetEnc.encrypt(decryptStr);
    }

}
