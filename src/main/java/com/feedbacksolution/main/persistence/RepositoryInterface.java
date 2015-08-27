package com.feedbacksolution.main.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Description: Spring Data Repository class used for persistence for database persistence layer
 *
 * @link {http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html}
 *
 * @author Created by deepmistry
 *         8/25/15.
 */

public interface RepositoryInterface extends CrudRepository<SampleObject, Long>{}
