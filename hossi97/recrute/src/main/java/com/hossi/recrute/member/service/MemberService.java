package com.hossi.recrute.member.service;

import com.hossi.recrute.common.mybatis.ResultType;
import com.hossi.recrute.member.dao.MemberDao;
import com.hossi.recrute.member.dto.request.CheckDupReqDto;
import com.hossi.recrute.member.dto.request.SigninReqDto;
import com.hossi.recrute.member.dto.request.SignupReqDto;
import com.hossi.recrute.member.dto.response.CheckDupResDto;
import com.hossi.recrute.member.dto.response.SigninResDto;
import com.hossi.recrute.member.dto.response.SignupResDto;

public class MemberService {
    private final MemberDao memberDao = new MemberDao();
    public SignupResDto signup(SignupReqDto signupReqDto) {
        if(validatePassword(signupReqDto.getPassword(), signupReqDto.getPasswordConfirm())) {
            return memberDao.saveMember(signupReqDto);
        }
        return null;
    }

    public CheckDupResDto checkDuplicate(CheckDupReqDto checkDupReqDto) {
        return memberDao.getCount(checkDupReqDto);
    }

    public SigninResDto signin(SigninReqDto signinReqDto) {
        return memberDao.findIdAndCertification(signinReqDto);
    }

    public ResultType authMail(Integer id) {
        return memberDao.updateCerification(id);
    }

    private boolean validatePassword(String pw1, String pw2) {
        return pw1.equals(pw2);
    }
}
