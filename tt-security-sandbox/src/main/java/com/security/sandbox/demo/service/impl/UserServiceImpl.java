package com.security.sandbox.demo.service.impl;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.ObjectUtil;
import com.security.sandbox.demo.dao.IStrategyDao;
import com.security.sandbox.demo.dao.IUserDao;
import com.security.sandbox.demo.dao.IUserStrategyDao;
import com.security.sandbox.demo.domain.dto.Strategydto;
import com.security.sandbox.demo.domain.dto.UserStrategyRelationdto;
import com.security.sandbox.demo.domain.dto.UserStrategydto;
import com.security.sandbox.demo.domain.dto.Userdto;
import com.security.sandbox.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 86151
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Autowired
    IUserStrategyDao userStrategyDao;

    @Autowired
    IStrategyDao strategyDao;

    @Override
    public Userdto addUser(Userdto userdto) {
        if (ObjectUtil.isNull(userdto)){
            throw new ValidateException("不能为空");
        }
        return userDao.addUser(userdto);
    }

    @Override
    public UserStrategyRelationdto getById(Integer id) {
        UserStrategyRelationdto userStrategyRelationdto = new UserStrategyRelationdto();
        Userdto userdto = userDao.getById(id);
        userStrategyRelationdto.setUserdto(userdto);
        UserStrategydto userStrategydto = userStrategyDao.getByUserId(id);
        Strategydto strategydto = strategyDao.getByStrategyId(userStrategydto.getStrategyId());
        userStrategyRelationdto.setStrategyName(strategydto.getStrategyName());
        userStrategyRelationdto.setUpdateStatus(strategydto.getStrategyStatus());
        return userStrategyRelationdto;
    }

    @Override
    public UserStrategydto addUserStrategydto(String strategyId,int userId) {
        UserStrategydto userStrategydto = new UserStrategydto();
        userStrategydto.setStrategyId(strategyId);
        userStrategydto.setUserId(userId);
        return userStrategyDao.addUserStrategydto(userStrategydto);
    }
}
