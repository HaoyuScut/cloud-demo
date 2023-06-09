package cn.itwhy.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/06/09 16:08
 * 全局过滤器的使用
 * 全局过滤器的作用是什么?
 *   对所有路由都生效的过滤器，并且可以自定义处理逻辑
 * 实现全局过滤器的步骤?
 *    实现GlobalFilter接口
 *    添加@Order注解或实现Ordered接口
 *    编写处理逻辑
 */

//@Order(-1)//设置顺序，也可实现Ordered接口
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

    /**
     *  处理当前请求，有必要的话通过{@link GatewayFilterChain}将请求交给下一个过滤器处理
     *
     * @param exchange 请求上下文，里面可以获取Request、Response等信息
     * @param chain 用来把请求委托给下一个过滤器
     * @return {@code Mono<Void>} 返回标示当前过滤器业务结束
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();

        //2.获取参数中的authorization参数
        String auth = params.getFirst("authorization");

        //3.判断参数值是否等于 admin
        if("admin".equals(auth)) {
            //4.是，放行
            return chain.filter(exchange);
        }

        //5.拦截
        //5.1设置状态吗
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        //5.2 拦截请求
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
