package ro.mindit.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.mindit.forum.domain.User;
import ro.mindit.forum.service.ApplicationService;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author adrian.dafinoiu
 * @since 1/3/2018
 */
@Controller
public class ApplicationController {

	private Logger logger = Logger.getLogger(getClass().getName());

	private final ApplicationService applicationService;

	@Autowired
	public ApplicationController(ApplicationService applicationService) {
		this.applicationService = applicationService;
	}

	@RequestMapping("/config")
	public @ResponseBody Map<String,String> config() {
		Map<String, String> params = new HashMap<>();

		params.put("projectName", applicationService.getProjectName());
		params.put("projectAuthor", applicationService.getProjectAuthor());
		params.put("projectWebsite", applicationService.getProjectWebsite());

		logger.info("Querying /config");

		return params;
	}

	@RequestMapping("/user")
	public @ResponseBody User getUser(@RequestParam(name = "userName") String userName) {


		logger.info("Querying /user");
		User user = applicationService.getUserByUserName(userName);

		return user;
	}

}
