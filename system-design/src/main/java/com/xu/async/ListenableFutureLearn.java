package com.xu.async;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

/**
 * @author xushichao
 * @date 2022/9/29 10:54
 * @desc
 */
public class ListenableFutureLearn {
    private static final int processors = Runtime.getRuntime().availableProcessors();

    private static final ThreadFactory threadFactory =
            new ThreadFactoryBuilder()
                    .setDaemon(true)
                    .setNameFormat("ListenableFutureAdapter-thread-%d")
                    .build();
    private static final ExecutorService defaultAdapterExecutor =
            Executors.newFixedThreadPool(processors,threadFactory);

    public static void main(String[] args) {

        String string = "test";

        Future<String> future = defaultAdapterExecutor.submit(new Task(string) {
        });

        ListenableFuture<String> listenInPoolThread = JdkFutureAdapters.listenInPoolThread(future);
        Futures.addCallback(listenInPoolThread, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.printf("success: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.printf("failure");
            }
        });
    }



    private static class Task implements Callable<String> {

        private final String data;

        public Task(String data) {
            this.data = data;

        }

        @Override
        public String call() throws Exception {
            try {
                return "result_Success=" + data;
            } catch (Exception e) {
                return "result_Failure=" + data;
            }

        }
    }


}
