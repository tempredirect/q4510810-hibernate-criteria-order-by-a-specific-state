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

  @Index(name = "IDX_NAME")
  private String name;

  @Enumerated(EnumType.STRING)
  @Index(name = "IDX_VALUE")
  private MyEnum value;

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

}
