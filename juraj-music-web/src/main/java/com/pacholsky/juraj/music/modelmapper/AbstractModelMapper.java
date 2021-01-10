package com.pacholsky.juraj.music.modelmapper;

import com.pacholsky.juraj.music.dto.AlbumView;
import com.pacholsky.juraj.music.entity.Album;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


public abstract class AbstractModelMapper<R, T> {

    protected final ModelMapper modelMapper = new ModelMapper();

    public abstract Class<R> getClassMethod();

    public R map(T tClass) {
        return this.modelMapper.map(tClass, getClassMethod());
    }

}
