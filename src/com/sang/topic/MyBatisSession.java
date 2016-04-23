package com.sang.topic;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by arch on 2016/4/19.
 */
public class MyBatisSession {
	private static SqlSession sqlSession = null;
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public static SqlSession getSession(){
		return sqlSession;
	}

	public static void closeSession(){
		if(sqlSession != null)
			sqlSession.close();
	}
}
