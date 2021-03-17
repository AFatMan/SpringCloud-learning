package com.mystudy.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义过滤器: 实现接口GlobalFilter(全局过滤器), Ordered(启动顺序)
 *
 * 场景:全局日志记录,统一网关鉴权,....
 *
 * @Author 刘健生
 * @Date 2021-03-17 11:46
 * @Description
 */
@Component
@Slf4j
public class MyFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("请求地址:"+exchange.getRequest().getPath().toString());

        /*当请求参数包含uSernAme时,请求异常*/
        String username = exchange.getRequest().getQueryParams().getFirst("uSernAme");
        if (username == null) {
            return chain.filter(exchange);//通过访问
        } else {
            // 返回错误请求
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.BAD_REQUEST);
            // 响应完成
            return response.setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
