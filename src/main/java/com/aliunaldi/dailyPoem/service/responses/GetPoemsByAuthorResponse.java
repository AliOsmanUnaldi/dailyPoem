package com.aliunaldi.dailyPoem.service.responses;

import com.aliunaldi.dailyPoem.entity.dtos.PoemDto;
import com.aliunaldi.dailyPoem.service.responses.baseResponse.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetPoemsByAuthorResponse extends BaseResponse {

    private List<PoemDto> poemDtoList;
}
