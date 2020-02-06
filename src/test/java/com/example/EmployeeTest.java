package com.example;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.EmployeeMapper;
import com.example.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void insertTest(){
        Employee employee = new Employee("insert测试2", 1, "11313165465@qq.com");
        employeeMapper.insert(employee);
        System.out.println(employee.getId());
    }


    @Test
    public void selectOneTest(){
        Employee employee = employeeMapper.selectOne(new QueryWrapper<Employee>().eq("gender", 1).like("last_name","insert测试"));
        System.out.println(employee);
    }

    @Test
    public void selectBatchIds(){
        List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(1, 2));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void selectPageTest(){
        IPage<Employee> emps = employeeMapper.selectPage(new Page<>(2, 1), null);
        System.out.println(emps);
    }

    @Test
    public void deleteByIdTest(){
        int i = employeeMapper.deleteById(1);
        System.out.println(i);
    }

}
