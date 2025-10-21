package com.example.sem_04;

import java.util.Date;
//the class will have multiple methods / attributes

public class Movie {
    private String title;
    private float budget;
    private Date release;
    private EnumGenre genre;
    private EnumParentalApproval pApproval;
    private Integer duration;
    private Float rating;
    private Boolean recommended;

    public Movie(String title, float budget, Date release, EnumGenre genre, EnumParentalApproval pApproval, Integer duration, Float rating, Boolean recommended) {
        this.title = title;
        this.budget = budget;
        this.release = release;
        this.genre = genre;
        this.pApproval = pApproval;
        this.duration = duration;
        this.rating = rating;
        this.recommended = recommended;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", budget=" + budget +
                ", release=" + release +
                ", genre=" + genre +
                ", pApproval=" + pApproval +
                ", duration=" + duration +
                ", rating=" + rating +
                ", recommended=" + recommended +
                '}';
    }


}
