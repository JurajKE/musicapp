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
@Table(name="users")
@SequenceGenerator(name = "Users_Seq" , sequenceName = "User_Seq" , initialValue = 1, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "Users_Seq")
    private int id;
    private String email;
    private String name;

    @ManyToMany()
    @JsonIgnoreProperties({"user"})
    private List<Playlist> playlists = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Playlist> playlistList = new ArrayList<>();

}
