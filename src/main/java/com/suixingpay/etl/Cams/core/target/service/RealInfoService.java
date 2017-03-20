/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/20 9:32
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Cams.core.target.service;

import com.suixingpay.etl.Cams.core.target.dao.RealDao;
import com.suixingpay.etl.Cams.core.target.domain.RealPo;
import com.suixingpay.etl.Test.TestAService;
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
 * @date: 2017/3/20 9:32
 * @version: V1.0
 */
@Service
public class RealInfoService {

    private static Logger LOGGER = LoggerFactory.getLogger(RealInfoService.class);

    @Autowired RealDao realDao;

    @EventListener @Async public void start(TestEvent readyEvent) {
        if (DbType.CAMS != readyEvent.getId()) {
            return;
        }

        //T_UMS_REAL
        String sql = "select * from CAMS.T_CAMS_CUST_AUTH_HIS"
            +CreateUtils.testSqlLimit;
        CreateUtils.StoT(RealPo.class,realDao,sql);

        readyEvent.startTask();
        LOGGER.info("-----------testA ------------------");

        readyEvent.finishTask();
    }


}
