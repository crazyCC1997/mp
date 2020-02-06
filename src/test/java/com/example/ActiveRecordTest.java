package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
/**
 * 活动记录模式 Active Record
 * 无需Mapper，直接对数据库进行增删改查
 */
public class ActiveRecordTest {


    //新增操作
    @Test
    public void test(){
        Employee employee = new Employee();
        employee.setLastName("张老师");
        employee.setEmail("154656@qq.com");
        employee.setAge(35);
        boolean result = employee.insert();
        System.out.println(result);
    }

    //统计查询
    @Test
    public void test2(){
        Employee employee = new Employee();
        Integer result = employee.selectCount(
                new QueryWrapper<Employee>().eq("gender", 2)
        );
        System.out.println("总记录数：" + result);
    }

}
