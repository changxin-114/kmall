package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseCatalog1;
import com.kgc.kmall.bean.PmsBaseCatalog2;
import com.kgc.kmall.bean.PmsBaseCatalog3;
import com.kgc.kmall.service.CatalogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "商品分类管理相关接口",description = "提供商品管理相关的Rest API")
public class CatalogController {
    @Reference
    CatalogService catalogService;

    @ApiOperation("一级分类查询接口")
    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> selectCatalog1(){
        List<PmsBaseCatalog1> catalog1 = catalogService.getCatalog1();
        return catalog1;
    }

    @ApiOperation("二级分类查询接口")
    @ApiImplicitParam(name = "catalog1Id",value = "一级分类id",required = true)
    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> selectCatalog2(Integer catalog1Id){
        List<PmsBaseCatalog2> catalog2 = catalogService.getCatalog2(catalog1Id);
        return catalog2;
    }

    @ApiOperation("三级分类查询接口")
    @ApiImplicitParam(name = "catalog2Id",value = "二级分类id",required = true)
    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> selectCatalog3(Long catalog2Id){
        List<PmsBaseCatalog3> catalog3 = catalogService.getCatalog3(catalog2Id);
        return catalog3;
    }

}
