package test;

import main.java.MapperProxyFactory;
import test.dao.IUserDao;

import java.util.HashMap;
import java.util.Map;

public class TestMapperProxy {
    public static void main(String[] args) {
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("test.dao.IUserDao.getUserInfoById", "模拟执行 Mapper.xml 中 SQL 语句的操作：根据id查找用户信息");

        IUserDao iUserDao = mapperProxyFactory.newInstance(sqlSession);
        String userInfoById = iUserDao.getUserInfoById("12");
        System.out.println(userInfoById);
    }
}
