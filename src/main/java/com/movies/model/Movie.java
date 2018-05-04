package com.movies.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;



@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    @JsonView(Views.Public.class)
    private long id;

    @Getter
    @Setter
    @JsonView(Views.Internal.class)
    private Integer year;

    @Getter
    @Setter
    @JsonView(Views.Internal.class)
    private String description;

    @Getter
    @Setter
    @JsonView(Views.Public.class)
    private String name;

    @Getter
    @Setter
    @JsonView(Views.Internal.class)
    private Integer duration;

    @Getter
    @Setter
    @JsonView(Views.Internal.class)
    private String director;


}
