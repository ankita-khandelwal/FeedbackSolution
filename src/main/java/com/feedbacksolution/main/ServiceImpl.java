package com.feedbacksolution.main;

import com.feedbacksolution.main.persistence.RepositoryInterface;
import com.feedbacksolution.main.persistence.SampleObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description:
 *
 * @author Created by deepmistry
 *         8/25/15.
 */
public class ServiceImpl implements ServiceInterface {

    @Autowired
    RepositoryInterface repository;

    @Override
    public void createObj(SampleObject obj) {
        repository.save(obj);
    }

    @Override
    public void deleteObj(SampleObject obj) {
        repository.delete(obj);
    }

    @Override
    public Iterable<SampleObject> getAll() {
        return repository.findAll();
    }
}
