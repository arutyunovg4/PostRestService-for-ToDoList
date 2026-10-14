package ru.arutyunovg4.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arutyunovg4.entity.Post;
import ru.arutyunovg4.entity.dto.PostDto;
import ru.arutyunovg4.entity.dto.PostsContainerDto;
import ru.arutyunovg4.entity.dto.request.CreatePostRequest;
import ru.arutyunovg4.entity.dto.request.UpdatePostRequest;
import ru.arutyunovg4.repository.PostRepository;

import java.util.List;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostsContainerDto findAll() {
        List<PostDto> posts = postRepository.findAll()
                .stream()
                .map(Post::toDto)
                .toList();

        return new PostsContainerDto(posts);
    }

    public PostDto findById(int id) {
        return postRepository.findById(id)
                .map(Post::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Post with id = " + id + " not found"));
    }

    public PostDto save(CreatePostRequest request) {
        Post post = request.toEntity();
        return postRepository.save(post).toDto();
    }

    public PostDto update(int id, UpdatePostRequest request) {
        return postRepository.findById(id)
                .map(existingPost -> {
                    Post updatedPost = request.toEntity(existingPost.getId(), existingPost.getCreationDate());
                    return postRepository.save(updatedPost).toDto();
                }).orElseThrow(() -> new IllegalArgumentException("Post with id = " + id + " not found"));
    }

    public void delete(int id) {
        postRepository.deleteById(id);
    }
}
