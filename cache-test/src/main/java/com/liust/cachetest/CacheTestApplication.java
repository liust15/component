package com.liust.cachetest;

import com.liust.cache.ILocalCacheManager;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(CacheTestApplication.class, args);
  }

  @Autowired
  private ILocalCacheManager iLocalCacheManager;

  /*
   * 测试使用
   * */
  @PostConstruct
  public void init() throws SQLException {
    // iLocalCacheManager.createTable();
    //  iLocalCacheManager.insert(1, "哈哈");
    iLocalCacheManager.selectAll();
  }
}
