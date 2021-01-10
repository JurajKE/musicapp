package com.pacholsky.juraj.music.repository;

import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("performerRepository")
public interface PerformerRepository extends JpaRepository<Performer , Integer> {

    Optional<Performer> findByName(String name);
    Optional<Performer> findByAlbums(int albumId);
    List<Performer> findAllByFeaturesSongs_id(int songId);

}
