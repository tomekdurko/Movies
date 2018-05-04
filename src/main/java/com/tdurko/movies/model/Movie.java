package com.tdurko.movies.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    @JsonView(Views.Internal.class)
    private String description;

    @NotBlank
    @JsonView(Views.Public.class)
    private String name;

    @NotNull
    @JsonView(Views.Internal.class)
    private Integer duration;

    @NotBlank
    @JsonView(Views.Internal.class)
    private String director;
}
