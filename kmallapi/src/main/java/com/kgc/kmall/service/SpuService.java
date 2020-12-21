package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsBaseSaleAttr;
import com.kgc.kmall.bean.PmsProductInfo;

import java.util.List;

public interface SpuService {
    //根据三级分类id查询商品属性
    List<PmsProductInfo> spuList(Long catalog3Id);

    //查询销售属性
    List<PmsBaseSaleAttr> baseSaleAttrList();

}
