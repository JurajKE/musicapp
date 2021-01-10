package com.pacholsky.juraj.music.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="performer")
@SequenceGenerator(name = "Performer_Seq" , sequenceName = "Performer_Seq" , initialValue = 1, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Performer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "Performer_Seq")
    private int id;
    private String name;
    private String pictureFolder;

    @OneToMany(mappedBy = "performer")
    @JsonIgnoreProperties({"performer"})
    private List<Album> albums = new ArrayList<>();

    @ManyToMany()
    @JsonIgnoreProperties({"featuresPerformers"})
    @JoinTable(name = "performer_features_song" , joinColumns = {@JoinColumn(name = "performer_id")} , inverseJoinColumns = {@JoinColumn(name = "song_id")})
    private List<Song> featuresSongs = new ArrayList<>();




}
