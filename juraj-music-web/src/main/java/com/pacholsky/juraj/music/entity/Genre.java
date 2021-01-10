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
@Table(name="genre")
@SequenceGenerator(name = "Genre_Seq" , sequenceName = "Genre_Seq" , initialValue = 1, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "Album_Seq")
    private int id;
    private String name;

    @OneToMany(mappedBy = "genre")
    @JsonIgnoreProperties({"genre"})
    private List<Song> songs = new ArrayList<>();


}
