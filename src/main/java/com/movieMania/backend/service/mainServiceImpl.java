package com.movieMania.backend.service;

import com.movieMania.backend.Entity.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class mainServiceImpl implements mainService{


    RestTemplate restTemplate = new RestTemplate();

    @Override
    public String addRequest(Long id , requestDto request , String multicode) {
        boolean availability = Boolean.TRUE.equals(restTemplate.getForObject("http://localhost:9001/movie/getAvailability/" + id, Boolean.class));
        if(availability){
            String url2 = "http://localhost:9002/request/addRequest/"+multicode;
            HttpEntity entity2 = new HttpEntity<>(request);
            ResponseEntity<String> res = restTemplate.exchange(url2, HttpMethod.POST,entity2, String.class);
            return res.getBody();
        }
        return "error movie";
    }

    private boolean checkAdmin(String token){
        String url = "http://localhost:9003/movie/getvalidity/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("header" , token);
        HttpEntity entity = new HttpEntity<>("",headers);
        ResponseEntity<String> validity = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        return Objects.requireNonNull(validity.getBody()).equalsIgnoreCase("successful");
    }

    @Override
    public String addMovie(String token , movie movie) {
        if (!checkAdmin(token)){
            return "error token";
        }

        String url2 = "http://localhost:9001/movie/addMovie/";
        HttpEntity entity2 = new HttpEntity<>(movie);
        ResponseEntity<String> res = restTemplate.exchange(url2, HttpMethod.POST,entity2, String.class);
        return res.getBody();
    }

    @Override
    public String updateMovie(String token, movieUpdateData movieUpdateData) {
        if (!checkAdmin(token)){
            return "error token";
        }

        String url2 = "http://localhost:9001/movie/updateMovie/";
        HttpEntity entity2 = new HttpEntity<>(movieUpdateData);
        ResponseEntity<String> res = restTemplate.exchange(url2, HttpMethod.PUT,entity2, String.class);
        return res.getBody();
    }

    @Override
    public String deleteMovie(String token, Long id) {
        if (!checkAdmin(token)){
            return "error token";
        }

        String url2 = "http://localhost:9001/movie/deleteMovie/"+id;
        HttpEntity entity2 = new HttpEntity<>("");
        ResponseEntity<String> res = restTemplate.exchange(url2, HttpMethod.DELETE,entity2, String.class);
        return res.getBody();
    }

    @Override
    public String rejectRequest(String token, rejectDto rejectDto) {
        if (!checkAdmin(token)){
            return "error token";
        }

        String url2 = "http://localhost:9002/request/rejectRequest/";
        HttpEntity entity2 = new HttpEntity<>(rejectDto);
        ResponseEntity<String> res = restTemplate.exchange(url2, HttpMethod.PUT,entity2, String.class);
        return res.getBody();
    }

    @Override
    public String confirmRequest(String token, Long id) {
        if (!checkAdmin(token)){
            return "error token";
        }

        String url2 = "http://localhost:9002/request/confirmRequest/"+id;
        HttpEntity entity2 = new HttpEntity<>("");
        ResponseEntity<String> res = restTemplate.exchange(url2, HttpMethod.PUT,entity2, String.class);
        return res.getBody();
    }
}
