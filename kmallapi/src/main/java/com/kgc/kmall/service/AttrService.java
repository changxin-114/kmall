package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.bean.PmsBaseAttrValue;

import java.util.List;
import java.util.Set;

public interface AttrService {
    //根据三级分类查询平台属性
    List<PmsBaseAttrInfo> selectAttrInfo(Long catalog3Id);
    //添加平台属性
    int addAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
    //获取平台属性以便修改
    List<PmsBaseAttrValue> getAttrValueList(Long attrId);
    //根据valueid的集合查询平台属性名和值
    List<PmsBaseAttrInfo> selectAttrInfoValueListByValueId(Set<Long> valueIds);
}
