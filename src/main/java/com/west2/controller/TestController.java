package com.west2.controller;

import com.west2.common.CommonResult;
import com.west2.common.MsgCodeUtil;
import com.west2.entity.Template;
import com.west2.entity.dto.TemplateDTO;
import com.west2.service.TemplateService;
import com.west2.utils.BeanCustomUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 测试用的controller
 * @author 天狗
 * @date 2023/07/11
 */
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "${apiPath}/test")
@Api(value = "TestController", tags = "测试接口")
public class TestController {

    @Autowired
    private TemplateService templateService;


    @ApiOperation(value = "获取所有测试template")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult getAllTemplate() {
        CommonResult result = new CommonResult().init();
        List<Template> list = templateService.findList(null);
        result.success("data", templateService.buildVOList(list));
        return (CommonResult) result.end();
    }

    @ApiOperation(value = "根据id获取template")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "id",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            )
    })
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public CommonResult getTemplateById(@PathVariable String id) {
        CommonResult result = new CommonResult().init();
        Template template = templateService.get(id);
        result.success("data", templateService.buildVO(template));
        return (CommonResult) result.end();
    }

    @ApiOperation(value = "添加Template")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResult createBook(@Validated @RequestBody @ApiParam("添加template dto") TemplateDTO req,
                                   BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        // 参数校验
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }
        Template template = new Template();
        BeanCustomUtil.copyProperties(req, template);
        if (0 < templateService.save(template)) {
            result.success();
        } else {
            result.fail(MsgCodeUtil.MSG_CODE_UNKNOWN);
        }
        return (CommonResult) result.end();
    }

    @ApiOperation(value = "修改Template")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "id",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            )
    })
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public CommonResult updateBook(@Validated @RequestBody @ApiParam("修改template dto") TemplateDTO req,
                                   @PathVariable String id,
                                   BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        // 参数校验
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }
        Template template = new Template();
        BeanCustomUtil.copyProperties(req, template);
        template.setId(id);
        template.setNewRecord(false);
        if (0 < templateService.save(template)) {
            result.success();
        } else {
            result.fail(MsgCodeUtil.MSG_CODE_UNKNOWN);
        }
        return (CommonResult) result.end();
    }

    @ApiOperation(value = "修改Template")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "id",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            )
    })
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public CommonResult deleteBook(@PathVariable String id) {
        CommonResult result = new CommonResult().init();
        Template template = new Template();
        template.setId(id);
        if (0 < templateService.delete(template)) {
            result.success();
        } else {
            result.fail(MsgCodeUtil.MSG_CODE_UNKNOWN);
        }
        return (CommonResult) result.end();
    }

}
