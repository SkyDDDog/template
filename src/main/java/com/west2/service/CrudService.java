package com.west2.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.west2.entity.base.DataEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 通用的增删改查服务类
 * @param <M> mapper
 * @param <T> 实体类
 * @author 天狗
 * @date 2023/07/11
 */
@Slf4j
public abstract class CrudService<M extends BaseMapper<T>,T extends DataEntity<T>> {

    @Autowired
    protected M mapper;

    public CrudService() {
    }

    /**
     * 根据id查询
     * @param id    id
     * @return  实体
     */
    public T get(String id) {
        return this.mapper.selectById(id);
    }

    /**
     * 查询列表
     * @param wrapper   查询条件
     * @return  列表
     */
    public List<T> findList(QueryWrapper<T> wrapper) {
        wrapper.eq("del_flag",0);
        return this.mapper.selectList(wrapper);
    }

    /**
     * 保存(insert/update)
     * @param entity    实体
     * @return  影响行数
     */
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

    /**
     * 逻辑删除
     * @param entity    实体
     * @return  影响行数
     */
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
