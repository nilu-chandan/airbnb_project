package com.blogapp12.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PostDto {
    private  long id;
    @NotEmpty
    @Size(min = 3, message = "Title should be 3 characters")

    private String title;
    private String description;
    private String content;
}
