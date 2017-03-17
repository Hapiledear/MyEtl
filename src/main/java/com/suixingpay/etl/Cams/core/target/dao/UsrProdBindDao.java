package com.suixingpay.etl.Cams.core.target.dao;


import com.suixingpay.etl.Cams.core.target.domain.UsrProdBindPo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsrProdBindDao extends BaseRepository<UsrProdBindPo,String>,JpaSpecificationExecutor<UsrProdBindPo> {

}
