package com.mjq.webflux.router;

import com.mjq.webflux.handle.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by majingqiang on 2018/11/15.
 */
@Configuration
public class UserRouter {

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions
                .route(RequestPredicates.GET("/user/getList" ), userHandler::getList);//查询 json响应
    }
}
