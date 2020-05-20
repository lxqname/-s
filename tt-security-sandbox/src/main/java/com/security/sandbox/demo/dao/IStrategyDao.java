package com.security.sandbox.demo.dao;

import com.security.sandbox.demo.domain.dto.Strategydto;

import java.util.List;

/**
 * @author 86151
 */
public interface IStrategyDao {
    /**
     * 新增密码策略
     *
     * @param strategydto
     * @return
     */
    Strategydto insertStrategy(Strategydto strategydto);

    /**
     * 根据策略id查询策略信息
     * @param strategyId
     * @return
     */
    Strategydto getByStrategyId(String strategyId);

    /**
     * 通过策略名查询
     *
     * @param strategyName
     * @return
     */
    Strategydto getByName(String strategyName);

    /**
     * 查询所有开启的密码策略
     * @return
     */
    List<Strategydto> findAll();
}
