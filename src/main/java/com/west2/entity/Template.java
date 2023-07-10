package com.west2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.west2.entity.base.DataEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 测试实体类
 * @author 天狗
 * @date 2023-07-10
 */
@Data                       // 生成getter、setter方法
@AllArgsConstructor         // 全参构造器
@NoArgsConstructor          // 无参构造器
@Accessors(chain = true)    // 启用链式调用
@TableName("`test`")        // 指定表名
public class Template extends DataEntity<Template> {

    /**
     * 测试字段......
     */
    String name;
    String age;

}
