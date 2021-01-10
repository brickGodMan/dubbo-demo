package com.qiancy.dubbo.demo.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiancy.dubbo.demo.common.account.entity.AccountDo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2021/1/10
 * @since 1.0.0
 */
@Repository
public interface AccountTestMapper extends BaseMapper<AccountDo> {

    @Select("select * from account")
    List<AccountDo> queryAllAccount();
}
