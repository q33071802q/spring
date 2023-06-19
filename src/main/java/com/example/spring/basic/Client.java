package com.example.spring.basic;

import org.springframework.context.annotation.Bean;

/**
 * @author 默烦 2020/10/15
 *
 * 模拟一个表现层，用于调用业务层
 *
 * 首先理解spring设计思想
 * 减少new 的次数 只要删除一个实现类 代码就无法运行 耦合度太高 怎么做到没有实现类 还能正常运行
 *
 * JavaBean 表示用Java创建的可重用组件
 *
 * xxxService 和 xxxDao都是可重用的
 * 引入BeanFactory 概念 创建service和dao对象的工厂
 * 1.需要配置文件配置service和dao 配置内容 唯一标识符=全限定类名
 * 2.通过反射读取配置文件中的配置内容，反射创建对象 配置文件可以是xml也可以是properties
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
//            System.out.println(as);
            /**
             * com.example.spring.basic.AccountServiceImpl@1be6f5c3
             * com.example.spring.basic.AccountServiceImpl@6b884d57
             * com.example.spring.basic.AccountServiceImpl@38af3868
             * com.example.spring.basic.AccountServiceImpl@77459877
             * com.example.spring.basic.AccountServiceImpl@5b2133b1
             *
             * 不是同一个对象。。 多例对象 没必要多例  因为成员变量不存在被调整的情况 不存在线程安全问题
             * 所以用单例对象效率会提高很多
             * 保存了账户...
             * i:1
             * 保存了账户...
             * i:2
             * 保存了账户...
             * i:3
             * 保存了账户...
             * i:4
             * 保存了账户...
             * i:5
             * i 的状态变化 明确了现在是单例模式
             *
             * 这个打个问号？ 工厂解耦就是弄个配置文件 然后读完反射创建吗？
             *
             * 控制反转
             *  获取对象 找工厂要就行了 这种方式就叫控制反转 app跟资源之间的联系放开了 而是由工厂与资源进行对接 app直接取找工厂要就行了
             *  工厂的数据从哪来 初始化的时候直接加载到容器中去了
             */
            as.saveAccount();
        }
    }
}