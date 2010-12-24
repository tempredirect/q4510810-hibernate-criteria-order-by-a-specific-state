package com.logicalpractice.hibernate;

import org.hibernate.annotations.Index;

import javax.persistence.*;

/**
 * @author gareth
 */
@Entity
public class MyEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String state;


  public MyEntity() {
  }

  public MyEntity(String name, String state) {
    this.name = name;
    this.state = state;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
