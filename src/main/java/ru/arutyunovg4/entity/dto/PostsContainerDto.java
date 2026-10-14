package ru.arutyunovg4.entity.dto;

import java.util.List;

public class PostsContainerDto {
   public final List<PostDto> posts;

    public PostsContainerDto(List<PostDto> posts) {
        this.posts = posts;
    }

    public List<PostDto> getPosts() {
        return posts;
    }
}
