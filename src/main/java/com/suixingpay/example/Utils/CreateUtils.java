/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 22:06
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.Utils;

import com.suixingpay.example.ChangeFlag;
import com.suixingpay.example.core.bap.domain.BapTableClass;
import com.suixingpay.example.core.uap.resp.UapTClassRepository;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 22:06
 * @version: V1.0
 */
public class CreateUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(CreateUtils.class);


    public static Object create(String type) {
        return 100321;
    }

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


    /**
     *
     * @param saved 目标数据表的list容器
     * @param tagretResp 目标数据表的domain
     * @param sql  源数据库的sql查询语句
     * @param <T> 目标数据表的domain类
     */
    public static  <T extends BaseRepository>  void StoT(List saved,T tagretResp,String sql ){
        LOGGER.info("-----------开始执行数据转换------------------");
        //    List<R> saved = new ArrayList<>();
        Map<String, Object> params = new HashMap<String, Object>();
        //   String sql = "SELECT uap_student.id,className,uap_student.name FROM uap_class JOIN uap_student ON uap_class.id = uap_student.class_id";
        //// TODO: 2017/3/16 改变源数据时替换该类 UapTClassRepository
        saved = SpringContextUtil.getContext().getBean(UapTClassRepository.class).findBySQL(sql, params).stream().map(obj -> {
            BapTableClass bapTableClass = new BapTableClass();
            ////  2017/3/15 对象的转换
            Arrays.stream(BapTableClass.class.getDeclaredFields()).forEach(field -> {
                field.setAccessible(true);
                try {
                    ChangeFlag changeType = field.getAnnotation(ChangeFlag.class);
                    Column column = field.getAnnotation(Column.class);
                    String columnName;
                    Object columnValue;

                    if (null == changeType){
                        columnName = column.name();
                        columnValue = obj.get(columnName);
                    }else{
                        columnName = !StringUtils.isEmpty(changeType.alise()) ? changeType.alise() : column.name();
                        columnValue = !StringUtils.isEmpty(changeType.defaultValue())
                                ? changeType.defaultValue() : obj.get(columnName);
                        String createType = changeType.systemCreate();
                        if (!StringUtils.isEmpty(createType)){
                            columnValue = CreateUtils.create(createType);
                        }
                        //// TODO: 2017/3/16 各项uitl加在这里

                    }
                    field.set(bapTableClass, columnValue);
                }
                catch (Exception e) {
                    LOGGER.info("发生错误！" + e);
                }

            });
            LOGGER.info("转换结果,{}",bapTableClass.toString());
            return bapTableClass;
        }).collect(Collectors.toList());

        tagretResp.save(saved);
    }


}
