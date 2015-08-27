package com.feedbacksolution.main;

import com.feedbacksolution.main.persistence.RepositoryInterface;
import com.feedbacksolution.main.persistence.SampleObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author Created by deepmistry
 *         8/25/15.
 */

@Service
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

    @Override
    public SampleObject getObjById(Long id) {
        return repository.findOne(id);
    }
}
