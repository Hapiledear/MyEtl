/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:29
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Cams.core.target.service;

import com.suixingpay.etl.Cams.core.target.dao.*;
import com.suixingpay.etl.Cams.core.target.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.suixingpay.sourceCode.Enum.DbType;
import com.suixingpay.sourceCode.Utils.CreateUtils;
import com.suixingpay.sourceCode.events.TestEvent;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:29
 * @version: V1.0
 */
@Service public class MecItnAtrIfService {

    private static Logger LOGGER = LoggerFactory.getLogger(MecItnAtrIfService.class);


    //目的，domain


    @Autowired private MecWalletIfDao mecWalletIfDao;

    @Autowired private UmsMecItnAttrIfRepository umsMecItnAttrIfRepository;

    @Autowired private UsrPsnDao usrPsnDao;

    @Autowired private UsrDao usrDao;

    @Autowired private UsrProdBindDao usrProdBindDao;

    @Autowired private RealDao realDao;

    private String testSqlLimit = " where rownum <=10";

    @EventListener @Async public void start(TestEvent readyEvent) {
        if (DbType.CAMS != readyEvent.getId()) {
            return;
        }
        LOGGER.info("-----------mecItnAtrIf ------------------");

        //T_UMS_ITN_ATTR_IF
        String sql = "select p.usr_in_no,p.create_date,p.create_time,p.update_date,p.update_time from CAMS.T_CAMS_USR_INF_PERSON p "
                +testSqlLimit;
        CreateUtils.StoT(MecItnAttrIfPo.class,umsMecItnAttrIfRepository,sql);


      // T_UMS_MEC_WALLET_IF
/*       String sql = "select  u.real_auth_state usts,u.cust_level ulevel, p.* from CAMS.T_CAMS_USR_INF_PERSON p left join CAMS.T_CAMS_BASE_USR_INF u on p.usr_in_no = u.usr_in_no"
               ;
        CreateUtils.StoT(MecWalletIfPo.class,mecWalletIfDao,sql);*/



        //T_UMS_USR_PSN
/*        String sql ="select p.usr_in_no,p.nick_name,p.gender,p.birth_year,p.birth_month,p.birth_day from CAMS.T_CAMS_USR_INF_PERSON p "

        CreateUtils.StoT(UsrPsnPo.class,usrPsnDao,sql);*/

        //T_UMS_USR_IF
/*        String sql ="select p.usr_in_no,u.usr_status,p.nick_name,u.reg_date,u.reg_time,u.update_date,u.update_time,p.enc_reg_mobile,u.real_auth_state,u.reg_src,u.lock_expire_date,u.lock_reason from CAMS.T_CAMS_USR_INF_PERSON p left join CAMS.T_CAMS_BASE_USR_INF u on p.usr_in_no = u.usr_in_no"
                +testSqlLimit;
        CreateUtils.StoT(UsrPo.class,usrDao,sql);*/

//T_UMS_USR_PROD_BIND
/*    String sql = "select p.usr_in_no, u.reg_date,u.reg_time,u.update_date,u.update_time from CAMS.T_CAMS_USR_INF_PERSON p left join CAMS.T_CAMS_BASE_USR_INF u on p.usr_in_no = u.usr_in_no"
            ;
        CreateUtils.StoT(UsrProdBindPo.class,usrProdBindDao,sql);*/

//T_UMS_REAL
/*        String sql = "select * from CAMS.T_CAMS_CUST_AUTH_HIS"
            +testSqlLimit;
        CreateUtils.StoT(RealPo.class,realDao,sql);*/

    }

}
