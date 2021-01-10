package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.entity.Genre;
import com.pacholsky.juraj.music.repository.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("GenreService")
@Transactional
public class GenreService extends AbstractService<Genre, GenreRepository> {

    public Genre getByName(String name){
        return super.repository.findByName(name).orElseThrow();
    }

    public Genre getBySongId(int songId){
        return super.repository.findBySongs(songId).orElseThrow();
    }

}
