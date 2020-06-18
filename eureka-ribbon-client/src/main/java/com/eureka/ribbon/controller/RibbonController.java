package com.eureka.ribbon.controller;

import com.eureka.ribbon.service.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    private final RibbonService ribbonService;

    public RibbonController(RibbonService ribbonService) {
        this.ribbonService = ribbonService;
    }

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false, defaultValue = "疯狂的绵羊") String name){
        return ribbonService.hi(name);
    }
}
