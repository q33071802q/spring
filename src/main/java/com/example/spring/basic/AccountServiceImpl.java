package com.example.spring.basic;

/**
 * @author 默烦 2020/10/15
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();
    private static IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    /**
     * 成员变量 每个类都是独一份 如果是单例对象 则可以记录状态 保存累加
     */
    private int i=1 ;

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println("i:"+i);
        i++;
    }
}