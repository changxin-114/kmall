package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsSkuInfo;

import java.util.List;

public interface SkuService {
    //添加sku信息
    String saveSkuInfo(PmsSkuInfo skuInfo);
    //查询sku信息
    PmsSkuInfo selectBySkuId(Long id);
    //在页面根据销售属性切换sku
    List<PmsSkuInfo> selectBySpuId(Long spuId);
    //查询全部sku
    List<PmsSkuInfo> getAllSku();

}
