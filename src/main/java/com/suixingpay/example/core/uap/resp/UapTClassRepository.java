package com.suixingpay.example.core.uap.resp;


import com.suixingpay.example.core.uap.domain.UapTClass;
import com.suixingpay.turbo.framework.jpa.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UapTClassRepository extends BaseRepository<UapTClass,Integer>,JpaSpecificationExecutor<UapTClass> {

}
