package com.feedbacksolution.main;

import com.feedbacksolution.twitter.TwitterFeedRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deepmistry on 3/10/16.
 */

@RestController
public class FeedController {

    private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

    @Autowired
    TwitterFeedRead twitterFeedRead;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/readTweet", method = RequestMethod.GET)
    public String readTweet() {
        String returnedTweet = "";
        try {
            returnedTweet = twitterFeedRead.getSingleTweet();
            logger.info(returnedTweet);
        } catch (InterruptedException e) {
            logger.error("Feed read interrupted");
        }
        return returnedTweet;
    }
}
