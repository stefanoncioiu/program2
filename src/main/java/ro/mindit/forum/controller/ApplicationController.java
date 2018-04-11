package ro.mindit.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.mindit.forum.domain.Comments;
import ro.mindit.forum.domain.Forum;
import ro.mindit.forum.domain.User;
import ro.mindit.forum.service.ApplicationService;

import java.util.HashMap;
import java.util.List;
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
	public @ResponseBody User getUser(@RequestParam(name = "userName") String userName, String password) {


		logger.info("Querying /user ");
		User user = applicationService.getUserByUserName(userName, password);

		return user;
	}

	@RequestMapping("/putUserIntoDb")
	public @ResponseBody void addUser(String userName, String password,String email){
		logger.info("Quering/adduser "+ userName);
		User user1 = new User();
		user1.setEmail(email);
		user1.setPassword(password);
		user1.setUserName(userName);
		applicationService.putUserIntoDb(user1);

	}

	@RequestMapping("/putContentIntoDb")
	public @ResponseBody void addContent(String nameForum, String content, int userid, String priority){
		logger.info("Quering/addcontent ");
		applicationService.putContentIntoDb(nameForum,content,userid,priority);

	}

	@RequestMapping("/forum")
	public @ResponseBody List<Forum> getForum() {


		logger.info("Querying /user ");
		List<Forum> forum = applicationService.getAllFromForum();

		return forum;
	}

	@RequestMapping("/forumid")
	public @ResponseBody  List<Forum> getForumID(int id) {


		logger.info("Querying /forumid ");
		List<Forum> forum = applicationService.getOneFromForum(id);

		return forum;
	}

	@RequestMapping("/putCommentIntoDb")
	public @ResponseBody void addComment(String comment, int id, int userid){
		logger.info("Quering/addcontent ");
		applicationService.putCommentIntoDb(comment,id, userid);

	}

	@RequestMapping("/getComments")
	public @ResponseBody List<Comments> getComments(int id) {


		logger.info("Querying /getComments ");
		List <Comments> forum = applicationService.getAllComments(id);

		return forum;
	}

	@RequestMapping("/getProfile")
	public @ResponseBody List<Forum> getProfile(int id) {


		logger.info("Querying /getComments ");
		List <Forum> forum = applicationService.getFromForum(id);

		return forum;
	}


	@RequestMapping("/deleteFromForum")
	public @ResponseBody void deleteForum(int id) {


		logger.info("Querying /getComments ");
		 applicationService.deleteFromForum(id);

	}

	@RequestMapping("/updateForum")
	public @ResponseBody void updateForum(int id,String nameForum, String content, String priority) {


		logger.info("Querying /update ");
		applicationService.updateForum(id,nameForum,content,priority);

	}

}
