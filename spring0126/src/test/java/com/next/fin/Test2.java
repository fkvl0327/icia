package com.next.fin;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

// junit으로 실행하는 @test를 스프링으로 끌고 오기 위해 spring-test의 SpringJUnit4ClassRunner를 실행 
@RunWith(SpringJUnit4ClassRunner.class)

// context는 root-context.xml 내용을 사용할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

// 콘솔에 기록을 띄우기 위한 Log4j(lombok 라이브러리의 어노테이션) 호출
@Log4j

public class Test2 {
	
	// @Autowired(spring-beans 라이브러리의 어노테이션)는
	// ContextConfiguration에서 지정한 파일의 데이터타입을 자동연결
	// (DataSource 데이터 타입이 하나밖에 없으므로 가능)
	
	// @Setter(lombok 라이브러리의 어노테이션)는 method가 실행될 때 @Autowired를 적용
	@Setter(onMethod_ = {@Autowired})
	private DataSource ds; // DBCP 연결 위한 필드 변수
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSession;
	
	@Setter(onMethod_ = {@Autowired})
	private Mapper mapper;
	
	// test 패키지의 자바 클래스 파일을 테스트하는 junit 라이브러리의 기능
	@Test
	public void connectTest() {
		try {
			SqlSession session = sqlSession.openSession();
			Connection connect = ds.getConnection();
			log.info(session);
			log.info(connect);
			log.info(mapper.getDate());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
