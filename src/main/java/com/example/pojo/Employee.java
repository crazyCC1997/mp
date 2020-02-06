package com.example.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.Format;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb1_employee")
public class Employee extends Model<Employee> implements Serializable {

    //主键生成策略
    @TableId(type = IdType.AUTO)
    private Integer id;
    //表成员变量设置
    //@TableField(value = "last_name",exist = true)
    private String lastName;
    private Integer gender;
    private String email;
    private Integer age;
    @TableField(exist = false)
    private Department dept;

    //字段自动填充
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;
    //字段自动填充
    @TableField(fill = FieldFill.UPDATE)
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;

    //乐观锁注解
    @Version
    private Integer version;
    public Employee(String lastName, Integer gender, String email) {
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Employee(String lastName, Integer gender, String email, Department dept) {
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dept = dept;
    }

    @Override
    protected Serializable pkVal() {
        //实现主键指定方法
        return id;
    }
}
