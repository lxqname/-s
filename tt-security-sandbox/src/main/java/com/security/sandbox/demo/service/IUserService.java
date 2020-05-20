package com.security.sandbox.demo.service;

import com.security.sandbox.demo.domain.dto.UserStrategyRelationdto;
import com.security.sandbox.demo.domain.dto.UserStrategydto;
import com.security.sandbox.demo.domain.dto.Userdto;


/**
 * @author 86151
 */
public interface IUserService {
    /**
     * 注册用户
     *
     * @param userdto
     * @return
     */
    Userdto addUser(Userdto userdto);
    /**
     * 根据id查看用户信息(包含策略名称)
     *
     * @param id
     * @return
     */
    UserStrategyRelationdto getById(Integer id);
    /**
     * 给用户配置密码策略
     * @param strategyId userId
     * @return
     */
    UserStrategydto addUserStrategydto(String strategyId,int userId);
}
