package com.security.sandbox.demo.dao.impl;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.ObjectUtil;
import com.security.sandbox.demo.dao.IUserStrategyDao;
import com.security.sandbox.demo.domain.dto.UserStrategyRelationdto;
import com.security.sandbox.demo.domain.dto.UserStrategydto;
import com.security.sandbox.demo.domain.eo.UserStrategyeo;
import com.security.sandbox.demo.mapper.UserStrategyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 86151
 */
@Service
public class UserStrategyDaoImpl implements IUserStrategyDao {

    @Autowired
    UserStrategyMapper userStrategyMapper;


    @Override
    public UserStrategydto getByUserId(Integer userId) {
        UserStrategyeo userStrategyeo = userStrategyMapper.getByUserId(userId);
        UserStrategydto userStrategydto = new UserStrategydto();
        BeanUtils.copyProperties(userStrategyeo,userStrategydto);
        return userStrategydto;
    }

    @Override
    public UserStrategydto addUserStrategydto(UserStrategydto userStrategydto) {
        if (ObjectUtil.isNull(userStrategydto)){
            throw new ValidateException("不能为空");
        }
        UserStrategyeo userStrategyeo = new UserStrategyeo();
        BeanUtils.copyProperties(userStrategydto,userStrategyeo);
        userStrategyMapper.save(userStrategyeo);
        BeanUtils.copyProperties(userStrategyeo,userStrategydto);
        return userStrategydto;
    }
}
