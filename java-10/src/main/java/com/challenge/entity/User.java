package com.challenge.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @NotNull
  @Size(max = 100)
  private String fullName;

  @Column
  @Email
  @Size(max = 100)
  @NotNull
  private String email;

  @Column
  @NotNull
  @Size(max = 50)
  private String nickname;

  @Column
  @NotNull
  @Size(max = 255)
  private String password;

  @Column
  @CreatedDate
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "id.user")
  private List<Candidate> candidates;

  @OneToMany(mappedBy = "id.user")
  private List<Submission> submissions;

  public void setCreatedAt(LocalDateTime now) {
  }
}
