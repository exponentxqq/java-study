package com.study.base.reflection.domain;

public class Student extends Person {

  public int score;
  private int grade;

  public Student(String name, int score, int grade) {
    super(name);
    this.score = score;
    this.grade = grade;
  }

  public String run(int speed) {
    return name + " run[speed:" + speed + "] in " + getGrade();
  }

  public int getScore() {
    return score;
  }

  private int getGrade() {
    return grade;
  }
}
