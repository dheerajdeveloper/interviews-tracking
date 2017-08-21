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
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    long userId;

    String companyName;

    String companyLocation;

    String currentStatus;

    String overallStatus;

    String finalFeedback;

    Date createdOn;

    Date updatedOn;
}
