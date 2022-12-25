package com.aliunaldi.dailyPoem.service.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class GetPoemByTitleRequest implements Serializable {

    @NotNull
    @NotBlank
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
