package com.west2.service;

import com.west2.entity.Template;
import com.west2.entity.vo.TemplateVO;
import com.west2.mapper.TemplateMapper;
import com.west2.utils.BeanCustomUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试用的template表Service层
 * @author 天狗
 * @date 2023/07/11
 */
@Service
public class TemplateService extends CrudService<TemplateMapper, Template>{

    /**
     * 构建vo对象
     * @param src   源对象
     * @return  vo对象
     */
    public TemplateVO buildVO(Template src) {
        TemplateVO vo = new TemplateVO();
        BeanCustomUtil.copyProperties(src, vo);
        return vo;
    }

    /**
     * 构建vo对象列表
     * @param list  源对象列表
     * @return  vo对象列表
     */
    public List<TemplateVO> buildVOList(List<Template> list) {
        ArrayList<TemplateVO> result = new ArrayList<TemplateVO>(list.size());
        for (Template template : list) {
            result.add(this.buildVO(template));
        }
        return result;
    }

}
