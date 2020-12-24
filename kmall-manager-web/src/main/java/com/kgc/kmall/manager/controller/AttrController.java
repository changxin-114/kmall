package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.bean.PmsBaseAttrValue;
import com.kgc.kmall.service.AttrService;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@Api(tags = "商品属性管理相关接口",description = "提供商品管理相关的Rest API")
public class AttrController {
    @Reference
    AttrService attrService;

    @ApiOperation("查询属性信息接口")
    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> selectAttrInfo(Long catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrService.selectAttrInfo(catalog3Id);
        return pmsBaseAttrInfos;
    }

    @ApiOperation("新增属性信息接口")
    @RequestMapping("/saveAttrInfo")
    public int addAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        int pageSize = attrService.addAttrInfo(pmsBaseAttrInfo);
        return pageSize;
    }

    @ApiOperation("根据id查询属性值接口")
    @RequestMapping("/getAttrValueList")
    @ApiImplicitParam(name = "attrId",value = "属性id",required = true)
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数问题"),
            @ApiResponse(code = 404,message = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(code = 405,message = "请求类型不正确"),
            @ApiResponse(code = 500,message = "后端程序出错")
    })
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId){
        List<PmsBaseAttrValue> attrValueList = attrService.getAttrValueList(attrId);
        return attrValueList;
    }


}
