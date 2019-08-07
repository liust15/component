package com.liust.cache;

import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

@Configuration
public class CacheAutoConfiguration {

  @Bean
  public CacheManager tEmailHandlerManager() {
    return null;
  }

  @Bean
  public ILocalCacheManager localCacheManager() throws SQLException {
    return new LocalCacheManager(getConnection());
  }

  public Connection getConnection() throws SQLException {
    SQLiteConfig config = new SQLiteConfig();
    config.setSharedCache(true);
    config.enableRecursiveTriggers(true);
    SQLiteDataSource ds = new SQLiteDataSource(config);
    ds.setUrl("jdbc:sqlite:sample.db");
    return ds.getConnection();
  }

}
