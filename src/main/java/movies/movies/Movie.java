package movies.movies;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private long id;

    private String year;

    private String description;

    private String name;

    private String duration;

    private String director;

    private Movie() {}

    public Movie(String year,String description,String name,String duration,String director)
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
    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
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

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
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
