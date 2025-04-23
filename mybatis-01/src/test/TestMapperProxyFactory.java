package test;

import main.java.MapperProxy;
import main.java.MapperProxyFactory;
import test.dao.IUserDao;

import java.util.HashMap;
import java.util.Map;

public class TestMapperProxyFactory {
    public static void main(String[] args) {
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("test.dao.IUserDao.getUserInfoById", "模拟执行根据Id获取用户信息");
        sqlSession.put("test.dao.IUserDao.getUserInfoByName", "模拟执行根据Name获取用户信息");
        IUserDao iUserDao = mapperProxyFactory.newInstance(sqlSession);

        String res = iUserDao.getUserInfoById("10001");
        System.out.println(res);

    }
}
