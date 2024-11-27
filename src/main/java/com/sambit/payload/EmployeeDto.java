package com.sambit.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class EmployeeDto {
    @Getter
    @Setter
    private long id;

    @NotBlank
    @Size(min =3, message = "At least 3 characters required")
    private String name;

    @Email
    private String emailId;

    @Size(min =10, max=10,message = "should be 10 digits required")
    private String mobile;
  //  private Date date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}

