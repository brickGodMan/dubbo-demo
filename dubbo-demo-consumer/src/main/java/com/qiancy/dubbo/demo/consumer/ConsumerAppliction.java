package com.qiancy.dubbo.demo.consumer;

import com.qiancy.dubbo.demo.common.account.api.AccountService;
import com.qiancy.dubbo.demo.common.account.dto.AccountDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2021/1/3
 * @since 1.0.0
 */
public class ConsumerAppliction {

    /**
     * 美元
     */
    private static final String USD = "D";
    /**
     * 人命币
     */
    private static final String RMB = "R";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dubbo.xml");
        AccountService accountService = context.getBean(AccountService.class);

        //测试10001 美元账户的 支付与取消
        payment(accountService, USD, "10001");
//        cancel(accountService, USD, "10001");

    }

    private static void payment(AccountService service, String type, String userId) {
        System.out.println("--------支付开始--------");
        service.payment(getAccountDTO(type, userId));
        System.out.println("--------支付结束--------");
    }

    private static void cancel(AccountService service, String type, String userId) {
        System.out.println("--------测试cancel--------");
        service.testCancel(getAccountDTO(type, userId));
        System.out.println("--------cancel结束--------");
    }

    private static AccountDTO getAccountDTO(String type, String userId) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAmount(BigDecimal.ONE);
        accountDTO.setType(type);
        accountDTO.setUserId(userId);
        return accountDTO;
    }
}
