package com.example.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 自动填充处理器接口
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入操作自动填充
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        Object createTime = getFieldValByName("createTime", metaObject);
        if(null == createTime){
            log.info("Start insert fill ...");
            log.info("创建时间字段，自动填充...");
            setFieldValByName("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),metaObject);
        }

    }

    /**
     * 修改操作自动填充
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        Object updateTime = getFieldValByName("updateTime", metaObject);
        if(null == updateTime){
            log.info("Start update fill ...");
            log.info("更新时间字段，自动填充...");
            setFieldValByName("updateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), metaObject);
        }
    }
}
