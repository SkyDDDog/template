package com.west2.common;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;


/**
 * 返回结果常用类
 * @author 天狗
 * @date 2022/11/26
 */
@ApiModel(
        value = "CommonResult",
        description = "返回结果常用类"
)
public class CommonResult extends BaseResult {

    @ApiModelProperty("具体返回的数据")
    private JSONObject item;

    /**
     * 初始化
     * @return  返回this以实现链式调用
     */
    @Override
    public CommonResult init() {
        super.init();
        this.item = new JSONObject();

        return this;
    }

    /**
     * 无参构造器
     */
    public CommonResult() {
    }

    /**
     * 有参构造器
     * @param item  json对象
     */
    public CommonResult(JSONObject item) {
        this.item = item;
    }

    /**
     * 有参构造器
     * @param msgCode   消息码
     * @param errMsg    错误信息
     * @param receiptDateTime   接收时间
     * @param returnDateTime    返回时间
     */
    public CommonResult(int msgCode, String errMsg, LocalDateTime receiptDateTime, LocalDateTime returnDateTime) {
        super(msgCode, errMsg, receiptDateTime, returnDateTime);
    }

    /**
     * 默认成功result
     * @param key   返回data的键
     * @param value 返回data的值
     * @return  返回this以实现链式调用
     */
    public CommonResult success(String key, Object value) {
        super.success();
        if (null != key && null != value) {
            this.item.put(key, value);
        }

        return this;
    }

    /**
     * 为result增添字段
     * @param key   返回data的键
     * @param value 返回data的值
     */
    public void putItem(String key, Object value) {
        this.item.put(key, value);
    }

    public JSONObject getItem() {
        return this.item;
    }

    public void setItem(JSONObject item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "errMsg='" + errMsg + '\'' +
                ", item=" + item +
                '}';
    }

}
