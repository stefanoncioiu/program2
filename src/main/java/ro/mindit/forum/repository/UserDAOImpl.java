package ro.mindit.forum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ro.mindit.forum.domain.User;

/**
 * @author adrian.dafinoiu
 * @since 1/5/2018
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User findOne(Long userId) {
        String SQL = "SELECT * FROM USERS WHERE ID = :userID ";

        SqlParameterSource namedParameters = new MapSqlParameterSource("userID", userId);

        return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, (resultSet, i) ->
                        new User(resultSet.getString("USER_NAME"),
                                resultSet.getString("EMAIL"),
                                resultSet.getString("PASSWORD")));
    }

    @Override
    public User findOneByUserName(String userName) {
        String SQL = "SELECT * FROM USERS WHERE USER_NAME = :userName ";

        SqlParameterSource namedParameters = new MapSqlParameterSource("userName", userName);

        return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, (resultSet, i) ->
                new User(resultSet.getString("USER_NAME"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("PASSWORD")));
    }
}
