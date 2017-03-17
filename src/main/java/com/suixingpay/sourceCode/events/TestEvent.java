/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/16 11:34
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.sourceCode.events;

import com.suixingpay.sourceCode.Enum.DbType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/16 11:34
 * @version: V1.0
 */
public class TestEvent extends ApplicationEvent  {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestEvent.class);

    private DbType id;
    private AtomicInteger taskNum = new AtomicInteger(0);
    private boolean changTaskFinished  = false;

    public TestEvent(Object source,DbType id) {
        super(source);
        this.id = id;
    }

    public DbType getId() {
        return id;
    }

    public void startTask(){
        if (taskNum.intValue() == 0){
            changTaskFinished = false;
            LOGGER.info("-----------任务执行开始！---------");
        }
        taskNum.getAndIncrement();
    }

    public void finishTask(){
        taskNum.getAndDecrement();
        if (taskNum.intValue() == 0){
            changTaskFinished = true;
            LOGGER.info("-----------任务执行结束！---------");
        }
    }

}
