package com.security.sandbox.demo.mapper;

import com.security.sandbox.demo.domain.eo.UserStrategyeo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStrategyMapper extends JpaRepository<UserStrategyeo,Integer> {
    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    UserStrategyeo getByUserId(Integer userId);
}
