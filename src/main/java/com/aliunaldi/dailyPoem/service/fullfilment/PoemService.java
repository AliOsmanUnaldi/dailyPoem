package com.aliunaldi.dailyPoem.service.fullfilment;

import com.aliunaldi.dailyPoem.core.utilities.Util;
import com.aliunaldi.dailyPoem.core.utilities.constants.CustomizeMessages;
import com.aliunaldi.dailyPoem.core.utilities.exceptions.CustomizeException;
import com.aliunaldi.dailyPoem.entity.Poem;
import com.aliunaldi.dailyPoem.repository.PoemRepository;
import com.aliunaldi.dailyPoem.service.requests.GetPoemByTitleRequest;
import com.aliunaldi.dailyPoem.service.requests.GetPoemsByAuthorRequest;
import com.aliunaldi.dailyPoem.service.responses.GetPoemByTitleResponse;
import com.aliunaldi.dailyPoem.service.responses.GetPoemsByAuthorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PoemService {
    private final PoemRepository poemRepository;

    @Autowired
    public PoemService(PoemRepository poemRepository) {
        this.poemRepository = poemRepository;
    }

    public GetPoemByTitleResponse getPoemByTitle(GetPoemByTitleRequest getPoemByTitleRequest) throws CustomizeException {
        GetPoemByTitleResponse response = new GetPoemByTitleResponse();
        try {
            checkIfGetPoemByTitleRequestIsNull(getPoemByTitleRequest);
            Poem poem = poemRepository.getPoemByTitle(getPoemByTitleRequest.getTitle());
            checkIfRepositoryWorksWrong(poem);
            response.setPoemDto(Util.convertPoemToPoemDto(poem));
            response.setResponseHeader(Util.generateResponseHeader(true, CustomizeMessages.SUCCESS));
        } catch (CustomizeException e) {
            response.setResponseHeader(Util.generateResponseHeader(false, e.getMessage()));
        } catch (Exception e) {
            response.setResponseHeader(Util.generateResponseHeader(false, e.getMessage()));
        }
        return response;
    }

    public GetPoemsByAuthorResponse getPoemsByAuthor(GetPoemsByAuthorRequest getPoemsByAuthorRequest) throws CustomizeException {
        GetPoemsByAuthorResponse response = new GetPoemsByAuthorResponse();
        try {
            checkIfGetPoemsByAuthorRequestIsNull(getPoemsByAuthorRequest);
            List<Poem> poemList = poemRepository.getAllByAuthor(getPoemsByAuthorRequest.getAuthor());
            checkIfRepositoryWorksWrong(poemList);
            response.setPoemDtoList(Util.convertPoemListToPoemDtoList(poemList));
            response.setResponseHeader(Util.generateResponseHeader(true, CustomizeMessages.SUCCESS));
        }catch (CustomizeException e){
            response.setResponseHeader(Util.generateResponseHeader(false, e.getMessage()));
        }catch (Exception e){
            response.setResponseHeader(Util.generateResponseHeader(false, e.getMessage()));
        }
        return response;
    }

    private void checkIfGetPoemByTitleRequestIsNull(GetPoemByTitleRequest getPoemByTitleRequest) throws CustomizeException {
        if (Util.isNullObject(getPoemByTitleRequest)) {
            throw new CustomizeException(CustomizeMessages.NULL_REQUEST);
        } else if (Util.isNullOrEmptyString(getPoemByTitleRequest.getTitle())) {
            throw new CustomizeException(CustomizeMessages.NULL_PARAMETERS);
        }
    }

    private void checkIfRepositoryWorksWrong(Object o) throws CustomizeException {
        if (Util.isNullObject(o)) {
            throw new CustomizeException(CustomizeMessages.BAD_QUERY);
        }
    }

    private void checkIfGetPoemsByAuthorRequestIsNull(GetPoemsByAuthorRequest getPoemsByAuthorRequest) throws CustomizeException {
        if (Util.isNullObject(getPoemsByAuthorRequest)) {
            throw new CustomizeException(CustomizeMessages.NULL_REQUEST);
        } else if (Util.isNullOrEmptyString(getPoemsByAuthorRequest.getAuthor())) {
            throw new CustomizeException(CustomizeMessages.NULL_PARAMETERS);
        }
    }
}
