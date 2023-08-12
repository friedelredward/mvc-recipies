package com.example.mvcrecipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by r.edward on {12/08/2023}
 */
@Controller
public class IndexController {
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }
}
