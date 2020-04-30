package com.posts.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

@Entity
@Embeddable
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pos_seq")
    @SequenceGenerator(name = "pos_seq", sequenceName = "SEQ_POS", allocationSize = 10)
    @Column(name = "idofposition", updatable = false, nullable = false)
    private Integer idOfPos;
    @Column(name = "idoforg")
    private Integer idOfOrg;
    @Column(name = "postname")
    private String postName;
    @Column(name = "performedwork")
    private String performedWork;
    @Column(name = "salary")
    private Integer postSalary;
    @Column(name = "workshedule")
    private String workShedule;
    @Column(name = "requirements")
    private String require;
    @Column(name = "areaofwork")
    private String postAreaOfWork;
    @Column(name = "actuality")
    private String postActuality;

    public Integer getIdOfOrg() {
        return idOfOrg;
    }

    public void setIdOfOrg(Integer idOfOrg) {
        this.idOfOrg = idOfOrg;
    }

    public Integer getIdOfPos() {
        return idOfPos;
    }

    public void setIdOfPos(Integer idOfPos) {
        this.idOfPos = idOfPos;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPerformedWork() {
        return performedWork;
    }

    public void setPerformedWork(String performedWork) {
        this.performedWork = performedWork;
    }

    public Integer getPostSalary() {
        return postSalary;
    }

    public void setPostSalary(Integer postSalary) {
        this.postSalary = postSalary;
    }

    public String getWorkShedule() {
        return workShedule;
    }

    public void setWorkShedule(String workShedule) {
        this.workShedule = workShedule;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getPostAreaOfWork() {
        return postAreaOfWork;
    }

    public void setPostAreaOfWork(String postAreaOfWork) {
        this.postAreaOfWork = postAreaOfWork;
    }

    public String getPostActuality() {
        return postActuality;
    }

    public void setPostActuality(String postActuality) {
        this.postActuality = postActuality;
    }

    @Override
    public int hashCode() {
        int result = idOfPos.hashCode();
        result = 31 * result + idOfOrg.hashCode();
        result = 31 * result + postName.hashCode();
        result = 31 * result + performedWork.hashCode();
        result = 31 * result + postSalary.hashCode();
        result = 31 * result + workShedule.hashCode();
        result = 31 * result + require.hashCode();
        result = 31 * result + postAreaOfWork.hashCode();
        result = 31 * result + postActuality.hashCode();
        return result;

    }

    @Override
    public String toString() {
        return "Post{" +
                "idOfPos=" + idOfPos +
                ", idOfOrg='" + idOfOrg + '\'' +
                ", postName='" + postName + '\'' +
                ", performedWork='" + performedWork + '\'' +
                ", postSalary=" + postSalary +
                ", workShedule='" + workShedule + '\'' +
                ", require='" + require + '\'' +
                ", postAreaOfWork='" + postAreaOfWork + '\'' +
                ", postActuality='" + postActuality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(getIdOfPos(), post.getIdOfPos()) &&
                Objects.equals(getIdOfOrg(), post.getIdOfOrg()) &&
                Objects.equals(getPostName(), post.getPostName()) &&
                Objects.equals(getPerformedWork(), post.getPerformedWork()) &&
                Objects.equals(getPostSalary(), post.getPostSalary()) &&
                Objects.equals(getWorkShedule(), post.getWorkShedule()) &&
                Objects.equals(getRequire(), post.getRequire()) &&
                Objects.equals(getPostAreaOfWork(), post.getPostAreaOfWork()) &&
                Objects.equals(getPostActuality(), post.getPostActuality());
    }
}




