package com.beta.wheelsup.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by mburns on 1/19/16.
 */


@Entity
public class SalesPerson {


    private static final long serialVersionUID = -524993539506003057L;

    @Id
    @GeneratedValue
    @Column(name = "salesPersonId", unique = true)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String cellPhone;

    private Integer status;

    private String department;

    private Boolean isAccountManager = false;

    private Boolean isSalesTeamLead = false;

    private String imageUrl;

    private Date imageUpdateDate;

    private String company;

    private Boolean isActive;

    /*
    Accessor Methods
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getAccountManager() {
        return isAccountManager;
    }

    public void setAccountManager(Boolean accountManager) {
        isAccountManager = accountManager;
    }

    public Boolean getSalesTeamLead() {
        return isSalesTeamLead;
    }

    public void setSalesTeamLead(Boolean salesTeamLead) {
        isSalesTeamLead = salesTeamLead;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getImageUpdateDate() {
        return imageUpdateDate;
    }

    public void setImageUpdateDate(Date imageUpdateDate) {
        this.imageUpdateDate = imageUpdateDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}