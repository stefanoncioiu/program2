package ro.mindit.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import ro.mindit.forum.domain.User;
import ro.mindit.forum.repository.UserDAO;

/**
 * @author adrian.dafinoiu
 * @since 1/3/2018
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

	@Value("${project.name}")
	private String projectName;

	@Value("${project.author}")
	private String projectAuthor;

	@Value("${project.website}")
	private String projectWebsite;

	@Autowired
	UserDAO userDAO;

	public ApplicationServiceImpl() { }

	@Override
	public String getProjectName() {
		return projectName;
	}

	@Override
	public String getProjectAuthor() {
		return projectAuthor;
	}

	@Override
	public String getProjectWebsite() {
		return projectWebsite;
	}

	@Override
	public User getUserByUserName(String userName) {
		return userDAO.findOneByUserName(userName);
	}

}
