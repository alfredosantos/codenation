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
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Data
@Getter
@Setter
@EntityListeners({User.class, Challenge.class})
@Entity(name = "submission")
@Table
public class Submission {

  @EmbeddedId
  private User user;

  @EmbeddedId
  private Challenge challenge;

  @NotNull
  @Column(name = "score", nullable = false)
  private Float score;

  @CreatedDate
  @Column(name = "created_at", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  public Submission() {
  }
}