package com.example.demo.controller;

import com.example.demo.entity.Dict;
import com.example.demo.services.DictServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")//this is the base url for api.but if you don't want to use this kind of url you can avoid this line
//so this api will be accessible from http://localhost:8080/
public class DictController {

    @Autowired
    private DictServices services;

    @GetMapping("/dicts")//you can give this any name you want and after adding this string to the end of base url you can use this
    public ResponseEntity<List<Dict>> getAllDicts() {
        return ResponseEntity.ok(services.getDictList());
    }

    @GetMapping("/dict/{id}")
    public ResponseEntity<Dict> getDictById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.services.getDictById(id));
    }

    @PostMapping("/addDict")
    public ResponseEntity<Dict> addDict(@RequestBody Dict dict) {
        return ResponseEntity.ok(this.services.createDict(dict));
    }

    @PostMapping("/addDicts")
    public ResponseEntity<List<Dict>> addDicts(@RequestBody List<Dict> list) {
        return ResponseEntity.ok(this.services.createDictList(list));
    }

    @PutMapping("/updateDicts/")
    public ResponseEntity<Dict> updateDict(@RequestBody Dict dict) {
        return ResponseEntity.ok().body(this.services.updateDictById(dict));
    }

    @DeleteMapping("/deleteDicts/{id}")
    public HttpStatus deleteDict(@PathVariable int id) {
        this.services.deleteDictById(id);
        return HttpStatus.OK;
    }
}
