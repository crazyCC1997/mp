package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.EmployeeMapper;
import com.example.dao.UserMapper;
import com.example.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PluginTest {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    UserMapper userMapper;

    //测试分页插件(物理分页)   PaginationInterceptor
    @Test
    public void test(){
        IPage<Employee> page = employeeMapper.selectPage(new Page<>(1, 1), null);
        List<Employee> records = page.getRecords();
        for (Employee record : records) {
            System.out.println(record);
        }

        System.out.println("总条数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("当前页：" + page.getCurrent());
    }


    //性能分析插件
    @Test
    public void test2(){

        Employee employee = new Employee();
        employee.setLastName("小红");
        employee.setEmail("xiaohong@qq.com");
        employee.setGender(2);
        employeeMapper.insert(employee);
    }

    //乐观锁插件测试
    @Test
    public void test3(){

        Employee employee = new Employee();
        employee.setId(9);
        employee.setLastName("小红hongAA");
        employee.setEmail("xiaohonghongAA@qq.com");
        employee.setGender(2);
        employee.setVersion(2);
        employeeMapper.updateById(employee);
    }


    /**
     * 逻辑删除  is_delete字段值由0变为1
     */
    @Test
    public void test4(){
        int i = userMapper.deleteById(1);
        System.out.println(i);
    }

    //新增操作 自动填充字段
    @Test
    public void test5(){

        Employee employee = new Employee();
        employee.setLastName("雪飞飞");
        employee.setGender(1);
        employee.setEmail("xuefeifei@xina.com");
        employeeMapper.insert(employee);
    }

    //更新操作 自动填充字段
    @Test
    public void test6(){
        Employee employee = new Employee();
        employee.setId(2);
        employee.setLastName("22222222");
        employeeMapper.updateById(employee);
    }

    @Test
    public void test7() {

        int i = 1;
        i = i++;
        System.out.println(i);
    }
}
