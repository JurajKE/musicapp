package com.pacholsky.juraj.music.repository;

import com.pacholsky.juraj.music.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("genreRepository")
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Optional<Genre> findByName(String name);
    Optional<Genre> findBySongs(int songId);

}
