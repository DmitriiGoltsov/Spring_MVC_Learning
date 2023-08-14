package com.goltsov.springcourse.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/second")
public class SecondController {

    @GetMapping("/exit")
    public String exit() {
        return "second/exit";
    }
}
