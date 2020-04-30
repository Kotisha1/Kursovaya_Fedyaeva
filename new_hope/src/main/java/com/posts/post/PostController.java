package com.posts.post;

import com.posts.model.Post;
import com.posts.dao.PostDao;
import com.posts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.logging.Logger;

@ImportResource("/WEB-INF/dispatcher-servlet.xml")
@Controller("/posts")
public class PostController {
    private PostService postService;

    Logger logger = Logger.getLogger(String.valueOf(PostDao.class));

    @Autowired()
    @Qualifier(value = "postService")
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value ={"/posts"}, method = RequestMethod.GET)
    public String listPosts(Model model) {
        try {
        model.addAttribute("post", new Post());
        model.addAttribute("list", this.postService.listPost());
        } catch (Exception error){
            return "/error";
        }
        return "/posts";
    }

    @RequestMapping(value ="/posts", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("post") Post s) {
        try {
            if (s.getIdOfPos() == null) {
                this.postService.addPost(s);
            } else {
                this.postService.updatePost(s);
            }
        } catch (Exception error){
            return "/error";
        }
        return "redirect:/posts";
    }

    @RequestMapping("/deleteP/{id}")
    public String removePost(@PathVariable("id") int id) {
        try {
            this.postService.removePost(id);
        } catch (Exception error){
            return "/PostError";
        }
            return "redirect:/posts";
    }

    @RequestMapping("/editP/{id}")
    public String editPost(Model model, @PathVariable("id") int id) {
        try {
        model.addAttribute("post", this.postService.getPostById(id));
        model.addAttribute("list", this.postService.listPost());
        } catch (Exception error){
            return "/error";
        }
        return "/posts";
    }
}
