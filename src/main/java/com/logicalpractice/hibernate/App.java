package com.logicalpractice.hibernate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.SettingsFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

      BasicConfigurator.configure();
      Logger.getRootLogger().setLevel(Level.INFO);
      Logger.getLogger("org.hibernate.tool.hbm2ddl").setLevel(Level.DEBUG);
      AnnotationConfiguration c = new AnnotationConfiguration();

      c.addAnnotatedClass(MyEntity.class);
      SessionFactory sf = c.buildSessionFactory();
      
    }
}
