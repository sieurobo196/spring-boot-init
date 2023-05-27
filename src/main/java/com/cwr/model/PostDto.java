package com.cwr.model;

import lombok.Data;

@Data
public class PostDto {
    private Integer id;
    private String url;
    private String type;
    private String title;
    private String content;
}
