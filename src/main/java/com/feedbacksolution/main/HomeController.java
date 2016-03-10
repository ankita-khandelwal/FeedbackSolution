package com.feedbacksolution.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.feedbacksolution.twitter.TwitterFeedRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    TwitterFeedRead twitterFeedRead;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/readTweet", method = RequestMethod.GET)
    public String readTweet() {
        try {
			logger.info(twitterFeedRead.getSingleTweet());
		} catch (InterruptedException e) {
            logger.error("Feed read interrupted");
        }
        return "home";
    }
	
}
