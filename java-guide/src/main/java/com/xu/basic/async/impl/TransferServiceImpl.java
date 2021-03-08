package com.xu.basic.async.impl;

import com.xu.basic.async.AccountService;
import com.xu.basic.async.TransferService;

import java.util.concurrent.CompletableFuture;

/**
 * @author xushichao
 * @date 2020/11/4 8:15 AM
 * @desc
 */

public class TransferServiceImpl implements TransferService {
    //@Inject
    private AccountService accountService; // 使用依赖注入获取账户服务的实例
    @Override
    public CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount) {
        // 异步调用add方法从fromAccount扣减相应金额
        return accountService.add(fromAccount, -1 * amount)
                // 然后调用add方法给toAccount增加相应金额
                .thenCompose(v -> accountService.add(toAccount, amount));
    }
}
