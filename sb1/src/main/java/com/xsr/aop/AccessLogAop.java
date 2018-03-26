package com.xsr.aop;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
/**
 * Created by 145811 on 2018/3/26.
 */
@Component
@Aspect
public class AccessLogAop {
    private static Logger logger = Logger.getLogger(AccessLogAop.class);

    @Around(value = "execution(* com.xsr..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object doAround(final ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
//        String serviceName = jp.getSignature().getDeclaringType().getSimpleName();//类
        String serviceName = jp.getSignature().getDeclaringType().getName();//类
        String methodName = jp.getSignature().getName();//方法
        //打印Request日志
        StringBuilder sbRequest = new StringBuilder();
        sbRequest.append("[REQUEST]class:"+serviceName+",method:"+methodName).append(",params=").append(JSONObject.toJSONString(args));
        logger.info(sbRequest.toString());
        //执行方法调用
        Object  returnValue =  jp.proceed();
        logger.info("[RESPONSE]class:"+serviceName+",method:"+methodName + ",result="+JSONObject.toJSONString(returnValue));
        return returnValue;
    }
}