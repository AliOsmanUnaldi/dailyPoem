package com.aliunaldi.dailyPoem.api.controller;

import com.aliunaldi.dailyPoem.service.fullfilment.PoemService;
import com.aliunaldi.dailyPoem.service.requests.GetPoemByTitleRequest;
import com.aliunaldi.dailyPoem.service.requests.GetPoemsByAuthorRequest;
import com.aliunaldi.dailyPoem.service.responses.GetPoemByTitleResponse;
import com.aliunaldi.dailyPoem.core.utilities.exceptions.CustomizeException;
import com.aliunaldi.dailyPoem.service.responses.GetPoemsByAuthorResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(name = "/api/poems/")
public class PoemsController {

    private final PoemService poemService;

    public PoemsController(PoemService poemService) {
        this.poemService = poemService;
    }

    @PostMapping("getPoemByTitle")
    public GetPoemByTitleResponse getPoemByTitle(@RequestBody @Valid GetPoemByTitleRequest getPoemByTitleRequest) throws CustomizeException {
        return this.poemService.getPoemByTitle(getPoemByTitleRequest);
    }

    @PostMapping("getPoemsByAuthor")
    public GetPoemsByAuthorResponse getPoemsByAuthor(@RequestBody @Valid GetPoemsByAuthorRequest getPoemsByAuthorRequest) throws CustomizeException {
        return this.poemService.getPoemsByAuthor(getPoemsByAuthorRequest);
    }
}
