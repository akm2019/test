package demo.torah.ware.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

	public void memberRegist(Map<String, Object> paramMap);

	public Map<String, Object> memberLogin(Map<String, Object> paramMap); 
}
