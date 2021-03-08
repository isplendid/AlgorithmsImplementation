package com.xu.basic.async;

import java.util.concurrent.CompletableFuture;

/**
 * @author xushichao
 * @date 2020/11/4 8:00 AM
 * @desc 账户服务
 */
public interface AccountService {
    /**
     * 变更账户金额
     * @param account 账户ID
     * @param amount 增加的金额，负值为减少
     */
    CompletableFuture<Void> add(int account, int amount);
}