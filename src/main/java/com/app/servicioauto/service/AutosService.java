package com.app.servicioauto.service;

import com.app.servicioauto.entity.Auto;
import com.app.servicioauto.repository.AutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutosService {

    @Autowired
    private AutosRepository autosRepository;

    public List<Auto> getAll(){
        return autosRepository.findAll();
    }

    public Auto getById(Integer id){
        return autosRepository.findById(id).orElse(null);
    }

    public Auto guardar(Auto auto){
        return autosRepository.save(auto);
    }

    public List<Auto> getByUserId(int userId){
        return autosRepository.findByIdUsuario(userId);
    }
}
