package com.suixingpay.etl.Cams.core.target.dao;


import com.suixingpay.etl.Cams.core.target.domain.UsrPo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UsrDao extends BaseRepository<UsrPo,String>,JpaSpecificationExecutor<UsrPo> {

}
