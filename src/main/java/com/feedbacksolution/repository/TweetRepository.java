package com.feedbacksolution.repository;

import com.feedbacksolution.model.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author deepmistry on 2/28/16.
 */
public interface TweetRepository extends MongoRepository<Tweet, String> {
}
