package com.dee.spring.security.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dee.spring.security.exception.DuplicatedEntityException;
import com.dee.spring.security.model.CommentModel;
import com.dee.spring.security.service.CommentService;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping(value = "/comments")
public class CommentController {

    private final static String FAILURE_K = "failure";
    private final static String SUCCESS_K = "success";

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllComments(Model model) {
        List<CommentModel> comments = commentService.getAll();
        model.addAttribute("comments", comments);
        return "comments";
    }

    @RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
    public String getCommentDetail(@PathVariable("commentId") long commentId, Model model) {
        CommentModel comment = commentService.getById(commentId);
        if (comment == null) {
            model.addAttribute(FAILURE_K, String.format("Comment %s not found", commentId));
            return "comment_404";
        }
        model.addAttribute("comment", comment);
        return "comment_detail";
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String getPostCommentForm(Model model) {
        model.addAttribute("comment", new CommentModel());
        return "comment_post";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postComment(@ModelAttribute("comment") CommentModel comment, RedirectAttributes redirectAtt) {
        try {
            commentService.post(comment);
            redirectAtt.addAttribute(SUCCESS_K, "Posted the comment successfully");
        } catch (DuplicatedEntityException e) {
            redirectAtt.addAttribute(FAILURE_K, "The comment is duplicated");
        }
        return "redirect:/comments";
    }
    
    @RequestMapping(value = "/{commentId}", method = RequestMethod.POST)
    public String deleteComment(@PathVariable("commentId") long commentId, RedirectAttributes redirectAtt) {
        commentService.delete(commentId);
        redirectAtt.addAttribute(SUCCESS_K, "Deleted the comment successfully");
        return "redirect:/comments";
    }
}
