package com.aliunaldi.dailyPoem.core.utilities;

import com.aliunaldi.dailyPoem.entity.Poem;
import com.aliunaldi.dailyPoem.entity.dtos.PoemDto;
import com.aliunaldi.dailyPoem.service.responses.baseResponse.ResponseHeader;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static PoemDto convertPoemToPoemDto(Poem poem) {
        PoemDto poemDto = new PoemDto();
        poemDto.setTitle(poem.getTitle());
        poemDto.setAuthor(poem.getAuthor());
        poemDto.setPoem(poem.getPoem());
        return poemDto;
    }

    public static List<PoemDto> convertPoemListToPoemDtoList(List<Poem> poemList){
        List<PoemDto> poemDtoList = new ArrayList<>();
        for (Poem p : poemList){
            PoemDto poemDto = convertPoemToPoemDto(p);
            poemDtoList.add(poemDto);
        }
        return poemDtoList;
    }

    public static boolean isNullObject(Object o) {
        boolean result = true;
        if (o != null) {
            result = false;
        }
        return result;
    }

    public static boolean isNullOrEmptyString(String s) {
        boolean result = false;
        if (s.length() < 1 || isNullObject(s)) {
            result = true;
        }
        return result;
    }

    public static ResponseHeader generateResponseHeader(boolean success, String message) {
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setMessage(message);
        responseHeader.setSuccess(success);
        return responseHeader;
    }
}
