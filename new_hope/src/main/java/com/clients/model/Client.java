package com.clients.model;

import com.contracts.model.Contract;
import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

@Entity
@Embeddable
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName="SEQ_CLIENT", allocationSize = 10)
    @Column (name = "client_id", updatable=false, nullable=false)
    private Integer clientId;
    @Column (name = "client_name")
    private String clientName;
    @Column (name = "date_of_birth")
    private String dateOfBirth;
    @Column (name = "education")
    private String education;
    @Column (name = "experience")
    private String experience;
    @Column (name = "area_of_work")
    private String areaOfWork;
    @Column (name = "skills")
    private String skills;
    @Column (name = "phone")
    private String phone;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAreaOfWork() {
        return areaOfWork;
    }

    public void setAreaOfWork(String areaOfWork) {
        this.areaOfWork = areaOfWork;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "Client{" +
                "clientId=" + clientId +
                ", name=" + clientName + '\'' +
                ", dateOfBirth=" + dateOfBirth + '\'' +
                ", education=" + education + '\'' +
                ", experience=" + experience + '\'' +
                ", areaOfWork=" + areaOfWork + '\'' +
                ", skills=" + skills + '\'' +
                ", phone=" + phone + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getClientId(), client.getClientId()) &&
                Objects.equals(getClientName(), client.getClientName()) &&
                Objects.equals(getDateOfBirth(), client.getDateOfBirth()) &&
                Objects.equals(getEducation(), client.getEducation()) &&
                Objects.equals(getExperience(), client.getExperience()) &&
                Objects.equals(getAreaOfWork(), client.getAreaOfWork()) &&
                Objects.equals(getSkills(), client.getSkills()) &&
                Objects.equals(getPhone(), client.getPhone());
    }

    @Override
    public int hashCode() {
        int result = clientId.hashCode();
        result = 31 * result + clientName.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + education.hashCode();
        result = 31 * result + experience.hashCode();
        result = 31 * result + areaOfWork.hashCode();
        result = 31 * result + skills.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}