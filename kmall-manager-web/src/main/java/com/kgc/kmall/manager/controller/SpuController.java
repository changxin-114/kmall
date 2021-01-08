package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseSaleAttr;
import com.kgc.kmall.bean.PmsProductImage;
import com.kgc.kmall.bean.PmsProductInfo;
import com.kgc.kmall.bean.PmsProductSaleAttr;
import com.kgc.kmall.service.SpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin
@RestController
@Api(tags = "商品spu管理相关接口",description = "提供商品管理相关的Rest API")
public class SpuController {
    @Reference
    SpuService spuService;

    @ApiOperation("查询sku接口")
    @RequestMapping("/spuList")
    public List<PmsProductInfo> pmsProductInfos(Long catalog3Id){
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    @Value("${fileServer.url}")
    String fileUrl;

    @ApiOperation("图片上传接口")
    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file")MultipartFile file) {
       try{
           String confFile = this.getClass().getResource("/tracker.conf").getFile();
           ClientGlobal.init(confFile);
           TrackerClient trackerClient=new TrackerClient();
           TrackerServer trackerServer=trackerClient.getTrackerServer();
           StorageClient storageClient=new StorageClient(trackerServer,null);

           String originalFilename = file.getOriginalFilename();
           FilenameUtils.getExtension(originalFilename);
           String[] upload_file = storageClient.upload_file(file.getBytes(), "jpg", null);
           String path=fileUrl;
           for (int i = 0; i < upload_file.length; i++) {
               String s = upload_file[i];
               path+="/"+s;
           }
           System.out.println(path);
           return path;
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }

    }

    @ApiOperation("特卖属性集合接口")
    @RequestMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> saleAttrList = spuService.baseSaleAttrList();
        return saleAttrList;
    }

    @ApiOperation("新增spu信息接口")
    @RequestMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        Integer saveSpuInfo = spuService.saveSpuInfo(pmsProductInfo);
        return saveSpuInfo>0?"success":"fail";
    }

    @ApiOperation("查询spu特卖属性集合接口")
    @RequestMapping("/spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(Long spuId){
        List<PmsProductSaleAttr> pmsProductSaleAttrList=spuService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrList;
    }

    @ApiOperation("查询spu图片集合接口")
    @RequestMapping("/spuImageList")
    public List<PmsProductImage> spuImageList(Long spuId){
        List<PmsProductImage> pmsProductImageList = spuService.spuImageList(spuId);
        return pmsProductImageList;
    }



}
