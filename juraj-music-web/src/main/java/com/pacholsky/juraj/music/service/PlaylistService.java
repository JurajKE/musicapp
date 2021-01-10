package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.entity.Playlist;
import com.pacholsky.juraj.music.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("PlaylistService")
@Transactional
public class PlaylistService extends AbstractService<Playlist , PlaylistRepository> {

    public Playlist getByName(String name){
        return super.repository.findByName(name).orElseThrow();
    }

    public List<Playlist> getByUserId(int userId){
        return super.repository.findByUsers_id(userId);
    }

    public List<Playlist> getBySongId(int songId){
        return super.repository.findBySongs_id(songId);
    }



}
