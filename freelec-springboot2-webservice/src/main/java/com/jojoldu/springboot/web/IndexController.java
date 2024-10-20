package com.jojoldu.springboot.web;

import com.jojoldu.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private  final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // = [suffix] .mustache
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "post-save"; // = [suffix] .mustache
    }
}
