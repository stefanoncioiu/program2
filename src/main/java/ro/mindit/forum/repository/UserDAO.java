package ro.mindit.forum.repository;

import ro.mindit.forum.domain.User;

/**
 * @author adrian.dafinoiu
 * @since 1/5/2018
 */
public interface UserDAO {

    User findOne(Long userId);

    User findOneByUserName(String userName);
}
