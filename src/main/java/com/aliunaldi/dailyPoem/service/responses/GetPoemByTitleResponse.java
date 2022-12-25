package com.aliunaldi.dailyPoem.service.responses;

import com.aliunaldi.dailyPoem.entity.dtos.PoemDto;
import com.aliunaldi.dailyPoem.service.responses.baseResponse.BaseResponse;

public class GetPoemByTitleResponse extends BaseResponse {

    private PoemDto poemDto;

    public PoemDto getPoemDto() {
        return poemDto;
    }

    public void setPoemDto(PoemDto poemDto) {
        this.poemDto = poemDto;
    }
}
