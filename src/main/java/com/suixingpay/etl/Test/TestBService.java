/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/17 17:09
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Test;

import com.suixingpay.sourceCode.Enum.DbType;
import com.suixingpay.sourceCode.events.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/17 17:09
 * @version: V1.0
 */
@Service
public class TestBService {

    private static Logger LOGGER = LoggerFactory.getLogger(TestBService.class);

    @EventListener @Async public void start(TestEvent readyEvent) {
        if (DbType.TEST != readyEvent.getId()) {
            return;
        }
        readyEvent.startTask();
        LOGGER.info("-----------testB ------------------");
        readyEvent.finishTask();
    }
}
