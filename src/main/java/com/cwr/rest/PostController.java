package com.cwr.rest;

import com.cwr.dao.LanguageDto;
import com.cwr.model.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cwr.service.PostService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = {"/languages"})
    public List<LanguageDto> getListLanguagues() {
        List<LanguageDto> languageDtos = new ArrayList<>();
        languageDtos.add(LanguageDto.builder()
                .name("JAVA")
                .description("Java is a high-level, object-oriented programming language." +
                        "Java is used to develop mobile apps, web apps, desktop apps, games and much more.")
                .url("java").build());
        languageDtos.add(LanguageDto.builder()
                .name("CSS")
                .description("CSS (Cascading Style Sheets) is a style sheet language used to describe the presentation of a document written in HTML  or XML")
                .url("css").build());
        languageDtos.add(LanguageDto.builder()
                .name("PYTHON")
                .description("Python is a high-level, interpreted programming language that is widely used for a variety of purposes, including web development, data analysis, machine learning, artificial intelligence, scientific computing.")
                .url("python").build());
        languageDtos.add(LanguageDto.builder()
                .name("JAVASCRIPT")
                .description("JavaScript is a popular high-level programming language that is primarily used for creating dynamic and interactive web pages.")
                .url("javascript").build());

        languageDtos.add(LanguageDto.builder()
                .name("TYPESCRIPT")
                .description("TypeScript is an open-source programming language that is a superset of JavaScript")
                .url("javascript").build());
        languageDtos.add(LanguageDto.builder()
                .name("SPRING")
                .description("Spring is an open-source application framework for building enterprise-level Java applications.")
                .url("spring").build());
        languageDtos.add(LanguageDto.builder()
                .name("ANDROID")
                .description("Android is an open-source operating system designed primarily for mobile devices, such as smartphones and tablets.")
                .url("android").build());
        languageDtos.add(LanguageDto.builder()
                .name("FLUTTER")
                .description("Flutter is an open-source mobile application development framework created by Google.")
                .url("flutter").build());

        languageDtos.add(LanguageDto.builder()
                .name("MYSQL")
                .description("MySQL is an open-source relational database management system (RDBMS) that uses SQL (Structured Query Language) for querying, managing and manipulating data.")
                .url("mysql").build());

        languageDtos.add(LanguageDto.builder()
                .name("SQL-SERVER")
                .description("SQL Server is a relational database management system (RDBMS) developed by Microsoft. It is a powerful database management system that is widely used by businesses and organizations of all sizes.")
                .url("sql-server").build());
        languageDtos.add(LanguageDto.builder()
                .name("ORACLE")
                .description("Oracle is a relational database management system (RDBMS) developed by Oracle Corporation. It is a powerful and popular database management system that is widely used by businesses and organizations around the world.")
                .url("oracle").build());
        languageDtos.add(LanguageDto.builder()
                .name("POSTGRESQL")
                .description("PostgreSQL, also known as Postgres, is an open-source relational database management system (RDBMS) that uses and extends the SQL language for querying, managing, and manipulating data.")
                .url("postgresql").build());
        return languageDtos;
    }

    @GetMapping(value = {"/list"})
    public List<PostDto> getListPost(@RequestParam String type) {
        return postService.getListPost(type);
    }



    @GetMapping(value = {"/{id}"})
    public PostDto getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @DeleteMapping(value = {"/{id}"})
    public boolean deletePostById(@PathVariable Integer id) {
        return postService.deletePostById(id);
    }

}
