package com.example.demo.controller;

import com.example.demo.entity.DataEntity;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowDataController {

    private final DataService dataService;

    public ShowDataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/")
    public List<DataEntity> getAllEntities(){
        return dataService.getAllEntities();
    }
}
