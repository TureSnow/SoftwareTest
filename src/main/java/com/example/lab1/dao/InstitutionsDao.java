package com.example.lab1.dao;

import com.example.lab1.entity.Institution;
import org.springframework.stereotype.Component;

@Component
public interface InstitutionsDao {
    Institution findByName(String name);
}
