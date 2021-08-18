package com.study.database.mybatis;

import com.study.database.mybatis.domain.Student;
import com.study.database.mybatis.mapper.StudentMapper;
import java.io.IOException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Slf4j
public class Main {
  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    final Configuration configuration = sqlSessionFactory.getConfiguration();
    configuration.setMapUnderscoreToCamelCase(true);
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
      final Student student = studentMapper.select();
      log.info(student.toString());
    }
  }
}
