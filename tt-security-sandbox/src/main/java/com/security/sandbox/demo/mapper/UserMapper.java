package com.security.sandbox.demo.mapper;

import com.security.sandbox.demo.domain.dto.Userdto;
import com.security.sandbox.demo.domain.eo.Usereo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 86151
 */
public interface UserMapper extends JpaRepository<Usereo,Integer> {
    /**
     * 根据id查看用户信息
     *
     * @param id
     * @return
     */
    Usereo getById(Integer id);
}
