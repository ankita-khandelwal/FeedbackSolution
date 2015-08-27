package com.feedbacksolution.main;

import com.feedbacksolution.main.persistence.SampleObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: Service interface to define the Service layer
 *
 * @link {}
 *
 * @author Created by deepmistry
 *         8/25/15.
 */

public interface ServiceInterface {

    void createObj(SampleObject add);

    void deleteObj(SampleObject add);

    Iterable<SampleObject> getAll();

    SampleObject getObjById(Long id);
}
