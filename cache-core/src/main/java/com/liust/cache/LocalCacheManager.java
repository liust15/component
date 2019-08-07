package com.liust.cache;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LocalCacheManager implements ILocalCacheManager {

  private Connection connection;

  public LocalCacheManager(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void createTable() throws SQLException {
    String sql = "DROP TABLE IF EXISTS test ;create table test (id integer, name string);";
    Statement stat = connection.createStatement();
    stat.executeUpdate(sql);
  }

  @Override
  public void dropTable() throws SQLException {
    String sql = "drop table test ";
    Statement stat = connection.createStatement();
    stat.executeUpdate(sql);
  }

  @Override
  public void insert(int id, String name) throws SQLException {
    String sql = "insert into test (id,name) values(?,?)";
    PreparedStatement pst = connection.prepareStatement(sql);
    int idx = 1;
    pst.setInt(idx++, id);
    pst.setString(idx++, name);
    pst.executeUpdate();

  }

  @Override
  public void update(int id, String name) throws SQLException {
    String sql = "update test set name = ? where id = ?";
    PreparedStatement pst;
    pst = connection.prepareStatement(sql);
    int idx = 1;
    pst.setString(idx++, name);
    pst.setInt(idx++, id);
    pst.executeUpdate();
  }

  @Override
  public void delete(int id) throws SQLException {
    String sql = "delete from test where id = ?";
    PreparedStatement pst = connection.prepareStatement(sql);
    int idx = 1;
    pst.setInt(idx++, id);
    pst.executeUpdate();
  }

  @Override
  public void selectAll() throws SQLException {
    String sql = "select * from test";
    Statement stat;
    ResultSet rs;
    stat = connection.createStatement();
    rs = stat.executeQuery(sql);
    while (rs.next()) {
      System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
    }
  }


}
