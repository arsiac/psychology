package top.arsiac.psychology.utils.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.arsiac.psychology.utils.annotation.SystemLogger;
import top.arsiac.psychology.utils.entity.LogInfo;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * <p>系统日志切面</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
@Aspect
@Component
public class SystemLoggerAspect {
    private static final Logger logger = LoggerFactory.getLogger("系统日志");

    @Pointcut("@annotation(top.arsiac.psychology.utils.annotation.SystemLogger)")
    public void pointCut() {
        // 声明切入点
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //处理
        manageLog(point, time);

        return result;
    }

    /**
     * <p>生成日志</p>
     * @param joinPoint 切点
     * @param time 花费时间
     * */
    private void manageLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LogInfo logInfo = new LogInfo();
        SystemLogger systemLogger = method.getAnnotation(SystemLogger.class);
        if(systemLogger != null){
            //注解上的描述
            logInfo.setOperation(systemLogger.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        logInfo.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();

        String params = JSON.toJSONString(args);
        logInfo.setParams(params);

        //用户名
        String userInfo = JSON.toJSONString(SecurityUtils.getSubject().getPrincipal());
        JSONObject jsonObject = JSON.parseObject(userInfo);
        logInfo.setUsername(jsonObject.getString("username"));

        logInfo.setTime(time);
        logInfo.setCreateDate(new Date());

        // 日志内容
        String stringBuilder = "==> 用户名:" + logInfo.getUsername() +
                "\n==> 描述:" + logInfo.getOperation() +
                "\n==> 方法: " + logInfo.getMethod() +
                "\n==> 参数: " + logInfo.getParams() +
                "\n==> 使用时间: " + logInfo.getTime() +
                "\n==> 调用时间: " + logInfo.getCreateDate();

        // 打印日志
        logger.info(stringBuilder);
    }
}
