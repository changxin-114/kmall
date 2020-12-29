package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsSkuInfo;

public interface SkuService {
    //添加sku信息
    String saveSkuInfo(PmsSkuInfo skuInfo);
    //查询sku信息
    PmsSkuInfo selectBySkuId(Long id);
}
