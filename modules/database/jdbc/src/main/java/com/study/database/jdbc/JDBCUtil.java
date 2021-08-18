package com.study.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDBCUtil {
  private static final String driver = "com.mysql.jdbc.Driver";
  private static final String url = "jdbc:mysql://localhost:3306/course";
  private static final String user = "root";
  private static final String password = "123456";

  static {
    // 1.注册驱动
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      log.error(e.getMessage(), e);
    }
  }

  public static Connection getConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      throw new RuntimeException("数据库连接异常" + e);
    }
    return conn;
  }
}
