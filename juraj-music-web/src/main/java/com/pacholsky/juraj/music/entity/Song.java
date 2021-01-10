package com.pacholsky.juraj.music.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="song")
@SequenceGenerator(name = "Song_Seq" , sequenceName = "Song_Seq" , initialValue = 1, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "Song_Seq")
    private int id;
    private String name;
    private Time lenght;

    @ManyToOne()
    @JsonIgnoreProperties({"song"})
    private Album album;

    @ManyToMany()
    @JsonIgnoreProperties({"featuresSongs"})
    private List<Performer> featuresPerformers = new ArrayList<>();

    @ManyToOne()
    @JsonIgnoreProperties({"songs"})
    private Genre genre;

    @ManyToMany()
    @JsonIgnoreProperties({"songs"})
    private List<Playlist> playlists = new ArrayList<>();


}
