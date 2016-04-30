package com.sang.topic.controller;

import com.sang.topic.model.Post;
import com.sang.topic.model.Topic;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import com.sang.topic.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arch on 2016/4/29.
 */
@RestController
public class PostController {
    PostService postService = new PostService();
    TopicService topicService = new TopicService();
    UserService userService = new UserService();

    @RequestMapping(value="/p", method = RequestMethod.POST)
    public String create(Post post){
        String flag = "error";
        int n = postService.insert(post);
        if(n > 0)
            flag = "success";
        return flag;
    }

    @RequestMapping(value="/t/{id}/p/new",method = RequestMethod.GET)
    public ModelAndView editNewPost(@PathVariable Integer id, HttpSession httpSession){
        Topic topic = topicService.get(id);
        Map<String, Object> map = new HashMap<>();
        map.put("topic", topic);
        return new ModelAndView("post/editNew", map);
    }

    @RequestMapping(value="/p/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable Integer id){
        Post post = postService.get(id);
        if(post == null)
            return new ModelAndView("post/show");
        Map<String, Object> map = new HashMap<>();
        map.put("post", post);
        map.put("topics", topicService.getAll());
        map.put("user", userService.get(post.getUserId()));
        return new ModelAndView("post/show", map);
    }

}
