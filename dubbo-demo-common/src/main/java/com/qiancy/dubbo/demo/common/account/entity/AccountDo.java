package com.qiancy.dubbo.demo.common.account.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 功能简述：账户实体类
 *
 * @author qiancy
 * @create 2021/1/3
 * @since 1.0.0
 */
@Data
@ToString
@TableName("account")
public class AccountDo implements Serializable {

    private Integer id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 账户类型
     */
    private String type;

    /**
     * 单位 例如：￥, $
     */
    private String unit;

    /**
     * 账户余额
     */
    private BigDecimal balance;

    /**
     * 冻结资金
     */
    private BigDecimal freezeAmount;

    private Date createTime;

    private Date updateTime;

}
