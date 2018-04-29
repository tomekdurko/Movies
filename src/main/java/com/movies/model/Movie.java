package com.movies.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private long id;

    private Integer year;

    private String description;

    private String name;

    private Integer duration;

    private String director;

    protected Movie() {}

    public Movie(Integer year,String description,String name,Integer duration,String director)
    {
        this.description=description;
        this.year=year;
        this.director=director;
        this.duration=duration;
        this.name=name;
    }
    public Movie(Movie nowy)
    {
        this.year=nowy.getYear();
        this.name=nowy.getName();
        this.duration=nowy.getDuration();
        this.director=nowy.getDirector();
        this.description=nowy.getDescription();
    }

    public Long getId()
    {

        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year=year;
    }
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description=description;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public void setDuration(Integer duration)
    {
        this.duration=duration;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director=director;
    }

}
