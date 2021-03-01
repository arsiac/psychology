package com.github.arsiac.psychology.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * <p>授权管理</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/7
 */
@Component
public class AuthorizationFilter implements GlobalFilter, Ordered {
    /**
     * 日志
     * */
    private final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);

    /**
     * 不需要token的请求路径
     * */
    private static final String[] PATH_NOT_NEED_AUTHORIZATION = {
            "/centre/login",
            "/centre/logout",
            "/centre/captcha",

            /* swagger */
            "/centre/swagger-ui"
    };

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 请求路径
        String requestPath = request.getPath().value();
        logger.info("请求路径: {}", requestPath);

        // 是否不需要token
        for (String path : PATH_NOT_NEED_AUTHORIZATION) {
            if (requestPath.startsWith(path)) {
                return chain.filter(exchange);
            }
        }

        // 获取token
        String token = exchange.getRequest().getHeaders().getFirst("authorization");

        logger.info("token: {}", token);
        if (token == null || "".equals(token)) {
            logger.warn("{}: token 为空, 没有权限", requestPath);
            // 401
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

