package com.challenge.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class CandidateIdentity implements Serializable {

  @NotNull
  @ManyToOne
  private User user;

  @NotNull
  @ManyToOne
  private Company company;

  @NotNull
  @ManyToOne
  private Acceleration acceleration;
}
