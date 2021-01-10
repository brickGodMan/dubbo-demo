package com.qiancy.dubbo.demo.account.controller;

import com.qiancy.dubbo.demo.common.account.api.AccountService;
import com.qiancy.dubbo.demo.common.account.entity.AccountDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2021/1/10
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    private AccountService accountService;

    @ResponseBody
    @RequestMapping("/getAccountTest")
    public Map<String, List<AccountDo>> getAccountTest() {
        Map<String, List<AccountDo>> resultMap = new HashMap<>();
        resultMap.put("dubbo_a", accountService.testAccountA());
        resultMap.put("dubbo_b", accountService.testAccountB());
        return resultMap;
    }
}
