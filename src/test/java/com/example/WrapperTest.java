package com.example;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.EmployeeMapper;
import com.example.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
/**
 * 使用条件构造器
 */
public class WrapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void test1() {

        IPage<Employee> page = employeeMapper.selectPage(new Page<Employee>(1, 3),
                new QueryWrapper<Employee>()
                .between("age", 18, 50)
                .eq("last_name", "Tom")
                .eq("gender", 2)
        );
        List<Employee> records = page.getRecords();
        for (Employee record : records) {
            System.out.println(record);
        }
        System.out.println("总页数：" + page.getPages());
        System.out.println("总行数：" + page.getTotal());
        System.out.println("当前页：" + page.getCurrent());
    }

    @Test
    public void test2(){
        List<Employee> list = employeeMapper.selectList(
                new QueryWrapper<Employee>()
                        .eq("gender", 2)
                        .eq("last_name", "Tom")
                        .between("age", 18, 50)
                        .or()
                        .like("email", "2")
        );
        //or() he ornew() 区别在于 ornew()会将后面的查询条件加()
        System.out.println(list);
    }

    //排序、简单分页
    @Test
    public void test3(){
        List<Employee> list = employeeMapper.selectList(
                new QueryWrapper<Employee>()
                        .gt("age", 18)
                        .orderByDesc("last_name")
                        .last("limit 1, 3")
        );
        System.out.println(list);
    }

    //Condition
    @Test
    public void test4(){

    }
}
