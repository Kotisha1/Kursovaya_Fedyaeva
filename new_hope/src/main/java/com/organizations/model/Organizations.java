package com.organizations.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;

@Entity
@Embeddable
@Table(name = "Organizations")
public class Organizations {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_seq")
    @SequenceGenerator(name = "org_seq", sequenceName = "SEQ_ORG", allocationSize = 15)
    @Column(name = "idorg", updatable = false, nullable = false)
    private Integer orgId;
    @Column(name = "nameorg")
    private String orgName;
    @Column(name = "adress")
    private String orgAdress;
    @Column(name = "phone")
    private String orgPhone;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgAdress() {
        return orgAdress;
    }

    public void setOrgAdress(String orgAdress) {
        this.orgAdress = orgAdress;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    @Override
    public String toString() {
        return "Organizations{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", orgAdress='" + orgAdress + '\'' +
                ", orgPhone='" + orgPhone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organizations)) return false;
        Organizations org = (Organizations) o;
        return Objects.equals(getOrgId(), org.getOrgId()) &&
                Objects.equals(getOrgName(), org.getOrgName()) &&
                Objects.equals(getOrgAdress(), org.getOrgAdress()) &&
                Objects.equals(getOrgPhone(), org.getOrgPhone());
    }

    @Override
    public int hashCode() {
        int result = orgId.hashCode();
        result = 31 * result + orgName.hashCode();
        result = 31 * result + orgAdress.hashCode();
        result = 31 * result + orgPhone.hashCode();
        return result;
    }
}