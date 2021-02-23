package top.arsiac.psychology.utils.aspect;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.arsiac.psychology.utils.annotation.SystemLogger;
import top.arsiac.psychology.utils.entity.PageParam;
import top.arsiac.psychology.utils.common.Reply;
import top.arsiac.psychology.utils.entity.LogDetail;

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
    private static final Logger logger = LoggerFactory.getLogger(SystemLoggerAspect.class);

    @Pointcut("@annotation(top.arsiac.psychology.utils.annotation.SystemLogger)")
    public void pointCut() {
        // 声明切入点
    }


    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 获取注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SystemLogger systemLogger = method.getAnnotation(SystemLogger.class);


        // 获取请求参数
        Object[] args = point.getArgs();

        // 是否需要分页
        if (systemLogger != null && systemLogger.page()) {
            for (Object arg : args) {
                if (arg instanceof PageParam) {
                    PageParam pageParam = (PageParam) arg;
                    PageMethod.startPage(pageParam.getPageNum(), pageParam.getPageSize());
                    break;
                }
            }
        }

        // 开始运行时间
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;



        // 获取注解上的描述
        LogDetail logDetail = new LogDetail();
        if(systemLogger != null){
            logDetail.setOperation(systemLogger.value());
        }

        //请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        logDetail.setMethod(className + "." + methodName + "()");


        String params = JSON.toJSONString(args);
        logDetail.setParams(params);
        logDetail.setTime(time);

        // 操作产生的时间
        logDetail.setCreateDate(new Date());

        // 日志内容
        String stringBuilder = "==> 描述:" + logDetail.getOperation() +
                "\n==> 方法: " + logDetail.getMethod() +
                "\n==> 参数: " + logDetail.getParams() +
                "\n==> 花费时间: " + logDetail.getTime() +
                "ms\n==> 调用时间: " + logDetail.getCreateDate();

        // 打印日志
        logger.info(stringBuilder);

        return generateGlobalResponse(result, systemLogger);
    }

    /**
     * <p>构建统一回复</p>
     *
     * @param result 返回结果
     * @return 统一结构
     */
    private Reply generateGlobalResponse(Object result, SystemLogger systemLogger) {
        Reply reply = Reply.success().data(result);

        if (systemLogger != null && systemLogger.page() && result instanceof Page) {
            Page<?> page = (Page<?>) result;
            reply.pageSize(page.getPageSize())
                    .total(page.getTotal());
        }
        return reply;
    }
}
