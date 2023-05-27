package com.cwr.service;

import com.cwr.dao.PostDao;
import com.cwr.model.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    @Autowired
    private final PostDao postDao;

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<PostDto> getListPost(String type) {
        return postDao.getListPost(type);
    }
    public PostDto getPostById(Integer id) {
        return postDao.getPostById(id);
    }
    public boolean deletePostById(Integer id) {
        return postDao.deletePostById(id);
    }
}
