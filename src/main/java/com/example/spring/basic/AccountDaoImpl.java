package com.example.spring.basic;

/**
 * @author 默烦 2020/10/15
 *
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户...");
    }
}