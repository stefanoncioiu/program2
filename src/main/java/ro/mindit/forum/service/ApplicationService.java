package ro.mindit.forum.service;

import ro.mindit.forum.domain.Comments;
import ro.mindit.forum.domain.Forum;
import ro.mindit.forum.domain.User;

import java.util.List;

/**
 *
 * @author adrian.dafinoiu
 * @since 1/5/2018
 */
public interface ApplicationService {

    String getProjectName();
    String getProjectAuthor();
    String getProjectWebsite();
    User getUserByUserName(String userName,String password);
    void putUserIntoDb(User user);//String userName, String userPassword, String userEmail);
    void putContentIntoDb(String name, String content, int userid, String priority);
    List<Forum> getAllFromForum();
    List<Forum> getOneFromForum(int id);
    void putCommentIntoDb(String comment, int id, int userid);
    List<Comments> getAllComments(int id);
    List<Forum> getFromForum(int id);
    void deleteFromForum(int id);
    void updateForum(int id,String nameForum, String content, String priority);
}
