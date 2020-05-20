package com.security.sandbox.demo.dao;

import com.security.sandbox.demo.domain.dto.UserStrategydto;

/**
 * @author 86151
 */
public interface IUserStrategyDao {
    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    UserStrategydto getByUserId(Integer userId);

    /**
     * 给用户配置密码策略
     * @param userStrategydto
     * @return
     */
    UserStrategydto addUserStrategydto(UserStrategydto userStrategydto);
}
