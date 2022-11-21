package com.example.demo.controller;

import com.example.demo.entity.Emprunt;
import com.example.demo.services.EmpruntServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")//this is the base url for api.but if you don't want to use this kind of url you can avoid this line
//so this api will be accessible from http://localhost:8080/
public class EmpruntController {

    @Autowired
    private EmpruntServices services;

    @GetMapping("/emprunts")//you can give this any name you want and after adding this string to the end of base url you can use this
    public ResponseEntity<List<Emprunt>> getAllEmprunts() {
        return ResponseEntity.ok(services.getEmpruntList());
    }

    @GetMapping("/emprunt/{id}")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.services.getEmpruntById(id));
    }

    @PostMapping("/addEmprunt")
    public ResponseEntity<Emprunt> addEmprunt(@RequestBody Emprunt emprunt) {
        return ResponseEntity.ok(this.services.createEmprunt(emprunt));
    }

    @PostMapping("/addEmprunts")
    public ResponseEntity<List<Emprunt>> addEmprunts(@RequestBody List<Emprunt> list) {
        return ResponseEntity.ok(this.services.createEmpruntList(list));
    }

    @PutMapping("/updateEmprunts/")
    public ResponseEntity<Emprunt> updateEmprunt(@RequestBody Emprunt emprunt) {
        return ResponseEntity.ok().body(this.services.updateEmpruntById(emprunt));
    }

    @DeleteMapping("/deleteEmprunts/{id}")
    public HttpStatus deleteEmprunt(@PathVariable int id) {
        this.services.deleteEmpruntById(id);
        return HttpStatus.OK;
    }
}
