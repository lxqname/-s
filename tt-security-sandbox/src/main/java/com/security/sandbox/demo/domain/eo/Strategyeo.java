package com.security.sandbox.demo.domain.eo;
//-------------------------hello



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 *
 * </p>
 *
 * @author jie
 * @since 2019-09-03
 */
@Entity
@Table(name="strategy")
public class Strategyeo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "strategy_id")
    private String strategyId;

    @Column(name = "strategy_name")
    private String strategyName;

    @Column(name = "strategy_status")
    private Integer strategyStatus;

    @Column(name = "create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "id=" + id +
                ", strategyId='" + strategyId + '\'' +
                ", strategyName='" + strategyName + '\'' +
                ", strategyState=" + strategyStatus +
                ", strategyCreateTime=" + createTime +
                '}';
    }
}
