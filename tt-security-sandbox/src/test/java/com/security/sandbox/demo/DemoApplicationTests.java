package com.security.sandbox.demo;

import com.security.sandbox.demo.domain.eo.StrategyRuleeo;
import com.security.sandbox.demo.domain.eo.Strategyeo;
import com.security.sandbox.demo.mapper.StrategyMapper;
import com.security.sandbox.demo.mapper.StrategyRuleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    StrategyMapper strategyMapper;

    @Autowired
    StrategyRuleMapper strategyRuleMapper;

    @Test
    void contextLoads() {
        List<Strategyeo> all = strategyMapper.findAll();
        System.out.println(all);
        List<StrategyRuleeo> all1 = strategyRuleMapper.findAll();
        System.out.println(all1);
    }

}
