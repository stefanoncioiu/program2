package ro.mindit.forum.domain;

import java.io.Serializable;


public class Comments implements Serializable {

    private int id;
    private int id_forum;
    private String comment;
    private int userid;
    private String username;



    public Comments() {
    }

    public Comments(int id, int id_forum,String comment,int userid, String uname ) {
        this.id=id;
        this.id_forum = id_forum;
        this.comment = comment;
        this.userid= userid;
        this.username=uname;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comments) {
        this.comment = comments;
    }

    public int getidForum() { return id_forum;    }

    public void setidForum(int id) {
        this.id_forum = id;
    }

    public int getUserId() { return userid;    }

    public void setUserId(int id) {
        this.userid = id;
    }

    public String getUsername() { return username;    }

    public void setUsername(String user){this.username=user;}


}
