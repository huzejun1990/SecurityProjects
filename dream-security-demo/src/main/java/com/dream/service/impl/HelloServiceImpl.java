package com.dream.service.impl;

import com.dream.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by huzejun
 * on 2019/4/2 11:47
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting!");
        return "hello" + name;
    }
}
