package com.dee.spring.security.service;

import java.util.List;

import com.dee.spring.security.model.CommentModel;

/**
 * @author dien.nguyen
 **/

public interface CommentService {
    
    List<CommentModel> getAll();
    
    CommentModel getById(long id);
    
    void post(CommentModel comment);
    
    void delete(long id);
    
}
