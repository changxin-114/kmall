package com.kgc.kmall.manager.service;

import com.kgc.kmall.bean.*;
import com.kgc.kmall.manager.mapper.*;
import com.kgc.kmall.service.SpuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Service
@Component
public class SpuServiceImpl implements SpuService {
    @Resource
    PmsProductInfoMapper pmsProductInfoMapper;
    @Resource
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;
    @Resource
    PmsProductImageMapper pmsProductImageMapper;
    @Resource
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Resource
    pmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(Long catalog3Id) {
        PmsProductInfoExample pmsProductInfoExample=new PmsProductInfoExample();
        pmsProductInfoExample.createCriteria().andCatalog3IdEqualTo(catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.selectByExample(pmsProductInfoExample);
        return pmsProductInfos;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectByExample(null);
    }

    @Override
    public Integer saveSpuInfo(PmsProductInfo pmsProductInfo) {
        try {
            int insert = pmsProductInfoMapper.insert(pmsProductInfo);
            Long id = pmsProductInfo.getId();
            //保存图片
            for (PmsProductImage pmsProductImage : pmsProductInfo.getSpuImageList()) {
                pmsProductImage.setProductId(id);
                pmsProductImageMapper.insert(pmsProductImage);
            }
            //保存销售属性
            for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductInfo.getSpuSaleAttrList()) {
                pmsProductSaleAttr.setProductId(id);
                for (pmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttr.getSpuSaleAttrValueList()) {
                    pmsProductSaleAttrValue.setProductId(id);
                    pmsProductSaleAttrValueMapper.insert(pmsProductSaleAttrValue);
                }
                pmsProductSaleAttrMapper.insert(pmsProductSaleAttr);
            }
            return 1;
        }catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }

    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(Long spuId) {
        PmsProductSaleAttrExample example=new PmsProductSaleAttrExample();
        PmsProductSaleAttrExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdEqualTo(spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrMapper.selectByExample(example);
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrList) {
            pmsProductSaleAttrValueExample example1=new pmsProductSaleAttrValueExample();
            pmsProductSaleAttrValueExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andSaleAttrIdEqualTo(pmsProductSaleAttr.getSaleAttrId());
            criteria1.andProductIdEqualTo(spuId);

            List<pmsProductSaleAttrValue> pmsProductSaleAttrValueList = pmsProductSaleAttrValueMapper.selectByExample(example1);
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValueList);
        }
        return pmsProductSaleAttrList;
    }

    @Override
    public List<PmsProductImage> spuImageList(Long spuId) {
        PmsProductImageExample example=new PmsProductImageExample();
        PmsProductImageExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdEqualTo(spuId);
        List<PmsProductImage> pmsProductImageList = pmsProductImageMapper.selectByExample(example);
        return pmsProductImageList;
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrListIsCheck(Long spuId, Long skuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrMapper.spuSaleAttrListIsCheck(spuId, skuId);
        return pmsProductSaleAttrList;
    }


}
