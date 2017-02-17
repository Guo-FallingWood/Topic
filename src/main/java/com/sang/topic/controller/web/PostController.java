package com.sang.topic.controller.web;

import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.model.ValidationResponse;
import com.sang.topic.service.CommentsService;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import com.sang.topic.service.UserService;
import com.sang.topic.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/p")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    TopicService topicService;
    @Autowired
    private UserService userService;
    @Autowired
    CommentsService commentsService;

    /**
     * 发表帖子
     *
     * @param post
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ValidationResponse create(@ModelAttribute @Valid Post post, BindingResult bindingResult, HttpSession httpSession) {
        if(bindingResult.hasErrors())
            return ResponseUtil.failFieldValidation(bindingResult);
        User user = (User) httpSession.getAttribute("sessionUser");
        return postService.create(post, user.getId());
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView editNewPost(Integer topicId) {
        if (topicId == null)
            topicId = 1;
        Topic topic = topicService.get(topicId);
        Map<String, Object> map = new HashMap<>();
        map.put("topic", topic);
        return new ModelAndView("post/editNew", map);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable Integer id) {
        Post post = postService.get(id);
        if (post == null)
            return new ModelAndView("post/show");
        Map<String, Object> map = new HashMap<>();
        map.put("post", post);
        map.put("topics", topicService.getAll());
        map.put("user", userService.get(post.getUserId()));
        map.put("comments", commentsService.getCommentsByPostId(id));
        return new ModelAndView("post/show", map);
    }

}
