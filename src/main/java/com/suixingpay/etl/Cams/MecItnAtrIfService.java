/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:29
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.etl.Cams;

import java.util.ArrayList;
import java.util.List;

import com.suixingpay.etl.Cams.core.source.dao.BapMecItnAttrIfRepository;
import com.suixingpay.etl.Cams.core.target.domain.MecItnAttrIfPo;
import com.suixingpay.etl.Cams.core.target.dao.UmsMecItnAttrIfRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.suixingpay.example.Enum.DbType;
import com.suixingpay.example.Utils.CreateUtils;
import com.suixingpay.example.events.TestEvent;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:29
 * @version: V1.0
 */
@Service public class MecItnAtrIfService {

    private static Logger LOGGER = LoggerFactory.getLogger(MecItnAtrIfService.class);


    @Autowired 
    private BapMecItnAttrIfRepository bapMecItnAttrIfRepository; //目的，domain

    @Autowired 
    private UmsMecItnAttrIfRepository umsMecItnAttrIfRepository;//只需要一写

    @EventListener
    @Async
    public void start(TestEvent readyEvent) {
        if (DbType.CAMS != readyEvent.getId()){
            return;
        }
        LOGGER.info("----------- mysql source ---> target------------------");

        List<MecItnAttrIfPo> saved = new ArrayList<MecItnAttrIfPo>();
        
        String sql = "SELECT * FROM  BAP.T_BAP_MEC_ITN_ATTR_IF where IN_MNO in (SElECT IN_MNO FROM BAP.T_BAP_MEC_IF WHERE MEC_TYP = '03') and rownum <=10 ";
       
        CreateUtils.StoT(MecItnAttrIfPo.class,umsMecItnAttrIfRepository,sql);
        
    }



}
