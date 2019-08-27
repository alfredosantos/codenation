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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Table(name = "user")
@Entity
@Embeddable
@EntityListeners({Submission.class, Candidate.class})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @PrimaryKeyJoinColumn
  private Long id;

  @NotNull
  @Size(max = 100)
  @Column(name = "full_name", length = 100, nullable = false)
  private String fullName;

  @NotNull
  @Size(max = 100)
  @Email
  @Column(name = "email", length = 100, nullable = false)
  private String email;

  @NotNull
  @Size(max = 50)
  @Column(name = "nickname", length = 50, nullable = false)
  private String nickname;

  @NotNull
  @Size(max = 255)
  @Column(name = "password", length = 255, nullable = false)
  private String password;

  @CreatedDate
  @Column(name = "created_at", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Candidate> candidates;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Submission> submissions;
}