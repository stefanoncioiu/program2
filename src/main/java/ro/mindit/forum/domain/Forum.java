package ro.mindit.forum.domain;

import java.io.Serializable;

public class Forum implements Serializable{

        private int id;
        private String name;
        private String owner;
        private String priority;
        private String content;

        public Forum() {
        }

        public Forum(String name, String owner, String prioirity,String content ) {
            this.id=id;
            this.name = name;
            this.owner = owner;
            this.priority = priority;
            this.content=content;
        }

        public int getId() {
        return id;
    }

        public void setId(int id) {
        this.id = id;
    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public String getContent() {
        return content;
    }

        public void setContent(String content) {
        this.content = content;
    }
}
