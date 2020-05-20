package com.security.sandbox.demo.service.impl;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.security.sandbox.demo.dao.IStrategyDao;
import com.security.sandbox.demo.dao.IStrategyRuleDao;
import com.security.sandbox.demo.domain.dto.StrategyRuleRelationdto;
import com.security.sandbox.demo.domain.dto.StrategyRuledto;
import com.security.sandbox.demo.domain.dto.Strategydto;
import com.security.sandbox.demo.service.IStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 86151
 */
@Service
public class StrategyServiceImpl implements IStrategyService {

    @Autowired
    IStrategyDao strategyDao;

    @Autowired
    IStrategyRuleDao strategyRuleDao;

    @Override
    public boolean insertStrategy(StrategyRuleRelationdto strategyRuleRelationdto) {
        if (ObjectUtil.isNull(strategyRuleRelationdto)){
            throw new ValidateException("不能为空");
        }
        Strategydto strategydto = new Strategydto();
        strategydto.setStrategyName(strategyRuleRelationdto.getStrategyName());
        strategydto.setStrategyStatus(strategyRuleRelationdto.getStrategyStatus());
        strategydto.setStrategyId("MMCL"+ UUID.randomUUID().toString());
        strategydto.setCreateTime(new Date());
        Strategydto strategydto1 = strategyDao.insertStrategy(strategydto);

        int i = strategyRuleDao.insertStrategyRule(strategyRuleRelationdto.getStrategyRuledtoList());
        if (i>0&&strategydto1!=null){
            return true;
        }
        return false;
    }

    @Override
    public StrategyRuleRelationdto getStrategyRuleRelationdtoByStrategyId(String strategyId) {
        StrategyRuleRelationdto strategyRuleRelationdto = new StrategyRuleRelationdto();
        Strategydto strategydto = strategyDao.getByStrategyId(strategyId);
        List<StrategyRuledto> strategyRuledtoList = strategyRuleDao.getByStrategyId(strategyId);
        strategyRuleRelationdto.setStrategyId(strategyId);
        strategyRuleRelationdto.setStrategyName(strategydto.getStrategyName());
        strategyRuleRelationdto.setStrategyStatus(strategydto.getStrategyStatus());
        strategyRuleRelationdto.setStrategyRuledtoList(strategyRuledtoList);
        return strategyRuleRelationdto;
    }

    @Override
    public String getByName(String strategyName) {
        if (StringUtils.isEmpty(strategyName)){
            throw new ValidateException("策略名不符合要求");
        }
        Strategydto strategydto = strategyDao.getByName(strategyName);
        if (strategydto==null){
            return "策略名可用";
        }
        return "策略名已存在";
    }

    @Override
    public PageInfo<Strategydto> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Strategydto> strategydtoList = strategyDao.findAll();
        PageInfo<Strategydto> strategydtoPageInfo = new PageInfo<>(strategydtoList);
        return strategydtoPageInfo;
    }
}
