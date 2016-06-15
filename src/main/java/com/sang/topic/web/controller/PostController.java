package com.sang.topic.web.controller;

import com.sang.topic.model.Post;
import com.sang.topic.model.Topic;
import com.sang.topic.model.User;
import com.sang.topic.service.CommentsService;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import com.sang.topic.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {
    PostService postService = new PostService();
    TopicService topicService = new TopicService();
    UserService userService = new UserService();
    CommentsService commentsService = new CommentsService();

    @RequestMapping(value="/p", method = RequestMethod.POST)
    public Map<String, Object> create(@ModelAttribute Post post, HttpSession httpSession){
        Map<String, Object> resultMap = new HashMap<>();
        boolean success = false;
        String message = "";
        User user = (User) httpSession.getAttribute("sessionUser");
        if(user != null) {
            post.setUserId(user.getId());
            post.setContent(HtmlUtils.htmlEscape(post.getContent()));
            int n = postService.insert(post);
            if (n > 0)
                success = true;
            else message = "发帖失败";
        }else{
            message = "请登录后在发帖";
        }
        resultMap.put("success", success);
        resultMap.put("message", message);
        return resultMap;
    }

    @RequestMapping(value="/p/new",method = RequestMethod.GET)
    public ModelAndView editNewPost(Integer topicId){
        if(topicId == null)
            topicId = 1;
        Topic topic = topicService.get(topicId);
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
        map.put("comments", commentsService.getCommentsByPostId(id));
        return new ModelAndView("post/show", map);
    }

}
