package top.arsiac.psychology.utils.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.arsiac.psychology.utils.common.Reply;

/**
 * <p>全局异常处理</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/21
 */
@RestControllerAdvice
public class GlobalExceptionResolver {
    /**
     * 日志
     * */
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class.getSimpleName());

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PsychologyException.class)
    public Reply psychologyError(PsychologyException e) {
        logger.error("PsychologyException => main: {}\n code: {}\n brief: {}\n detail: {}\n",
                e.getMessage(), e.getCode(), e.getBrief(), e.getDetail());

        return Reply.error(e.getCode(), e.getBrief());
    }
}
