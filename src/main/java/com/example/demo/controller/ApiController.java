package com.example.demo.controller;

import com.example.demo.entity.DataEntity;
import com.example.demo.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/index")
public class ApiController {

    private final DataService dataService;

    public ApiController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping("/api")
    public String getAllEntities(Model model){
        List<DataEntity> entities = dataService.getAllEntities();
        model.addAttribute("entities", entities);
        return "api";
    }


}
