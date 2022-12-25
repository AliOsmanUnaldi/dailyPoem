package com.aliunaldi.dailyPoem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "poem")
public class Poem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "poem")
    private String poem;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;
}
