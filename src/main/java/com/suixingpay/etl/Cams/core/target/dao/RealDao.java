package com.suixingpay.etl.Cams.core.target.dao;


import com.suixingpay.etl.Cams.core.target.domain.RealPo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Description: 用户实名信息表 Repository
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author yanghuang
 * Created on: 2017-02-27 11:49:40
 */
public interface RealDao extends BaseRepository<RealPo,String>,JpaSpecificationExecutor<RealPo>{

}