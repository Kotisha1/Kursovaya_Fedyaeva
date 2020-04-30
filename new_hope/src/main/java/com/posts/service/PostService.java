package com.posts.service;

import com.posts.dao.PostDao;
import com.posts.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDao postDAO;

    public void setPostDAO(PostDao postDAO) {
        this.postDAO = postDAO;
    }

    @Transactional
    public List<Post> listPost() {
        return this.postDAO.listPost();
    }

    @Transactional
    public void addPost(Post post) { this.postDAO.addPost(post);}

    @Transactional
    public void updatePost(Post post) { this.postDAO.updatePost(post);}

    @Transactional
    public void removePost(int id) { this.postDAO.removePost(id);}

    @Transactional
    public Post getPostById(int id) { return this.postDAO.getPostById(id);}
}
