package com.pacholsky.juraj.music.service.view;

import com.pacholsky.juraj.music.dto.AlbumView;
import com.pacholsky.juraj.music.exception.ErrorCode;
import com.pacholsky.juraj.music.exception.MusicException;
import com.pacholsky.juraj.music.modelmapper.AbstractModelMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractViewService<T , R> {

    protected JpaRepository<T , Integer> repository;
    protected AbstractModelMapper<R , T> modelMapper;

    @Autowired
    protected void setRepository(JpaRepository<T , Integer> repository){
        this.repository = repository;
    }

    @Autowired
    protected void setModelMapper(AbstractModelMapper<R , T> modelMapper){
        this.modelMapper = modelMapper;
    }

    public R getById(int id) {
        log.info("Going to get [{}] by id [{}]" , getClassMethod().getSimpleName() ,id );
        return modelMapper.map(repository.findById(id).orElseThrow(() -> new MusicException(ErrorCode.NOT_FOUND , String.format("Song with id [%d] was not found" , id))));
    }

    public abstract Class<R> getClassMethod();

    public List<R> getAll(){
        log.info("Going to get all [{}]" , getClassMethod().getSimpleName() );
        return repository.findAll().stream().map(modelMapper::map).collect(Collectors.toList());
    }


}
