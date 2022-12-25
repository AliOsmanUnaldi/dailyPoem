package com.aliunaldi.dailyPoem.service.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class GetPoemsByAuthorRequest implements Serializable {

    @NotNull
    @NotBlank
    private String author;
}
