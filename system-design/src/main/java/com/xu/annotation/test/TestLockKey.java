//package com.xu.annotation.test;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author xushichao
// * @date 2022/5/30 6:25 PM
// * @desc
// */
//@Slf4j
//@Service
//public class TestLockKey {
//
//    @com.sankuai.meituan.banma.console.test.DistributedLock(key = "#name2") // 使用 spel 表达式
//    public void lockTest(String name, String name2, boolean other) throws InterruptedException {
//        log.info("==== 执行业务逻辑开始 ====");
//        TimeUnit.SECONDS.sleep(2);
//        log.info("==== 执行业务逻辑完成 ====");
//    }
//}
