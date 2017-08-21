package com.interview.tracking.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by dheeraj on 21/08/17.
 */

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String username;

    String emailId;

    String mobileNo;

    String currentCompany;

    String experienceYears;

    String currentCtc;

    String technologiesKnown;

    String professionType;

    Date createdOn;

    Date updatedOn;


}
