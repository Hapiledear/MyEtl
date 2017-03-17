package com.suixingpay.sourceCode.core.source.dao;

import com.suixingpay.sourceCode.core.source.domain.SourcePo;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SourceRepository extends BaseRepository<SourcePo,Integer>,JpaSpecificationExecutor<SourcePo>{

}
