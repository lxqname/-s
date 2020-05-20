package com.security.sandbox.demo.dao.impl;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.ObjectUtil;
import com.security.sandbox.demo.dao.IUserDao;
import com.security.sandbox.demo.domain.dto.Userdto;
import com.security.sandbox.demo.domain.eo.Usereo;
import com.security.sandbox.demo.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 86151
 */
@Service
public class UserDaoImpl implements IUserDao {

    @Autowired
    UserMapper userMapper;

    @Override
    public Userdto addUser(Userdto userdto) {
        if (!ObjectUtil.isNull(userdto)){
            Usereo usereo = new Usereo();
            BeanUtils.copyProperties(userdto,usereo);
            userMapper.save(usereo);
            BeanUtils.copyProperties(usereo,userdto);
        }
        return userdto;
    }

    @Override
    public Userdto getById(Integer id) {
        Usereo usereo = userMapper.getById(id);
        if (ObjectUtil.isNull(usereo)){
            throw new ValidateException("用户不存在");
        }
        Userdto userdto = new Userdto();
        BeanUtils.copyProperties(usereo,userdto);
        return userdto;
    }
}
