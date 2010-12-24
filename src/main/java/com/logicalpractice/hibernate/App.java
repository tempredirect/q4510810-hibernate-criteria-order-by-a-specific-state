package com.logicalpractice.hibernate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.SettingsFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.List;

import static org.hibernate.criterion.Projections.projectionList;
import static org.hibernate.criterion.Projections.sqlProjection;

/**
 * Hello world!
 */
public class App {

  private SessionFactory sf;

  public App() {
    AnnotationConfiguration c = new AnnotationConfiguration();
      c.addAnnotatedClass(MyEntity.class);
    sf = c.buildSessionFactory();
  }

  public static void main(String[] args) {

    BasicConfigurator.configure();
    Logger.getRootLogger().setLevel(Level.INFO);
    Logger.getLogger("org.hibernate.tool.hbm2ddl").setLevel(Level.DEBUG);
    Logger.getLogger("org.hibernate.SQL").setLevel(Level.DEBUG);

    App a = new App();
    a.populateTestData();


    a.queryAndPrint("from MyEntity e order by e.state asc");
    a.queryAndPrint("from MyEntity e order by case when e.state = 'Maryland' then '0' else '1' end asc, e.state asc");
  }

  private void queryAndPrint(String q) {
    Session s = sf.openSession();

    List results = s.createQuery(q).list();
    for (Object result : results) {
      MyEntity entity = (MyEntity) result;
      System.out.println("MyEntity state=" + entity.getState() + " name=" + entity.getName());
    }
  }

  private void populateTestData() {
    StatelessSession s = sf.openStatelessSession();

    s.insert(new MyEntity("Smith", "Maryland"));
    s.insert(new MyEntity("Smithy", "Maryland"));
    s.insert(new MyEntity("Davis", "New York"));
    s.insert(new MyEntity("Davis", "Azonia"));
    s.insert(new MyEntity("Davis", "Austin"));


    s.close();
  }

}
