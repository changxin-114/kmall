package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseSaleAttr;
import com.kgc.kmall.bean.PmsProductInfo;
import com.kgc.kmall.service.SpuService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@CrossOrigin
@RestController
public class SpuController {
    @Reference
    SpuService spuService;

    @RequestMapping("/spuList")
    public List<PmsProductInfo> pmsProductInfos(Long catalog3Id){
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
//        String originalFilename = file.getOriginalFilename();
//        String realPath = request.getServletContext().getRealPath("static/images/touxiang");
//        String extension = FilenameUtils.getExtension(originalFilename);
//        String newFileName=System.currentTimeMillis()+"_"+ RandomUtils.nextInt(10000)+"_."+extension;
//        File file1 = new File(realPath, newFileName);
//        try {
//            file.transferTo(file1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return "https://m.360buyimg.com/babel/jfs/t5137/20/1794970752/352145/d56e4e94/591417dcN4fe5ef33.jpg";
    }

    @RequestMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> saleAttrList = spuService.baseSaleAttrList();
        return saleAttrList;
    }

    @RequestMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        return "success";
    }
}
