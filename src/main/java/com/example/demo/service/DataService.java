package com.example.demo.service;

import com.example.demo.entity.DataEntity;
import com.example.demo.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<DataEntity> getAllEntities(){
        return dataRepository.findAll();
    }
}
