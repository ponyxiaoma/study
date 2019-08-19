package com.mjq.webflux.handle;

import com.mjq.webflux.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by majingqiang on 2018/11/15.
 */
@Component
public class UserHandler {

    public Mono<ServerResponse> getList(ServerRequest request) {
        //获取请求参数
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(Long.valueOf(1));
        user.setUserName("mjq" );
        users.add(user);
        return ServerResponse.ok().body(BodyInserters.fromObject(users));
    }

}
