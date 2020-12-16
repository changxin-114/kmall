package com.kgc.kmall.service;

import com.kgc.kmall.bean.Member;

import java.util.List;

public interface MemberService {
    //查询所有用户
    List<Member> selectAllMember();
}
