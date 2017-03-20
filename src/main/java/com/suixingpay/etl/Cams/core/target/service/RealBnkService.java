/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/20 14:52
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Cams.core.target.service;

import com.suixingpay.etl.Cams.core.target.dao.RealBankDao;
import com.suixingpay.etl.Cams.core.target.dao.RealUserDao;
import com.suixingpay.etl.Cams.core.target.domain.RealBankPo;
import com.suixingpay.etl.Cams.core.target.domain.RealUserPo;
import com.suixingpay.sourceCode.Enum.DbType;
import com.suixingpay.sourceCode.Utils.CreateUtils;
import com.suixingpay.sourceCode.events.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/20 14:52
 * @version: V1.0
 */
@Service
public class RealBnkService {

    private static Logger LOGGER = LoggerFactory.getLogger(RealBnkService.class);

    @Autowired RealBankDao realBankDao;

    @EventListener @Async public void start(TestEvent readyEvent) {
        if (DbType.CAMS != readyEvent.getId()) {
            return;
        }
        readyEvent.startTask();
        LOGGER.info("-----------RealBankPo------------------");
        //T_UMS_REAL
        String sql = "select * from CAMS.T_CAMS_CUST_AUTH_HIS h where h.auth_type = '02' "
            ;
        CreateUtils.StoT(RealBankPo.class,realBankDao,sql);
        readyEvent.finishTask();
    }
}
