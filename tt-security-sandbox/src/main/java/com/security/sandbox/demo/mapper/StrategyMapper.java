package com.security.sandbox.demo.mapper;

import com.security.sandbox.demo.domain.eo.Strategyeo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 86151
 */
public interface StrategyMapper extends JpaRepository<Strategyeo,Integer> {
    /**
     * 通过StrategyId 查询策略详情
     *
     * @param strategyId
     * @return
     */
    Strategyeo getByStrategyId(String strategyId);

    /**
     * 通过StrategyId 查询策略详情
     *
     * @param strategyName
     * @return
     */
    Strategyeo getByStrategyName(String strategyName);

    /**
     * 根据策略状态查询
     * @param status
     * @return
     */
    List<Strategyeo> findAllByStrategyStatus(Integer status);
}
