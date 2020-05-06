package com.contracts.model;

import com.posts.model.Post;
import com.clients.model.Client;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Embeddable
@Table(name = "Contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cont_seq")
    @SequenceGenerator(name = "cont_seq", sequenceName = "SEQ_CONT", allocationSize = 10)
    @Column(name = "idofcontract", updatable = false, nullable = false)
    private Integer idOfCont;
    @Column (name = "organization")
    private String organizationName;
    @Column (name = "dateofconclusion")
    private String dateOfConclusion;
    @Column (name = "idofclients")
    private Integer idOfClient;
    @Column (name = "idofpos")
    private Integer idOfPost;

    public Integer getIdOfClient() {
        return idOfClient;
    }

    public void setIdOfClient(Integer idOfClient) {
        this.idOfClient = idOfClient;
    }

    public Integer getIdOfPost() {
        return idOfPost;
    }

    public void setIdOfPost(Integer idOfPost) {
        this.idOfPost = idOfPost;
    }

    public Integer getIdOfCont() {
        return idOfCont;
    }

    public void setIdOfCont(Integer idOfCont) {
        this.idOfCont = idOfCont;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(String dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idOfCont=" + idOfCont +
                ", organizationName='" + organizationName + '\'' +
                ", idOfClient='" + idOfClient + '\'' +
                ", organizationName='" + idOfPost + '\'' +
                ", dateOfConclusion='" + dateOfConclusion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;
        Contract contract = (Contract) o;
        return Objects.equals(getIdOfCont(), contract.getIdOfCont()) &&
                Objects.equals(getOrganizationName(), contract.getOrganizationName()) &&
                Objects.equals(getIdOfClient(), contract.getIdOfClient()) &&
                Objects.equals(getIdOfPost(), contract.getIdOfPost()) &&
                Objects.equals(getDateOfConclusion(), contract.getDateOfConclusion());
    }

    @Override
    public int hashCode() {
        int result = idOfCont.hashCode();
        result = 31 * result + organizationName.hashCode();
        result = 31 * result + idOfClient.hashCode();
        result = 31 * result + idOfPost.hashCode();
        result = 31 * result + dateOfConclusion.hashCode();
        return result;
    }
}
