package com.challenge.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Data
@Getter
@Setter
@Entity
@EntityListeners(Candidate.class)
@Embeddable
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 100)
  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @NotNull
  @Size(max = 50)
  @Column(name = "slug", nullable = false, length = 50)
  private String slug;

  @CreatedDate
  @Column(name = "created_at", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Candidate> candidates;

  public Company() {
  }
}