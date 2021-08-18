package com.study.database.mybatis.mapper;

import com.study.database.mybatis.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
  Student select();
}
