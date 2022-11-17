package com.movieMania.backend.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class movieDto {

    private movie movie;
    private String token;
}
