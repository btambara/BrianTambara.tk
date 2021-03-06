package com.tambara.omoikane.model.contact;

import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@ToString
public class Contact extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 564673772121056521L;

    //Purpose: Unique ID
    //Data Type: long
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cid;

    //Purpose: First name
    //Data Type: String
    @NotNull
    private String firstName;

    //Purpose: Last name
    //Data Type: String
    @NotNull
    private String lastName;

    //Purpose: Personal email
    //Data Type: String
    @NotNull
    private String email;

    //Purpose: Github web address
    //Data Type: String
    @NotNull
    private String githubAddress;

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
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

    public String getGithubAddress() {
        return githubAddress;
    }

    public void setGithubAddress(String githubAddress) {
        this.githubAddress = githubAddress;
    }
}
