package com.suixingpay.etl.Cams.core.target.dao;

import com.suixingpay.etl.Cams.core.target.domain.RealBankPo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Description: 用户实名银行卡 Repository
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author yanghuang
 * Created on: 2017-03-20 09:48:58
 */
public interface RealBankDao extends BaseRepository<RealBankPo,String>,JpaSpecificationExecutor<RealBankPo>{
	
}