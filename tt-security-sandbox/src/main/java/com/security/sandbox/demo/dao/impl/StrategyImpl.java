package com.security.sandbox.demo.dao.impl;

import cn.hutool.core.util.ObjectUtil;
import com.security.sandbox.demo.dao.IStrategyDao;
import com.security.sandbox.demo.domain.dto.Strategydto;
import com.security.sandbox.demo.domain.eo.Strategyeo;
import com.security.sandbox.demo.mapper.StrategyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 86151
 */
@Service
public class StrategyImpl implements IStrategyDao {

    @Autowired
    StrategyMapper strategyMapper;

    @Override
    public Strategydto insertStrategy(Strategydto strategydto) {
        Strategyeo strategyeo = new Strategyeo();
        if (!ObjectUtil.isNull(strategydto)){
            BeanUtils.copyProperties(strategydto,strategyeo);
        }
        strategyMapper.save(strategyeo);
        BeanUtils.copyProperties(strategyeo,strategydto);
        return strategydto;
    }

    @Override
    public Strategydto getByStrategyId(String strategyId) {
        Strategyeo strategyeo = strategyMapper.getByStrategyId(strategyId);
        Strategydto strategydto = new Strategydto();
        BeanUtils.copyProperties(strategyeo,strategydto);
        return strategydto;
    }

    @Override
    public Strategydto getByName(String strategyName) {
        Strategyeo strategyeo = strategyMapper.getByStrategyName(strategyName);
        Strategydto strategydto = new Strategydto();
        BeanUtils.copyProperties(strategyeo,strategydto);
        return strategydto;
    }

    @Override
    public List<Strategydto> findAll() {
        List<Strategyeo> strategyeoList = strategyMapper.findAllByStrategyStatus(0);
        return strategyeoList.stream().map(t->{
            Strategydto strategydto = new Strategydto();
            BeanUtils.copyProperties(t,strategydto);
            return strategydto;
        }).collect(Collectors.toList());
    }
}
