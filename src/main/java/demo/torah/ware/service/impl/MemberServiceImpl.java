package demo.torah.ware.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.torah.ware.mapper.MemberMapper;
import demo.torah.ware.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void memberRegist(Map<String, Object> paramMap) {
		memberMapper.memberRegist(paramMap);
	}
	
	@Override
	public Map<String, Object> memberLogin(Map<String, Object> paramMap) {
		
		return memberMapper.memberLogin(paramMap);
	}
}
