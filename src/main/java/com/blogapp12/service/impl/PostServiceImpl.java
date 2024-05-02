package com.blogapp12.service.impl;

import com.blogapp12.entity.Post;
import com.blogapp12.payload.PostDto;
import com.blogapp12.repository.PostRepository;
import com.blogapp12.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());

        Post post = mapToEntity(postDto);

        Post savedPost =postRepository.save(post);

//        PostDto dto = new PostDto();
//        dto.setId(savedPost.getId());
//        dto.setTitle(savedPost.getTitle());
//        dto.setDescription(savedPost.getDescription());
//        dto.setContent(savedPost.getContent());

        PostDto dto = mapToDto(savedPost);
        return dto;


    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> fetchAllPosts(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Post> all = postRepository.findAll(pageable);
        List<Post> post = all.getContent();
        List<PostDto> postDtos = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return postDtos;

    }

    Post mapToEntity(PostDto postDto){
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());

       Post post = modelMapper.map(postDto, Post.class);

        return post;
    }

    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());

        dto = modelMapper.map(post, PostDto.class);

        return dto;

    }

}
