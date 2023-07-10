package com.west2.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Bean工具类
 * @author 天狗
 * @date 2023/07/11
 */
public class BeanCustomUtil {

    public BeanCustomUtil() {
    }

    /**
     * 获取空属性名数组
     * @param source    源对象
     * @return        空属性名数组
     */
    public static String[] getNullPropertyNames(Object source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet();
        PropertyDescriptor[] var4 = pds;
        int var5 = pds.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            PropertyDescriptor pd = var4[var6];
            Object srcValue = src.getPropertyValue(pd.getName());
            if ("".equals(srcValue)) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return (String[])emptyNames.toArray(result);
    }

    /**
     * 拷贝属性
     * @param src   源对象
     * @param target    目标对象
     */
    public static void copyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    /**
     * 对象转Map
     * @param obj   对象
     * @return  Map
     */
    public static Map toMap(Object obj) {
        ObjectMapper oMapper = new ObjectMapper();
        return oMapper.convertValue(obj, Map.class);
    }




}
