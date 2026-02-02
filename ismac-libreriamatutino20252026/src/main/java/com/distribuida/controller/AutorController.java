package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//mmmm
@RestController
@RequestMapping("/api/autor")
public class AutorController {


    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        return ResponseEntity.ok(autorService.findAll());

    }
    @GetMapping("/{id}")
    public ResponseEntity<Autor> finOne(@PathVariable int id){
        Optional<Autor> autor = autorService.findOne(id);
        if(autor == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor.orElse(null));
    }

    @PostMapping
    public ResponseEntity<Autor> save(@RequestBody Autor factura){
        return  ResponseEntity.ok(autorService.save(factura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> update(@PathVariable int id,@RequestBody Autor autor){
        Autor autorActualizado = autorService.update(id, autor);
        if (autorActualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
