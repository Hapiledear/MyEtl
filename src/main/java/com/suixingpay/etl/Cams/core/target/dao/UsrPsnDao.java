package com.suixingpay.etl.Cams.core.target.dao;

import com.suixingpay.etl.Cams.core.target.domain.UsrPsnPo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsrPsnDao extends BaseRepository<UsrPsnPo,String>,JpaSpecificationExecutor<UsrPsnPo> {

}
