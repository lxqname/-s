package com.security.sandbox.demo.domain.dto;

/**
 * @author 86151
 */
public class UserStrategyRelationdto {

    private Userdto userdto;

    /**
     * 策略名
     */
    private String strategyName;

    private Integer updateStatus;

    public Userdto getUserdto() {
        return userdto;
    }

    public void setUserdto(Userdto userdto) {
        this.userdto = userdto;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }
}
