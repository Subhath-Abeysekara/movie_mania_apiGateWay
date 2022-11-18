package com.movieMania.backend.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class movieUpdateDto {

    private movieUpdateData movieUpdateData;
    private String token;
}
