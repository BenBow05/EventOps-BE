package com.winter25.RSVPmanager25.domain.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private Integer id;

    private String email, phoneNumber, firstName, lastName;
    private Date dob;

}
