package com.tencent.tars.client.testapp.model;
import java.util.Date;

public class Post {
    private int pid; 
    private String title;
    private int author;
    private String content;
    private Date publish; 

    public int getPid() {
        return this.pid;
    }
    public String getTitle(){
        return this.title;
    }
    public int getAuthor(){
        return this.author;
    }
    public String getContent(){
        return this.content;
    }
    public Date getPublish(){
        return this.publish;
    }
    public void setPid(int pid){
        this.pid = pid;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(int author){
        this.author = author;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setPublish(Date publish){
        this.publish = publish;
    }
    @Override 
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()){
                return false;
            }
            final Post other = (Post) obj;
            // just check if pk same
            return this.pid == other.pid;
        }

        @Override
        public String toString() {
            return "";
        }

  

}