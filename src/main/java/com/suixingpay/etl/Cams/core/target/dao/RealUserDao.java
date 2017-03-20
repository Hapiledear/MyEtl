package com.suixingpay.etl.Cams.core.target.dao;


import com.suixingpay.etl.Cams.core.target.domain.RealUserPo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Description: 用户实名信息表 Repository
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author yanghuang
 * Created on: 2017-03-20 09:51:35
 */
public interface RealUserDao extends BaseRepository<RealUserPo,String>,JpaSpecificationExecutor<RealUserPo>{
	
}