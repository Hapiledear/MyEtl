/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/20 10:01
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Cams.core.target.service;

import com.suixingpay.etl.Cams.core.target.domain.RealUserPo;
import com.suixingpay.etl.Cams.core.target.dao.RealUserDao;
import com.suixingpay.sourceCode.Enum.DbType;
import com.suixingpay.sourceCode.Utils.CreateUtils;
import com.suixingpay.sourceCode.events.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/20 10:01
 * @version: V1.0
 */
@Service
public class RealUserService {

    private static Logger LOGGER = LoggerFactory.getLogger(RealInfoService.class);

    @Autowired RealUserDao realUserDao;

    @EventListener @Async public void start(TestEvent readyEvent) {
        if (DbType.CAMS != readyEvent.getId()) {
            return;
        }
        readyEvent.startTask();
        LOGGER.info("-----------RealUserPo------------------");
        //T_UMS_REAL
        String sql = "SELECT AUTH_TIMES, ID_TIMES, ID_SUCC_TIMES, BNK_TIMES, BNK_SUCC_TIMES , h.* FROM CAMS.T_CAMS_CUST_AUTH_HIS h LEFT JOIN (SELECT h.usr_in_no AS uno1, COUNT(h.usr_in_no) AS AUTH_TIMES FROM CAMS.T_CAMS_CUST_AUTH_HIS h GROUP BY h.usr_in_no ) ON uno1 = h.usr_in_no LEFT JOIN (SELECT h.usr_in_no AS uno2, COUNT(h.usr_in_no) AS ID_TIMES FROM CAMS.T_CAMS_CUST_AUTH_HIS h WHERE h.auth_type = '01' GROUP BY h.usr_in_no ) ON uno2 = h.usr_in_no LEFT JOIN (SELECT h.usr_in_no AS uno3, COUNT(h.usr_in_no) AS ID_SUCC_TIMES FROM CAMS.T_CAMS_CUST_AUTH_HIS h WHERE h.auth_type = '01' AND h.auth_state = '1' GROUP BY h.usr_in_no ) ON uno3 = h.usr_in_no LEFT JOIN (SELECT h.usr_in_no AS uno4, COUNT(h.usr_in_no) AS BNK_TIMES FROM CAMS.T_CAMS_CUST_AUTH_HIS h WHERE h.auth_type = '02' GROUP BY h.usr_in_no ) ON uno4 = h.usr_in_no LEFT JOIN (SELECT h.usr_in_no AS uno5, COUNT(h.usr_in_no) AS BNK_SUCC_TIMES FROM CAMS.T_CAMS_CUST_AUTH_HIS h WHERE h.auth_type = '02' AND h.auth_state = '1' GROUP BY h.usr_in_no ) ON uno5 = h.usr_in_no"
                + CreateUtils.testSqlLimit;
        CreateUtils.StoT(RealUserPo.class,realUserDao,sql);
        readyEvent.finishTask();
    }
}
