package com.xu.basic.async;

import java.util.concurrent.ExecutionException;

/**
 * @author xushichao
 * @date 2020/11/4 8:18 AM
 * @desc
 */

public class Client {
    //@Inject
    private TransferService transferService; // 使用依赖注入获取转账服务的实例
    private final static int A = 1000;
    private final static int B = 1001;

    public void syncInvoke() throws ExecutionException, InterruptedException {
        // 同步调用
        transferService.transfer(A, B, 100).get();
        System.out.println("转账完成！");
    }

    public void asyncInvoke() {
        // 异步调用
        transferService.transfer(A, B, 100)
                .thenRun(() -> System.out.println("转账完成！"));
    }
}