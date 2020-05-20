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
public class UserStrategydto implements Serializable {

    private Integer id;

    private Integer userId;

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
