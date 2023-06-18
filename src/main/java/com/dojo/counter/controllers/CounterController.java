package com.dojo.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CounterController {
    @RequestMapping("/")
    public String index(HttpSession session){
        session.setAttribute("name", "User");
        return "index.jsp";
    }
    @RequestMapping("/counter")
    public String counter(HttpSession session){
        int counter = 0;
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        }
        else {
            counter = (int) session.getAttribute("counter");
            session.setAttribute("counter", counter + 1);
        }
        return "counter.jsp";
    }
}
