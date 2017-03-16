package com.suixingpay.etl.Cams.core.source.dao;

import com.suixingpay.etl.Cams.core.source.domain.MecItnAttrIfPo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;

public interface UmsMecItnAttrIfRepository extends BaseRepository<MecItnAttrIfPo,Integer>,JpaSpecificationExecutor<MecItnAttrIfPo>{

}
