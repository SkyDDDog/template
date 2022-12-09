package com.west2.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.west2.entity.base.DataEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public abstract class CrudService<M extends BaseMapper<T>,T extends DataEntity<T>> {

    @Autowired
    protected M mapper;

    public CrudService() {
    }

    public T get(String id) {
        return this.mapper.selectById(id);
    }

    public List<T> findList(QueryWrapper<T> wrapper) {
        wrapper.eq("del_flag",0);
        return this.mapper.selectList(wrapper);
    }

    public int save(T entity) {
        int result = 0;
        log.info(entity.isNewRecord()+"");
        if (entity.isNewRecord()) {
            entity.preInsert();
            result = this.mapper.insert(entity);
        } else {
            entity.preUpdate();
            result = this.mapper.updateById(entity);
        }
        return result;
    }

    public int delete(T entity) {
        int result = 0;
        if (entity != null) {
            entity.setDelFlag("1");
            entity.preUpdate();
            result = this.mapper.updateById(entity);
        }
        return result;
    }


}
