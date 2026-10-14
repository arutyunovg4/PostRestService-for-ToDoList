package ru.arutyunovg4.entity.dto;

import java.time.LocalDate;

public class PostDto {
    private final int id;
    private final String author;
    private final LocalDate creationTime;
    private final int numberOfLikes;
    private final int numberOfDislikes;
    private final String title;

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getCreationTime() {
        return creationTime;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    public String getTitle() {
        return title;
    }

    public PostDto(int id, String author, LocalDate creationTime, int numberOfLikes, int numberOfDisikes, String title) {
        this.id = id;
        this.author = author;
        this.creationTime = creationTime;
        this.numberOfLikes = numberOfLikes;
        this.numberOfDislikes = numberOfDisikes;
        this.title = title;

    }
}
