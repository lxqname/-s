package com.security.sandbox.demo.controller;

import com.security.sandbox.demo.domain.dto.UserStrategyRelationdto;
import com.security.sandbox.demo.domain.dto.UserStrategydto;
import com.security.sandbox.demo.domain.dto.Userdto;
import com.security.sandbox.demo.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 86151
 */
@Controller
public class UserController {

    @Autowired
    IUserService userService;

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUserStrategyRelationdtoByUserId",method = RequestMethod.GET)
    public UserStrategyRelationdto getUserStrategyRelationdtoByUserId(@RequestParam("userId") Integer userId){
        return userService.getById(userId);
    }

    /**
     * 新增用户
     * @param userdto
     * @return
     */
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Userdto addUser(@RequestBody Userdto userdto){
        return userService.addUser(userdto);
    }

    /**
     * 给用户配置密码策略（中间表插入数据）
     *
     * @param strategyId
     * @param userId
     * @return
     */

    @PostMapping(value = "/configureStrategy")
    public UserStrategydto addUserStrategydto(@Param(value = "strategyId") String strategyId,
                                              @Param(value = "userId") int userId) {
        return userService.addUserStrategydto(strategyId, userId);
    }

}
