package com.challenge.entity;

import java.io.Serializable;
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
@Entity(name = "submission")
@EntityListeners({User.class, Challenge.class})
public class Submission implements Serializable {

  @EmbeddedId
  private SubmissionIdentity submissionIdentity;

  @NotNull
  @Column(name = "score", nullable = false)
  private Float score;

  @CreatedDate
  @Column(name = "created_at", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;
}