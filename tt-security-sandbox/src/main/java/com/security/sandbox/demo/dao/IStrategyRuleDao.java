package com.security.sandbox.demo.dao;

import com.security.sandbox.demo.domain.dto.StrategyRuledto;
import com.security.sandbox.demo.domain.dto.Strategydto;

import java.util.List;

/**
 * @author 86151
 */
public interface IStrategyRuleDao {
    /**
     * 批量新增  密码与策略关系
     *
     * @param strategyRuledtoList
     * @return
     */
    int insertStrategyRule(List<StrategyRuledto> strategyRuledtoList);

    /**
     * 根据策略id查询其id所配置的规则集合
     * @param strategyId
     * @return
     */
    List<StrategyRuledto> getByStrategyId(String strategyId);
}
