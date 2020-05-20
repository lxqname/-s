package com.security.sandbox.demo.dao.impl;

import cn.hutool.core.util.ObjectUtil;
import com.security.sandbox.demo.dao.IStrategyRuleDao;
import com.security.sandbox.demo.domain.dto.StrategyRuledto;
import com.security.sandbox.demo.domain.eo.StrategyRuleeo;
import com.security.sandbox.demo.mapper.StrategyRuleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StrategyRuleImpl implements IStrategyRuleDao {

    @Autowired
    StrategyRuleMapper strategyRuleMapper;

    @Override
    public int insertStrategyRule(List<StrategyRuledto> strategyRuledtoList) {
        List<StrategyRuleeo> collect=null;
        if (!ObjectUtil.isNull(strategyRuledtoList)){
            collect = strategyRuledtoList.stream().map(t -> {
                StrategyRuleeo strategyRuleeo = new StrategyRuleeo();
                BeanUtils.copyProperties(t, strategyRuleeo);
                return strategyRuleMapper.save(strategyRuleeo);
            }).collect(Collectors.toList());
        }
        return collect.size();
    }

    @Override
    public List<StrategyRuledto> getByStrategyId(String strategyId) {
        List<StrategyRuleeo> list = strategyRuleMapper.getByStrategyId(strategyId);
        return list.stream().map(t->{
            StrategyRuledto strategyRuledto = new StrategyRuledto();
            BeanUtils.copyProperties(t,strategyRuledto);
            return strategyRuledto;
        }).collect(Collectors.toList());
    }
}
