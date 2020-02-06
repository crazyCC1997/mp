package com.example.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    //通常原生mybatis中想获取一条插入记录的id时，
    // 使用useGeneratorKeys（使用主键自增）和KeyProperty
    //<insert useGeneratorKeys="true" KeyProperty="id">SQL...</insert>
    //mybatsiplus对这些配置进行了自动封装。直接可以获取
}
