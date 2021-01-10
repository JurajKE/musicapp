package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.entity.User;
import com.pacholsky.juraj.music.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("UserService")
@Transactional
public class UserService extends AbstractService<User, UserRepository> {

    public User getByName(String name){
        return super.repository.findByName(name).orElseThrow();
    }

    public User getByEmail(String email){
        return super.repository.findByEmail(email).orElseThrow();
    }

    public List<User> getByPlaylistId (int playlistId){
        return super.repository.findAllByPlaylists_id(playlistId);
    }
}
