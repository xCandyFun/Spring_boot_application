package com.example.demo.controller;

import com.example.demo.entity.DataEntity;
import com.example.demo.service.DataService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
public class ShowDataController {

    private final DataService dataService;

    public ShowDataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/rawDataFromDatabase")
    public List<DataEntity> getAllEntities(){
        return dataService.getAllEntities();
    }
}
