package com.movieMania.backend.controller;

import com.movieMania.backend.Entity.*;
import com.movieMania.backend.service.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/gateway")
@CrossOrigin
public class mainController {


    @Autowired
    private mainService mainService;

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/addRequest/{multiCode}/{id}")
    private String addRequest(@RequestBody requestDto requestDto , @PathVariable String multiCode , @PathVariable Long id){
        return mainService.addRequest(id,requestDto,multiCode);
    }

    @PostMapping("/addMovie")
    private String addMovie(@RequestBody movieDto movie  ) {
        return mainService.addMovie(movie.getToken() , movie.getMovie());
    }

    @PutMapping("/updateMovie")
    private String updateMovie(@RequestHeader String header , @RequestBody movieUpdateData movieUpdateData) {
        return mainService.updateMovie(header , movieUpdateData);
    }

    @PutMapping("/rejectRequest")
    private String rejectRequest(@RequestHeader String header , @RequestBody rejectDto rejectDto) {
        return mainService.rejectRequest(header , rejectDto);
    }

    @GetMapping("/confirmRequest/{id}")
    private String confirm(@PathVariable Long id , @RequestHeader String header){
        return mainService.confirmRequest(header , id);
    }

    @DeleteMapping("/deleteMovie/{id}")
    private String deleteMovie(@PathVariable Long id , @RequestHeader String header){
        return mainService.deleteMovie(header,id);
    }





}
