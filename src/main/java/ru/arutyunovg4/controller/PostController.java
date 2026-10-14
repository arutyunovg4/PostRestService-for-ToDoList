package ru.arutyunovg4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.arutyunovg4.entity.dto.PostDto;
import ru.arutyunovg4.entity.dto.PostsContainerDto;
import ru.arutyunovg4.entity.dto.request.CreatePostRequest;
import ru.arutyunovg4.entity.dto.request.UpdatePostRequest;
import ru.arutyunovg4.service.PostService;

@Controller
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseBody
    @GetMapping("/posts")
    public PostsContainerDto findAll() {
        return postService.findAll();
    }

    @ResponseBody
    @GetMapping("/posts/{id}")
    public PostDto findById(@PathVariable int id) {
        return postService.findById(id);
    }

    @ResponseBody
    @PostMapping("/posts")
    public PostDto save(@RequestBody CreatePostRequest request){
        return postService.save(request);
    }

    @ResponseBody
    @PutMapping("/posts/{id}")
    public PostDto update(@PathVariable int id, @RequestBody UpdatePostRequest request){
            return  postService.update(id,request);
    }

    @ResponseBody
    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable int id){
        postService.delete(id);
    }

}
