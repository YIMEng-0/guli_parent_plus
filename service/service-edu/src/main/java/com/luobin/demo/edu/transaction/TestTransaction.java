package com.luobin.demo.edu.transaction;

import com.sun.javafx.tk.TKPulseListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author Doraemon
 * @date 2022/7/5 8:32 PM
 * @version 1.0
 */
public class TestTransaction {
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void testTransaction() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {

                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }
}
