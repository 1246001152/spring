package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author : 张晋飞
 * date : 2019/4/16
 */
@Component
public class TransactionUtil {

    @Autowired
    private DataSourceTransactionManager txManager;

    // 事务开启
    public TransactionStatus begin(){
        TransactionStatus transaction = txManager.getTransaction(new DefaultTransactionDefinition());
        return transaction;
    }

    // 事务提交
    public void commit(TransactionStatus transaction){
        txManager.commit(transaction);

    }

    // 事务回滚
    public void rollback(TransactionStatus transaction){
        txManager.rollback(transaction);
    }


}
