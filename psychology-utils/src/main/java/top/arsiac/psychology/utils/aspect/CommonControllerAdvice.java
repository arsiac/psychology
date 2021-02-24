package top.arsiac.psychology.utils.aspect;

import com.github.pagehelper.Page;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.arsiac.psychology.utils.common.Reply;

/**
 * <p>统一返回值</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/24
 */
@RestControllerAdvice
public class CommonControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 不拦截 Reply
        if (o instanceof Reply) {
            return o;
        }

        // 分页
        if (o instanceof Page) {
            Page<?> page = (Page<?>) o;
            return Reply.success()
                    .data(o)
                    .total(page.getTotal())
                    .pageSize(page.getPageSize())
                    .pageNum(page.getPageNum());
        }

        return Reply.success().data(o);
    }
}
