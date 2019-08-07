package com.liust.cache;

import java.sql.SQLException;

public interface ILocalCacheManager {

  public void createTable() throws SQLException;

  public void dropTable() throws SQLException;

  public void insert(int id, String name) throws SQLException;

  public void update(int id, String name) throws SQLException;

  public void delete(int id) throws SQLException;

  public void selectAll() throws SQLException;
}
