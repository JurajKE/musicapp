package com.pacholsky.juraj.music.repository;

import com.pacholsky.juraj.music.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("publisherRepository")
public interface PublisherRepository extends JpaRepository<Publisher , Integer> {


    Optional<Publisher> findByName(String name);
    Optional<Publisher> findByAlbums(int albumId);

}
