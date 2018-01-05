package ro.mindit.forum.service;

import ro.mindit.forum.domain.User;

/**
 *
 * @author adrian.dafinoiu
 * @since 1/5/2018
 */
public interface ApplicationService {

    String getProjectName();
    String getProjectAuthor();
    String getProjectWebsite();
    User getUserByUserName(String userName);

}
