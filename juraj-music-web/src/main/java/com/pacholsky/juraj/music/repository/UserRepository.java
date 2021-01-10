package com.pacholsky.juraj.music.repository;

import com.pacholsky.juraj.music.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User , Integer> {

    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    List<User> findAllByPlaylists_id(int playlistId);

}
