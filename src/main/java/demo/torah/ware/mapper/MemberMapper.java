package demo.torah.ware.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {

	public void memberRegist(Map<String, Object> paramMap);

	public Map<String, Object> memberLogin(Map<String, Object> paramMap);
}
