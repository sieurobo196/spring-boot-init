package com.cwr.dao;

import com.cwr.model.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PostDto> getListPost(String type) {
        String query = "select * from codewr_com.articles where isDeleted=0 and isSubmit=1 and type=? order by id";
        Object[] params = new Object[]{type};

        return jdbcTemplate.query(query, params, (rs, rowNum) -> {
            PostDto postDto = new PostDto();
            postDto.setId(rs.getInt("id"));
            postDto.setTitle(rs.getString("title"));
            postDto.setUrl(rs.getString("map_url"));
            postDto.setType(rs.getString("type"));
            return postDto;
        });
    }

    public PostDto getPostById(Integer id) {
        String query = "select * from codewr_com.articles where id=?";
        Object[] params = new Object[]{id};

        return jdbcTemplate.queryForObject(query, params, (rs, rowNum) -> {
            PostDto postDto = new PostDto();
            postDto.setId(rs.getInt("id"));
            postDto.setTitle(rs.getString("title"));
            postDto.setUrl(rs.getString("map_url"));
            postDto.setType(rs.getString("type"));
            postDto.setContent(rs.getString("content"));
            return postDto;
        });
    }

    public boolean deletePostById(Integer id) {
        try {

            String query = "UPDATE codewr_com.articles SET isDeleted = 1  WHERE id = ?";
            jdbcTemplate.update(query, id);
            return true;
        }catch (Exception exception) {

            return  false;
        }

    }
}
