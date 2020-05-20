package com.security.sandbox.demo.domain.dto;

import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * @author 86151
 */
public class StrategyRuleRelationdto {

    private String strategyId;

    @Length(min = 2,max = 15)
    private String strategyName;

    private Integer strategyStatus;

    private List<StrategyRuledto> strategyRuledtoList;

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public Integer getStrategyStatus() {
        return strategyStatus;
    }

    public void setStrategyStatus(Integer strategyStatus) {
        this.strategyStatus = strategyStatus;
    }

    public List<StrategyRuledto> getStrategyRuledtoList() {
        return strategyRuledtoList;
    }

    public void setStrategyRuledtoList(List<StrategyRuledto> strategyRuledtoList) {
        this.strategyRuledtoList = strategyRuledtoList;
    }
}
