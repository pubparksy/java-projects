package com.jojoldu.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // = [suffix] .mustache
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "post-save"; // = [suffix] .mustache
    }
}
