package com.study.database.mybatis.domain;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
  private Integer id;
  private String name;
  private int grade;
  private Instant createdAt;
}
