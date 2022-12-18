/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Skate;
import com.example.demo.Repositorio.SkateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author danielcasallas
 */
@Service

public class SkateService {
      @Autowired
    private SkateRepository skateRepository;
    
    public List<Skate> getAll(){
        return skateRepository.getAll();
    }
    
    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }
    
    public Skate save (Skate skate){
        if (skate.getId() == null){
            return skateRepository.save(skate);
        } else {
            Optional<Skate> skate1 = skateRepository.getSkate(skate.getId());
            if(skate1.isEmpty()){
                return skateRepository.save(skate);
            } else {
                return skate;
            }
        }
    }
}
