package com.pacholsky.juraj.music.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name="album")
@SequenceGenerator(name = "Album_Seq" , sequenceName = "Album_Seq" , initialValue = 1, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "Album_Seq")
    private int id;
    private String name;
    private Date releaseDate;
    private String picture;

    @ManyToOne()
    @JsonIgnoreProperties({"albums"})
    private Performer performer;

    @ManyToOne()
    @JsonIgnoreProperties({"albums"})
    private Publisher publisher;

    @OneToMany(mappedBy = "album")
    @JsonIgnoreProperties({"album"})
    private List<Song> song = new ArrayList<>();





}
