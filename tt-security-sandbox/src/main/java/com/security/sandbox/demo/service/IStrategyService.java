package com.security.sandbox.demo.service;

import com.github.pagehelper.PageInfo;
import com.security.sandbox.demo.domain.dto.StrategyRuleRelationdto;
import com.security.sandbox.demo.domain.dto.Strategydto;

import java.util.List;

/**
 * @author 86151
 */
public interface IStrategyService {
    /**
     * 新增密码策略
     *
     * @param strategyRuleRelationdto
     * @return
     */
    boolean insertStrategy(StrategyRuleRelationdto strategyRuleRelationdto);

    /**
     * 根据策略id查询策略和其规则的详情
     * @param strategyId
     * @return
     */
    StrategyRuleRelationdto getStrategyRuleRelationdtoByStrategyId(String strategyId);
    /**
     * 通过策略名查询
     *
     * @param strategyName
     * @return
     */
    String getByName(String strategyName);
    /**
     * 查询所有开启的密码策略
     * @return
     */
    PageInfo<Strategydto> findAll(int pageNum, int pageSize);
}
