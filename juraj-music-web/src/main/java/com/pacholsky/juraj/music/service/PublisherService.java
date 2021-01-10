package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.entity.Publisher;
import com.pacholsky.juraj.music.repository.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("PublisherService")
@Transactional
public class PublisherService extends AbstractService<Publisher , PublisherRepository> {

    public Publisher getByName(String name){
        return super.repository.findByName(name).orElseThrow();
    }

    public Publisher getByAlbumId(int albumId){
        return super.repository.findByAlbums(albumId).orElseThrow();
    }


}
