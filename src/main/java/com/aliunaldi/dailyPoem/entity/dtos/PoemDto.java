package com.aliunaldi.dailyPoem.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoemDto {

    private String poem;

    private String author;

    private String title;
}
