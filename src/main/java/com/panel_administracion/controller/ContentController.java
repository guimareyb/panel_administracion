package com.panel_administracion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
public class ContentController {

    @GetMapping
    public String helloWorld() {
        return "Hello World From Europe!";
    }

}
