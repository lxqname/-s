package com.security.sandbox.demo.controller;

import com.github.pagehelper.PageInfo;
import com.security.sandbox.demo.domain.dto.StrategyRuleRelationdto;
import com.security.sandbox.demo.domain.dto.Strategydto;
import com.security.sandbox.demo.service.IStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * @author 86151
 */
@Controller
public class StrategyController {

    @Autowired
    IStrategyService strategyService;

    /**
     * 新增策略
     * @param strategyRuleRelationdto
     * @return
     */
    @RequestMapping(value = "/insertStrategy",method = RequestMethod.POST)
    public boolean insertStrategy(@RequestBody StrategyRuleRelationdto strategyRuleRelationdto){
        return strategyService.insertStrategy(strategyRuleRelationdto);
    }

    /**
     * 根据策略id查询策略和其规则的详情
     * @param strategyId
     * @return
     */
    @RequestMapping(value = "/getStrategyRuleRelationdtoByStrategyId",method = RequestMethod.GET)
    public StrategyRuleRelationdto getStrategyRuleRelationdtoByStrategyId(@RequestParam("strategyId") String strategyId){
        return strategyService.getStrategyRuleRelationdtoByStrategyId(strategyId);
    }

    /**
     * 策略名校验
     *
     * @param strategyName
     * @return
     */
    @GET
    @Path("/checkStrategyName/{id:[a-zA-Z0-9]+}")
    public String checkStrategyName(@RequestParam(value = "strategyName") String strategyName) {
        return strategyService.getByName(strategyName);
    }

    /**
     * 分页查询开启策略的列表
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public PageInfo<Strategydto> findAll(@RequestParam(value = "pageNum") int pageNum, @RequestParam(value = "pageSize") int pageSize){
        return strategyService.findAll(pageNum,pageSize);
    }
}
