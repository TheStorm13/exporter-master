package com.reksoft.exporter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/report")
    public String getReportPage() {
        return "report";
    }

}
