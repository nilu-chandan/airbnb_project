package com.blogapp12.controller;

import com.blogapp12.payload.PostDto;
import com.blogapp12.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    //http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto ){

//        if (postDto.getTitle().length()<3){
//            return new ResponseEntity<>("Title should be 3 characters" HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }


        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    //http://localhost:8080/api/posts/2

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted!!", HttpStatus.OK);
    }

    //http://localhost:8080/api/posts?pageNo=1&pageSize=5&sortBy=desciption

    @GetMapping
    public ResponseEntity<List<PostDto>> fatchAllPosts(

            @RequestParam(name = "pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(name = "pageSize",defaultValue = "5",required = false)int pageSize,
            @RequestParam(name = "sortBy",defaultValue = "id",required = false)String sortBy


    ){
        List<PostDto>postDtos = postService.fetchAllPosts(pageNo,pageSize,sortBy);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }


}
