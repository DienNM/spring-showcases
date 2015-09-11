package com.dee.spring.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.dee.spring.security.exception.DuplicatedEntityException;
import com.dee.spring.security.model.CommentModel;
import com.dee.spring.security.service.CommentService;

/**
 * @author dien.nguyen
 **/

@Service("inMemoryCommentService")
public class InMemoryCommentService implements CommentService {

    private ConcurrentMap<Long, CommentModel> commentsRepo = new ConcurrentHashMap<Long, CommentModel>();

    @Override
    public List<CommentModel> getAll() {
        return new ArrayList<CommentModel>(commentsRepo.values());
    }

    @Override
    public CommentModel getById(long id) {
        return commentsRepo.get(id);
    }

    @Override
    public void post(CommentModel comment) {
        comment.setId(new Random().nextLong());
        if(commentsRepo.containsKey(comment.getId())) {
            throw new DuplicatedEntityException();
        }
        commentsRepo.put(comment.getId(), comment);
    }

    @Override
    public void delete(long id) {
        commentsRepo.remove(id);
    }

}
