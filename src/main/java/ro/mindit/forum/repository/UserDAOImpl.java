package ro.mindit.forum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import ro.mindit.forum.domain.Comments;
import ro.mindit.forum.domain.Forum;
import ro.mindit.forum.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                        new User(resultSet.getInt("ID"),
                                resultSet.getString("USER_NAME"),
                                resultSet.getString("EMAIL"),
                                resultSet.getString("PASSWORD")));
    }

    @Override
    public User findOneByUserName(String userName,String password) {
        String SQL = "SELECT * FROM USERS WHERE USER_NAME = :userName and PASSWORD = :password";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("userName", userName)
                .addValue("password",password);

        return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, (resultSet, i) ->
                new User(resultSet.getInt("id"),
                        resultSet.getString("USER_NAME"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("PASSWORD")));
    }

    @Override
    public void insertUser(String userName, String userPassword, String userEmail){

        String SQL = "INSERT INTO USERS(user_name,email,password) VALUES(:user_name,:email,:password)";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("user_name", userName)
                .addValue("email",userEmail)
                .addValue("password",userPassword);


      // JdbcTemplate jdbcTemplate = new JdbcTemplate();
         namedParameterJdbcTemplate.update(SQL,namedParameters);


    }

    @Override
    public void insertContent(String name, String content, int userid, String priority){

        String SQL1 = "SELECT user_name FROM users where ID='"+userid+"'";

        User user = new User();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(SQL1);
        for (Map row : rows) {

            user.setUserName((String)(row.get("user_name")));

        }


        String SQL = "INSERT INTO FORUM(name,owner,priority,content,userid) VALUES(:name,:own,:prio,:cont,:userid)";

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", name)
                .addValue("own", user.getUserName())
                .addValue("prio",priority)
                .addValue("cont",content)
                .addValue("userid",userid);



        namedParameterJdbcTemplate.update(SQL,namedParameters);

    }


    @Override
    public List<Forum> findAll() {
        String SQL = "SELECT forum.id, name, owner, priority, content, user_name from forum join users on userid=users.id order by priority ";

        RowMapper<Forum> rowMapper = new BeanPropertyRowMapper<Forum>(Forum.class);
        return this.jdbcTemplate.query(SQL, rowMapper);

    }


    @Override
    public List<Forum> findOneForum(int id){

        String SQL= "SELECT * FROM FORUM where ID= ? ";
        SqlParameterSource namedParameters = new MapSqlParameterSource("forumID", id);
        RowMapper<Forum> rowMapper = new BeanPropertyRowMapper<Forum>(Forum.class);
        return this.jdbcTemplate.query(SQL, rowMapper,id);


    }

    @Override
    public void insertComment(String comment, int id, int userid){

        String SQL1 = "SELECT user_name FROM users where ID='"+userid+"'";

        User user = new User();
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(SQL1);
        for (Map row : rows) {

            user.setUserName((String)(row.get("user_name")));

        }

        String SQL= "INSERT INTO COMMENTS(comment,id_forum,userid,username) values(:comment, :id_forum, :user_id, :user_name)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("comment", comment)
                .addValue("id_forum", id)
                .addValue("user_id", userid)
                .addValue("user_name", user.getUserName());



        // JdbcTemplate jdbcTemplate = new JdbcTemplate();
        namedParameterJdbcTemplate.update(SQL,namedParameters);
    }

    @Override
    public List<Comments> getComments(int id){

        String SQL= "SELECT * FROM comments where id_forum= ? ";
        RowMapper<Comments> rowMapper = new BeanPropertyRowMapper<Comments>(Comments.class);
        return this.jdbcTemplate.query(SQL, rowMapper,id);
    }



    @Override
    public List<Forum>getFromForum(int id){
        String SQL= "Select * from forum where userid=?";
        RowMapper<Forum> rowMapper = new BeanPropertyRowMapper<Forum>(Forum.class);
        return this.jdbcTemplate.query(SQL, rowMapper,id);
    }


    @Override
    public void deleteForum(int id){
        String SQL= "DELETE FROM Forum where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", id);

        namedParameterJdbcTemplate.update(SQL,namedParameters);

    }

    public void updateForum(int id, String numef, String content, String priority){
        System.out.println("Numele update:  "+numef+"  "+content+"  "+priority+"  "+id);
        String SQL="update forum set name=:namef, priority=:priority, content=:content where id=:id";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("namef", numef)
                .addValue("priority", priority)
                .addValue("content", content)
                .addValue("id", id);
        namedParameterJdbcTemplate.update(SQL,namedParameters);

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
