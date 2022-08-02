package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @ResponseBody
    @GetMapping("/add/{a}/and/{b}")
    public String add(@PathVariable double a, @PathVariable double b) {
        return String.valueOf(a + b);
    }

    @ResponseBody
    @GetMapping("/subtract/{a}/from/{b}")
    public String subtract(@PathVariable double a, @PathVariable double b) {
        return String.valueOf(b - a);
    }

    @ResponseBody
    @GetMapping("/multiply/{a}/and/{b}")
    public String multiply(@PathVariable double a, @PathVariable double b) {
        return String.valueOf(a * b);
    }

    @ResponseBody
    @GetMapping("/divide/{a}/by/{b}")
    public String divide(@PathVariable double a, @PathVariable double b) {
        return String.valueOf(b / a);
    }
}
