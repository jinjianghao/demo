package com.example.demo.t;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class hotfix {

    @GetMapping("/hotfix")
    public String hotfix() {
        return "hotfix1111111111";
    }

}
