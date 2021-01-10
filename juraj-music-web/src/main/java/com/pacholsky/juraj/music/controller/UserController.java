package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.entity.User;
import com.pacholsky.juraj.music.exception.ErrorCode;
import com.pacholsky.juraj.music.exception.MusicException;
import com.pacholsky.juraj.music.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User , UserService> {

    @GetMapping("/name")
    public User getByName(@RequestParam("name") String name){
        log.info("Going to get User by name [{}]" , name );
        return super.service.getByName(name);
    }

    @GetMapping("/email")
    public User getByEmail(@RequestParam("email") String email){
        log.info("Going to get User by email [{}]" , email );
        return super.service.getByEmail(email);
    }

    @GetMapping("/playlistid")
    public List<User> getByPlaylistId(@RequestParam("playlistid") int playlistId){
        log.info("Going to get all Users by playlist id [{}]" , playlistId );
        return super.service.getByPlaylistId(playlistId);
    }

    @GetMapping("/shit")
    public User getByShit(){
        throw new MusicException(ErrorCode.BAD_REQUEST , "Cannon request user by shit");
    }

    @Override
    public Class<User> getClassMethod() {
        return User.class;
    }
}
