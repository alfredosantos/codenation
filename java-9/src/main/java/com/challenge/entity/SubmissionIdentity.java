package com.challenge.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Embeddable
public class SubmissionIdentity implements Serializable {

  @ManyToOne
  @NotNull
  private User user;

  @ManyToOne
  @NotNull
  private Challenge challenge;

}
