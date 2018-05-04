package com.movies.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue
    @JsonView(Views.Public.class)
    private long id;

    @NotNull
    @JsonView(Views.Internal.class)
    private Integer year;

    @NotNull
    @JsonView(Views.Internal.class)
    private String description;

    @NotNull
    @JsonView(Views.Public.class)
    private String name;

    @NotNull
    @JsonView(Views.Internal.class)
    private Integer duration;

    @NotNull
    @JsonView(Views.Internal.class)
    private String director;
}
