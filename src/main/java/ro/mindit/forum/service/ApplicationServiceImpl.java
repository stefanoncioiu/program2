package ro.mindit.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import ro.mindit.forum.domain.Comments;
import ro.mindit.forum.domain.Forum;
import ro.mindit.forum.domain.User;
import ro.mindit.forum.repository.UserDAO;

import java.util.List;

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
	public User getUserByUserName(String userName, String password) {
		return userDAO.findOneByUserName(userName,password);
	}

	@Override
	public void putUserIntoDb( User user ){//String userName, String userPassword, String userEmail){

		userDAO.insertUser(user.getUserName(),user.getPassword(),user.getEmail());//userName,userPassword,userEmail);
	}

	@Override
	public void putContentIntoDb( String name, String content, int userid, String priority ){//String userName, String userPassword, String userEmail){

		userDAO.insertContent(name,content,userid,priority);//userName,userPassword,userEmail);
	}

	@Override
	public List<Forum> getAllFromForum(){
		return userDAO.findAll();
	}

	@Override
	public List<Forum> getOneFromForum(int id){ return userDAO.findOneForum(id);}

	@Override
	public void putCommentIntoDb(String comment, int id, int userid){userDAO.insertComment(comment,id, userid);}

	@Override
	public List<Comments> getAllComments(int id){return userDAO.getComments(id);}

	@Override
	public List<Forum> getFromForum(int id){return userDAO.getFromForum(id);}

	@Override
	public void deleteFromForum(int id){ userDAO.deleteForum( id);}

	@Override
	public void updateForum(int id, String numef, String content, String priority ){userDAO.updateForum(id,numef,content,priority);}
}
