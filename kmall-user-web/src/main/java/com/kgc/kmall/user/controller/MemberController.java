package com.kgc.kmall.user.controller;

import com.kgc.kmall.bean.Member;
import com.kgc.kmall.service.MemberService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "用户相关接口",description = "提供用户相关的Rest API")
public class MemberController {
    @Reference
    MemberService memberService;

    @RequestMapping("/list")
    public List<Member> selectMember(){
        List<Member> members = memberService.selectAllMember();
        return members;
    }
}
