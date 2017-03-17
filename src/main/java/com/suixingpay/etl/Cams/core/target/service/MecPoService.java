/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/17 17:43
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Cams.core.target.service;

import com.suixingpay.etl.Cams.core.target.dao.MecDao;
import com.suixingpay.etl.Cams.core.target.domain.MecPo;
import com.suixingpay.sourceCode.Enum.DbType;
import com.suixingpay.sourceCode.Utils.CreateUtils;
import com.suixingpay.sourceCode.core.source.domain.SourcePo;
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
 * @date: 2017/3/17 17:43
 * @version: V1.0
 */
@Service
public class MecPoService {
    private static Logger LOGGER = LoggerFactory.getLogger(MecPoService.class);
    private String testSqlLimit = " where rownum <=10";

    @Autowired private MecDao mecDao;



    @EventListener @Async public void start(TestEvent readyEvent) {
        if (DbType.CAMS != readyEvent.getId()) {
            return;
        }
        LOGGER.info("-----------mecPo ------------------");
        readyEvent.startTask();

        //T_UMS_MEC
        String sql = "SELECT p.usr_in_no, p.nick_name, p.enc_reg_mobile, b.usr_status, b.reg_date , b.reg_time, b.update_date, b.update_time, b.usr_type FROM CAMS.T_CAMS_USR_INF_PERSON p JOIN CAMS.T_CAMS_BASE_USR_INF b ON p.usr_in_no = b.usr_in_no"
                +testSqlLimit;
        CreateUtils.StoT(MecPo.class, mecDao, sql);

        readyEvent.finishTask();
    }


}
