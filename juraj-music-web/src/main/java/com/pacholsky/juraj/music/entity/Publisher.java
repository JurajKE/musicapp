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
@Table(name="publisher")
@SequenceGenerator(name = "Publisher_Seq" , sequenceName = "Publisher_Seq" , initialValue = 1, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "Publisher_Seq")
    private int id;
    private String name;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnoreProperties({"publisher"})
    private List<Album> albums = new ArrayList<>();
}
