package com.security.sandbox.demo.dao;

import com.security.sandbox.demo.domain.dto.Userdto;

/**
 * @author 86151
 */
public interface IUserDao {
    /**
     * 注册用户
     *
     * @param userdto
     * @return
     */
    Userdto addUser(Userdto userdto);
    /**
     * 查看用户信息
     *
     * @param id
     * @return
     */
    Userdto getById(Integer id);
}
