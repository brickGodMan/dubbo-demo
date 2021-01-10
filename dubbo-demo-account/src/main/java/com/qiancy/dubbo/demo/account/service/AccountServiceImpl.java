package com.qiancy.dubbo.demo.account.service;

import com.qiancy.dubbo.demo.account.annotation.DS;
import com.qiancy.dubbo.demo.account.constants.DataSourceConstants;
import com.qiancy.dubbo.demo.account.mapper.AccountTestMapper;
import com.qiancy.dubbo.demo.common.account.api.AccountService;
import com.qiancy.dubbo.demo.common.account.entity.AccountDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2020/12/28
 * @since 1.0.0
 */
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountTestMapper mapper;

    @DS
    @Override
    public List<AccountDo> testAccountA() {
        return mapper.queryAllAccount();
    }
    @DS(DataSourceConstants.DS_KEY_SLAVE)
    @Override
    public List<AccountDo> testAccountB() {
        return mapper.queryAllAccount();
    }


//    @Override
//    public boolean payment(AccountDTO accountDTO) {
//        System.out.println("payment" + accountDTO.toString());
//        boolean result = accountMapper.update(accountDTO) > 0;
//        //去掉数据源
//        DynamicDataSourceContextHolder.removeContextKey();
//        return result;
//    }
//
//    @Override
//    public boolean testCancel(AccountDTO accountDTO) {
//        System.out.println("cancel" + accountDTO.toString());
//        boolean result = accountMapper.cancel(accountDTO) > 0;
//        //去掉数据源
//        DynamicDataSourceContextHolder.removeContextKey();
//        return result;
//    }
}
