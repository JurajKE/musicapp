package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.entity.Album;
import com.pacholsky.juraj.music.repository.AlbumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("AlbumService")
@Transactional
public class AlbumService extends AbstractService<Album , AlbumRepository>{

    public List<Album> getByPerfomerId (int perfomerId){
            return super.repository.findAllByPerformerId(perfomerId);
    }

    public Album getByName(String name){
        return super.repository.findByName(name).orElseThrow();
    }

    public List<Album> getByPublisherId(int publisherId){

        return super.repository.findAllByPublisherId(publisherId);
    }

    public Album getBySongId(int songId){
        return super.repository.findBySong(songId).orElseThrow();
    }

    //TODO dokoncit new Exceptions

}
