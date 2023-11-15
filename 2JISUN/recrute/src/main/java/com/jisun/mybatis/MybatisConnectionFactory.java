package com.jisun.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/jisun/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static SqlSession getSqlSession() {
		// commit 설정
		return sqlSessionFactory.openSession(true);
	}
}
