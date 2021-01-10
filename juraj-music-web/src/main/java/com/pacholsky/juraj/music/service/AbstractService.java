package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.exception.ErrorCode;
import com.pacholsky.juraj.music.exception.MusicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class AbstractService<R , T extends JpaRepository<R, Integer>> {

    protected T repository;

    @Autowired
    protected void setRepository(T repository){
        this.repository = repository;
    }

    public List<R> getAll(){
        return repository.findAll();
    }

    public R getById(int id){
        return repository.findById(id).orElseThrow(() -> new MusicException(ErrorCode.NOT_FOUND , "Requested entity not found"));
    }


    public void save(R save){
        repository.saveAndFlush(save);
    }

    public void delete(int id){
        R entity = getById(id);
        repository.delete(entity);
    }


}
