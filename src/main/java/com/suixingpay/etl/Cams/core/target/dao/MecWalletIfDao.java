package com.suixingpay.etl.Cams.core.target.dao;


import com.suixingpay.etl.Cams.core.target.domain.MecWalletIfPo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description: 钱包用户表 Repository
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author huyou
 * Created on: 2017-02-22 11:29:52
 */
public interface MecWalletIfDao extends BaseRepository<MecWalletIfPo,String>,JpaSpecificationExecutor<MecWalletIfPo>{

}