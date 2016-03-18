package com.feedbacksolution.twitter;

import com.feedbacksolution.main.TwitterAppConstants;
import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author Created by deepmistry
 *         2/21/16.
 */
@Component
public class TwitterFeedRead {

    private Client client;
    BlockingQueue<String> queue;

    @Autowired
    TwitterFeedRead(@Value("${feed.trackTerm}") String trackTerm){
        // Need 100 ? What if more than 100 requests per second.
        queue = new LinkedBlockingQueue<String>(100);
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(Lists.newArrayList(trackTerm));
        Authentication auth = new OAuth1(TwitterAppConstants.CONSUMER_KEY, TwitterAppConstants.CONSUMER_SECRET, TwitterAppConstants.ACCESS_TOKEN, TwitterAppConstants.ACCESS_TOKEN_SECRET);
        client = new ClientBuilder()
                .hosts(Constants.STREAM_HOST)
                .endpoint(endpoint)
                .authentication(auth)
                .processor(new StringDelimitedProcessor(queue))
                .build();

        client.connect();
    }

    private static Logger logger = LoggerFactory.getLogger(TwitterFeedRead.class);

    public String getSingleTweet() throws InterruptedException {

        if (client.isDone()) {
            logger.warn("Client connection closed unexpectedly");
            return null;
        }

        String msg = queue.poll(5, TimeUnit.SECONDS);
        if (msg == null) {
            System.out.println("Did not receive a message in 5 seconds");
        }
        return msg;
    }

    public static void main(String[] args) {
        //TwitterFeedRead.run(args[0], args[1], args[2], args[3]);
    }
}
