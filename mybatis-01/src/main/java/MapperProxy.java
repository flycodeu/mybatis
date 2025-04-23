package main.java;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -1047155665507002273L;

    /**
     * 存储mapper的sql语句对应的key-value
     * key: mapper的类名+方法名
     * value: sql语句
     */
    private Map<String, String> sqlSession;

    /**
     * mapper的接口类型,当前代理对象代理的接口
     */
    public final Class<T> mapperInterface;

    public MapperProxy(Class<T> mapperInterface, Map<String, String> sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return "模拟调用：" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
