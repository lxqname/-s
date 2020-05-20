package com.security.sandbox.demo.domain.eo;
//-------------------------hello

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author jie
 * @since 2019-09-03
 */
@Entity
@Table(name = "strategy_rule")
public class StrategyRuleeo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rule_id")
    private Integer ruleId;

    @Column(name = "strategy_id")
    private String strategyId;

    @Column(name = "rule_status")
    private Integer ruleStatus;

    @Column(name = "rule_cycle")
    private Integer ruleCycle;

    @Column(name = "rule_force")
    private Integer ruleForce;

    @Column(name = "rule_must")
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
        return "StrategyRuleeo{" +
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
