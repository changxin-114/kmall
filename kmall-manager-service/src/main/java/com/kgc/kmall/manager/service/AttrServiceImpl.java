package com.kgc.kmall.manager.service;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.bean.PmsBaseAttrInfoExample;
import com.kgc.kmall.bean.PmsBaseAttrValue;
import com.kgc.kmall.bean.PmsBaseAttrValueExample;
import com.kgc.kmall.manager.mapper.PmsBaseAttrInfoMapper;
import com.kgc.kmall.manager.mapper.PmsBaseAttrValueMapper;
import com.kgc.kmall.service.AttrService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Service
@Component
public class AttrServiceImpl implements AttrService {
    @Resource
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Resource
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> selectAttrInfo(Long catalog3Id) {
        PmsBaseAttrInfoExample pmsBaseAttrInfoExample=new PmsBaseAttrInfoExample();
        pmsBaseAttrInfoExample.createCriteria().andCatalog3IdEqualTo(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.selectByExample(pmsBaseAttrInfoExample);
        return pmsBaseAttrInfos;
    }

    @Override
    public int addAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        return pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId) {
        PmsBaseAttrValueExample pmsBaseAttrValueExample=new PmsBaseAttrValueExample();
        pmsBaseAttrValueExample.createCriteria().andAttrIdEqualTo(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.selectByExample(pmsBaseAttrValueExample);
        return pmsBaseAttrValues;
    }


}
