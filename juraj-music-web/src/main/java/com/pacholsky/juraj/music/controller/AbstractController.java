package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
public abstract class AbstractController<R , T extends AbstractService<R , ?>>  {

    protected T service;

    @Autowired
    protected void setService(T service){
        this.service = service;
    }

    public abstract Class<R> getClassMethod();

    @GetMapping
    public List<R> getAll(){
        log.info("Going to getAll [{}]" , getClassMethod().getSimpleName());
        return service.getAll();
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable("id") int id){
        log.info("going to get [{}] by id [{}]" , getClassMethod().getSimpleName() ,id );
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        log.info("going to delete [{}] with id [{}]" , getClassMethod().getSimpleName() , id );
        service.delete(id);
        return ResponseEntity.ok("deleted");
    }

    @PutMapping
    public ResponseEntity<String> save(@RequestBody R param){
        log.info("Going to save [{}] " , param);
        service.save(param);
        return ResponseEntity.ok("saved");
    }

}
