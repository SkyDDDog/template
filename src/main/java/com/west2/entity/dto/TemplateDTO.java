package com.west2.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 测试用的给前端交互用的实体类
 * @author 天狗
 * @date 2023/07/11
 */
@Data
public class TemplateDTO {

    @ApiModelProperty(value = "姓名", example = "张三")
    @NotBlank(message = "姓名不能为空")
    String name;

    @ApiModelProperty(value = "年龄", example = "18")
    @NotBlank(message = "年龄不能为空")
    String age;

}
