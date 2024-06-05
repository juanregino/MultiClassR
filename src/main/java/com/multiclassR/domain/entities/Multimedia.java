package com.multiclassR.domain.entities;

import java.time.LocalDateTime;



import com.multiclassR.utils.enums.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Multimedia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)


  private Long id;
  @Enumerated(EnumType.STRING)
  private Type type;
  @Lob
  private String url;
  @Column(nullable = false)
  private LocalDateTime createdAt;
  @Column(nullable = false)
  private Boolean active;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "lesson_id", referencedColumnName = "id")
  private Lesson lesson;

}
