package com.app.servicioauto.controller;

import com.app.servicioauto.entity.Auto;
import com.app.servicioauto.service.AutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autos")
public class AutosController {

    @Autowired
    private AutosService autosService;

    @GetMapping
    public ResponseEntity<List<Auto>> obtenerTodos(){
        List<Auto> autos = autosService.getAll();

        if(autos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(autos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auto> obtenerPorId(@PathVariable(name = "id") Integer id){
        Auto auto = autosService.getById(id);

        if(auto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(auto);
    }

    @GetMapping("/por_id_usuario/{idUsuario}")
    public ResponseEntity<List<Auto>> obtenerPorIdUsuario(@PathVariable(name = "idUsuario") Integer idUsuario){
        List<Auto> autos = autosService.getByUserId(idUsuario);

        if(autos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(autos);

    }

    @PostMapping
    public ResponseEntity<Auto> guardar(@RequestBody Auto auto){
        return ResponseEntity.status(HttpStatus.CREATED).body(autosService.guardar(auto));
    }

}
