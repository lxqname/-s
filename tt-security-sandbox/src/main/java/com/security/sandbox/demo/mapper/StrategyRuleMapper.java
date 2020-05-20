package com.security.sandbox.demo.mapper;

import com.security.sandbox.demo.domain.dto.StrategyRuledto;
import com.security.sandbox.demo.domain.eo.StrategyRuleeo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 86151
 */
public interface StrategyRuleMapper extends JpaRepository<StrategyRuleeo,Integer> {
    /**
     * 根据策略id查询其id所配置的规则集合
     * @param strategyId
     * @return
     */
    List<StrategyRuleeo> getByStrategyId(String strategyId);
}
