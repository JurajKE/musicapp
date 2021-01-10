package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.repository.PerformerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("PerformerService")
@Transactional
public class PerformerService extends AbstractService<Performer , PerformerRepository> {

    public Performer getAllByName(String name){
        return super.repository.findByName(name).orElseThrow();
    }

    public Performer getByAlbumId(int albumId){
        return super.repository.findByAlbums(albumId).orElseThrow();
    }

    public List<Performer> getBySongId(int songId){
        return super.repository.findAllByFeaturesSongs_id(songId);
    }

}
