package com.movieMania.backend.service;

import com.movieMania.backend.Entity.*;

public interface mainService {

    String addRequest(Long id , requestDto request , String multiCode);

    String addMovie(String token , movie movie);

    String updateMovie(String token , movieUpdateData movieUpdateData);

    String deleteMovie(String token , Long id);

    String rejectRequest(String token , rejectDto rejectDto);

    String confirmRequest(String token , Long id);
}
