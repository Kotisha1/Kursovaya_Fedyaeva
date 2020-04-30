package com.posts.dao;

import com.posts.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class PostDao {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(PostDao.class));

    @SuppressWarnings("unchecked")
    public List<Post> listPost() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Post> postList = session.createQuery("SELECT p FROM Post p").list();
        for(Post p: postList){
            logger.info(p.toString());
        }
        return postList;
    }

    public void addPost(Post post) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(post);
        logger.info("Post successfully added." +
                "Post: " + post);
    }

    public void updatePost(Post post){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(post);
        logger.info("Post INFO successfully changed." +
                "Post: " + post);
    }

    public void removePost(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Post post = (Post) session.load(Post.class, new Integer(id));
        if(post != null) {
            session.delete(post);
        }
        logger.info("Post INFO successfully deleted." +
                "Post: " + post);
    }

    public Post getPostById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Post post = (Post) session.load(Post.class, new Integer(id));
        logger.info("Post: " + post);
        return post;
    }
}
