package ro.mindit.forum.repository;

import ro.mindit.forum.domain.Comments;
import ro.mindit.forum.domain.Forum;
import ro.mindit.forum.domain.User;

import java.util.List;

/**
 * @author adrian.dafinoiu
 * @since 1/5/2018
 */
public interface UserDAO {

    User findOne(Long userId);
    User findOneByUserName(String userName, String password);
    void insertUser(String userName, String userPassword, String userEmail);
    void insertContent(String name, String content, int userid, String priority);
    List<Forum> findAll();
    List<Forum> findOneForum(int id);
    void insertComment(String comment, int id, int userid);
    List<Comments> getComments(int id);
    List<Forum> getFromForum(int id);
    void deleteForum(int id);
    void updateForum(int id, String numef, String content, String priority);
}
