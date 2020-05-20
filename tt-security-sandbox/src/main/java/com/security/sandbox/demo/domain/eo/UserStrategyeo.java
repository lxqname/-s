package com.security.sandbox.demo.domain.eo;
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
@Entity
@Table(name = "user_strategy")
public class UserStrategyeo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "strategy_id")
    private String strategyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    @Override
    public String toString() {
        return "UserStrategy{" +
                "id=" + id +
                ", userId=" + userId +
                ", strategyId=" + strategyId +
                "}";
    }
}
