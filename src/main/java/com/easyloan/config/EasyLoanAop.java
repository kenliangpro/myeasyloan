package com.easyloan.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect // 描述一个切面类，定义切面类的时候需要打上这个注解
@Component
public class EasyLoanAop {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 定义一个方法,用于声明切入点的表达式，一般地，该方法不用加入其他的代码
     */
    @Pointcut("execution(* com.easyloan.service..*(..))")
    public void startAop() {

    }

//	@Around("startAop()")
//	public void huanrao(ProceedingJoinPoint poin) throws Throwable {
//		System.out.println("环绕通知" + logger.getClass().getName());
//		poin.proceed();
//	}

    /**
     * 声明一个前置方法
     *
     * @param joinPoint
     */
    @Before("startAop()")
    public void beforeMethod(JoinPoint joinPoint) {
        logger.info(String.format("Session: %s", ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession()));
        logger.info("前置通知:" + forLogger(joinPoint));
    }

    /**
     * 方法结束之后执行 无论是否抛出错误
     *
     * @param joinPoint
     */
    @After("startAop()")
    public void afterMethod(JoinPoint joinPoint) {
        logger.info("后置通知:" + forLogger(joinPoint));
    }

    /**
     * 方法在不抛出错误下执行
     *
     * @param joinPoint
     */
    @AfterReturning(value = "startAop()", returning = "result")
    public void qianzhifanhui(JoinPoint joinPoint, Object result) {
        logger.info(forLogger(joinPoint) + " " + "返回值：" + result);
    }

    /**
     * 在方法出现异常时，执行代码 可以指定出现特定异常时再指定抛出的是哪一个异常
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "startAop()", throwing = "ex")
    public void qianzhiYichang(JoinPoint joinPoint, Exception ex) {
        logger.info(forLogger(joinPoint) + " " + "returning with" + " occurs with" + ex);
    }

    private String forLogger(JoinPoint joinPoint) {
        StringBuffer sb = new StringBuffer();
        sb.append("包:");
        sb.append(joinPoint.getSignature().getDeclaringTypeName() + ",方法名:" + joinPoint.getSignature().getName() + ", ");

        sb.append("参数:");
        sb.append(Arrays.asList(joinPoint.getArgs()));
        return sb.toString();
    }
}
