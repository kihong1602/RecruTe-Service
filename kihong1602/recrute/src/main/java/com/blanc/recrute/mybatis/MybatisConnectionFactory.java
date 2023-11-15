package com.blanc.recrute.mybatis;

import com.blanc.recrute.common.Word;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {

  private static SqlSessionFactory sqlSessionFactory;
  private static final Logger LOGGER = Logger.getLogger(MybatisConnectionFactory.class.getName());

  static {
    try {
      String resource = "config/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, Word.ERROR, e);
    }
  }

  public static SqlSession getSqlSession() {
    return sqlSessionFactory.openSession(false);
  }

}
