package com.challenge.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Table
@Entity(name = "candidate")
@EntityListeners({User.class, Company.class, Acceleration.class})
public class Candidate {

  @EmbeddedId
  private CandidateIdentity candidateIdentity;

  @NotNull
  @Column(name = "status", nullable = true)
  private int status;

  @CreatedDate
  @Column(name = "created_at", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

}