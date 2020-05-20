package com.security.sandbox.demo.domain.dto;
//-------------------------hello

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author jie
 * @since 2019-09-03
 */
public class StrategyRuledto implements Serializable {

    private Integer id;

    private Integer ruleId;

    private String strategyId;

    private Integer ruleStatus;

    private Integer ruleCycle;

    private Integer ruleForce;

    private Integer ruleMust;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getRuleStatus() {
        return ruleStatus;
    }

    public void setRuleStatus(Integer ruleStatus) {
        this.ruleStatus = ruleStatus;
    }

    public Integer getRuleCycle() {
        return ruleCycle;
    }

    public void setRuleCycle(Integer ruleCycle) {
        this.ruleCycle = ruleCycle;
    }

    public Integer getRuleForce() {
        return ruleForce;
    }

    public void setRuleForce(Integer ruleForce) {
        this.ruleForce = ruleForce;
    }

    public Integer getRuleMust() {
        return ruleMust;
    }

    public void setRuleMust(Integer ruleMust) {
        this.ruleMust = ruleMust;
    }

    @Override
    public String toString() {
        return "StrategyRuledto{" +
                "id=" + id +
                ", ruleId=" + ruleId +
                ", strategyId='" + strategyId + '\'' +
                ", ruleStatus=" + ruleStatus +
                ", ruleCycle=" + ruleCycle +
                ", ruleForce=" + ruleForce +
                ", ruleMust=" + ruleMust +
                '}';
    }
}
