/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:29
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.service;

import com.suixingpay.example.ChangeFlag;
import com.suixingpay.example.Enum.DbType;
import com.suixingpay.example.Utils.CreateUtils;
import com.suixingpay.example.Utils.SpringContextUtil;
import com.suixingpay.example.core.bap.domain.BapTableClass;
import com.suixingpay.example.core.bap.resp.BapTClassRepository;
import com.suixingpay.example.core.uap.resp.UapTClassRepository;
import com.suixingpay.example.events.TestEvent;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:29
 * @version: V1.0
 */
@Service public class TClassService {

    private static Logger LOGGER = LoggerFactory.getLogger(TClassService.class);


    @Autowired private BapTClassRepository bapTClassRepository; //目的库，多个不同的domain

    @Autowired private UapTClassRepository uapTClassRepository;//源(要迁移的)库，只需要一个，对其进行读操作即可

    @EventListener
    @Async
    public void start(TestEvent readyEvent) {
        if (DbType.TEST != readyEvent.getId()){
            return;
        }
        LOGGER.info("----------- mysql uap ---> bap------------------");
       /* List<BapTableClass> saved = new ArrayList<>();

        String sql = "SELECT uap_student.id,className,uap_student.name FROM uap_class JOIN uap_student ON uap_class.id = uap_student.class_id";

       CreateUtils.StoT(saved,bapTClassRepository,sql);*/
    }



}
