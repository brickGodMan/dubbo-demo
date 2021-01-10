package com.qiancy.dubbo.demo.common.account.mapper;

import com.qiancy.dubbo.demo.common.account.dto.AccountDTO;
import com.qiancy.dubbo.demo.common.account.entity.AccountDo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 功能简述：账户DAO
 *
 * @author qiancy
 * @create 2021/1/3
 * @since 1.0.0
 */

public interface AccountMapper {

    /**
     * Update int. try 方法
     *
     * @param accountDTO the account dto
     * @return the int
     */
    @Update("update account set balance = balance - #{amount}," +
            " freeze_amount= freeze_amount + #{amount} ,update_time = now()" +
            " where user_id =#{userId} and type = #{type} and balance > 0  ")
    int update(AccountDTO accountDTO);

    /**
     * Confirm int.
     *
     * @param accountDTO the account dto
     * @return the int
     */
    @Update("update account set " +
            " freeze_amount= freeze_amount - #{amount}" +
            " where user_id =#{userId} and type = #{type} and freeze_amount >0 ")
    int confirm(AccountDTO accountDTO);

    /**
     * Cancel int.
     *
     * @param accountDTO the account dto
     * @return the int
     */
    @Update("update account set balance = balance + #{amount}," +
            " freeze_amount= freeze_amount -  #{amount} " +
            " where user_id =#{userId} and type = #{type} and freeze_amount >0")
    int cancel(AccountDTO accountDTO);

    /**
     * 根据userId获取用户账户信息
     *
     * @param userId 用户id
     * @return AccountDO account do
     */
    @Select("select id,user_id,balance, freeze_amount ,type from account where user_id =#{userId} limit 1")
    AccountDo findByUserId(String userId);
}
