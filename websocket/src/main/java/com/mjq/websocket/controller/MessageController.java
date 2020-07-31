package com.mjq.websocket.controller;

import com.mjq.websocket.server.WebsocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-03-15 14:31
 */
@Controller
@RequestMapping("/message/")
public class MessageController {

    @Autowired
    private WebsocketServer websocketServer;

    @GetMapping("/send")
    @ResponseBody
    public String send(@RequestParam String message) {
        websocketServer.sendInfo(message, null);
        return "success";
    }

    @GetMapping("/websocket")
    public String websocket() {
        return "websocket";
    }
}
