package com.soulsbooks.net.configs;

import com.soulsbooks.net.mapper.UserMapper;
import com.soulsbooks.net.model.User;
import com.soulsbooks.net.service.TestService;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;


import static org.junit.Assert.assertEquals;

/**
 * Created by zhangjun on 2016/7/24.
 */
public class MybatisConfigTest {


    @Test
    public void test() throws Exception {

        String resource = "configs/mybatis.xml";
        InputStream is = MybatisConfig.class.getClassLoader().getResourceAsStream(resource);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        String line = reader.readLine();
//        while (line != null){
//
//            System.out.println(line);
//            line = reader.readLine();
//        }
//        reader.close();

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();

        SqlSessionTemplate template = new SqlSessionTemplate(sessionFactory);

        String statement = "com.soulsbooks.net.mapper.UserMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
//        User user = session.selectOne(statement, 1);
        User user = template.selectOne(statement, 1);


        System.out.println(user);

//        SqlSessionFactoryBean sql = new SqlSessionFactoryBean();
//        sql.setDataSource(new DriverManagerDataSource() );

        assertEquals(4, 2 + 2);
}




    @Test
    public void testxml() throws Exception {

        ApplicationContext ctx=null;
        ctx=new ClassPathXmlApplicationContext("configs/applicationContext.xml");

        TestService testService = (TestService)ctx.getBean("testService");
        System.out.println(testService.getUser(1));
        assertEquals(4,2+2);
    }
}
