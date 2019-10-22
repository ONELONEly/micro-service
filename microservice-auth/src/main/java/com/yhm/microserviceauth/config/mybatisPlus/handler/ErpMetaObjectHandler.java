package com.yhm.microserviceauth.config.mybatisPlus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.java.Log;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Log
@Component
@ConditionalOnMissingBean(MetaObjectHandler.class)
public class ErpMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        //避免使用metaObject.setValue()
        this.setFieldValByName("refcntd", 0.0, metaObject);
        this.setFieldValByName("refcntu", 0.0, metaObject);
        this.setFieldValByName("indt", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updt", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("updt", LocalDateTime.now(), metaObject);

        //this.setFieldValByName("operator", "Tom", metaObject);
    }
}