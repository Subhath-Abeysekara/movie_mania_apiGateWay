package com.movieMania.backend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;


@Getter
@Setter
public class movie {

    String story;
    String addDate;
    String actors;
    String category;
    String launchingImageUrl;
    String name;
    String trailerLink;
    String imageUrl;
    Long rate = 0L;
    double price=300.0;

    private List<roles> roles;

    public movie() {
    }

}
