package com.challenge.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
@Embeddable
@Table(name = "acceleration")
@EntityListeners(Challenge.class)
public class Acceleration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 100)
  @Column(name = "name", nullable = true, length = 100)
  private String name;

  @NotNull
  @Size(max = 50)
  @Column(name = "slug", nullable = true, length = 50)
  private String slug;

  @EmbeddedId
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "challenge_id", referencedColumnName = "id")
  private Challenge challenge;

  @CreatedDate
  @Column(name = "created_at", nullable = true)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @OneToMany(mappedBy = "acceleration", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Candidate> candidates;
}