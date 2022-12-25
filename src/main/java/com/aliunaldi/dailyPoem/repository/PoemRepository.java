package com.aliunaldi.dailyPoem.repository;

import com.aliunaldi.dailyPoem.entity.Poem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoemRepository extends JpaRepository<Poem, Long> {

    List<Poem> getAllByAuthor(String author);

    Poem getPoemByTitle(String title);
}
