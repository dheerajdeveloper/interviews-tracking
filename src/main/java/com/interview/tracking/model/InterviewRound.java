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
public class InterviewRound {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    long interviewId;

    String roundName;

    String roundStatus;

    String rounfFeedback;

    String roundQuestions;

    String interviewDate;

    Date createdOn = new Date();

    Date updatedOn;


}
