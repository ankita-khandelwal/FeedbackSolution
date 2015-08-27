package com.feedbacksolution.main;

import java.util.Locale;

import com.feedbacksolution.main.persistence.SampleObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests for the application home page.
 * Presentation Layer in Spring
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    ServiceInterface service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.debug("Test: In home method");

        return "home";
    }

    @RequestMapping(value = "/get/{_id}", method = RequestMethod.GET)
    public @ResponseBody String get(@PathVariable Long _id) {                   // change @ResponseBody to SampleObject since that will be used by the frontend.
        logger.debug("in get method");

        SampleObject object = service.getObjById(_id);

        return object.toString();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody SampleObject obj) {
        logger.debug("in create method");

        service.createObj(obj);

    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SampleObject obj) {
        logger.debug("in create method");

        service.createObj(obj);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody SampleObject obj) {
        logger.debug("in delete method");

        service.deleteObj(obj);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Iterable<SampleObject> list() {
        logger.debug("in create method");

        return service.getAll();
    }
	
}
