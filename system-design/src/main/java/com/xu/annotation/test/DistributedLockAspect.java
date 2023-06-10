//package com.xu.annotation.test;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.core.DefaultParameterNameDiscoverer;
//import org.springframework.core.ParameterNameDiscoverer;
//import org.springframework.expression.Expression;
//import org.springframework.expression.spel.standard.SpelExpressionParser;
//import org.springframework.expression.spel.support.SimpleEvaluationContext;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//
//import java.lang.reflect.Method;
//
///**
// * @author xushichao
// * @date 2022/5/30 6:19 PM
// * @desc
// */
//@Slf4j
//@Aspect
//@Component
//public class DistributedLockAspect {
//    private final SpelExpressionParser parser = new SpelExpressionParser();
//
//    private final ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
//
//    @Pointcut("@annotation(com.sankuai.meituan.banma.console.test.DistributedLock)")
//    public void daxiangReview() {
//
//    }
//
//    @Before(value = "daxiangReview()")
//    public void distributedLockAround(JoinPoint point) throws Throwable {
//        Signature signature = point.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        Method method = methodSignature.getMethod();
//        DistributedLock distributedLock = method.getAnnotation(DistributedLock.class);
//        Assert.hasLength(distributedLock.key(), "key不能为空");
////        // 获取方法参数
////        Object[] args = proceedingJoinPoint.getArgs();
////        // 获取方法参数名称
////        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
//        //String[] strings = methodSignature.getParameterNames();
//        Object[] args = point.getArgs();
//        String[] parameterNames = parameterNameDiscoverer.getParameterNames(method);
//        // 构建spel上下文
//        SimpleEvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
//        for (int i = 0; i < args.length; i++) {
//            context.setVariable(parameterNames[i], args[i]);
//        }
//
//        // 解析spel参数
//        Expression expression = parser.parseExpression(distributedLock.key());
//        String lockKey = expression.getValue(context, String.class);
//        Assert.hasLength(lockKey, "lockKey不能为空");
//
//       // return proceedingJoinPoint.proceed();
//
////        // 加分布式锁
////        Lock obtain = redisLockRegistry.obtain(lockKey);
////        log.info("开始获取锁: {}", lockKey);
////        if (obtain.tryLock()) {
////            try {
////                // 执行业务逻辑
////
////            } finally {
////                // 释放`锁
////                obtain.unlock();
////            }
////        } else {
////            log.warn("==== 获取锁失败 ====");
////            throw new RuntimeException(StringUtils.hasLength(distributedLock.failMessage()) ? distributedLock.failMessage() : "获取锁失败");
////        }
//
//    }
//
//}
