package com.suixingpay.example.core.target.dao;

import com.suixingpay.example.core.target.domain.BapTableClass;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BapTClassRepository extends BaseRepository<BapTableClass,Integer>,JpaSpecificationExecutor<BapTableClass>{

}
