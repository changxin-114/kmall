package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsBaseSaleAttr;
import com.kgc.kmall.bean.PmsProductImage;
import com.kgc.kmall.bean.PmsProductInfo;
import com.kgc.kmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    //根据三级分类id查询商品属性
    List<PmsProductInfo> spuList(Long catalog3Id);

    //查询销售属性
    List<PmsBaseSaleAttr> baseSaleAttrList();

    //添加商品属性spu
    public Integer saveSpuInfo(PmsProductInfo pmsProductInfo);

    //显示销售属性和属性值
    List<PmsProductSaleAttr> spuSaleAttrList(Long spuId);

    //显示图片
    List<PmsProductImage> spuImageList(Long spuId);
}
