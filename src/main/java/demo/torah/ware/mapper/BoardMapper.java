package demo.torah.ware.mapper;

import demo.torah.ware.paging.Paging;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BoardMapper {
 
	public List<Map<String,Object>> boardList(Paging paging);

	public int boardTotalCnt();

	public int boardRegist(Map<String, Object> paramMap);

	public Map<String, Object> boardView(String boardIdx);

	public int boardEdit(Map<String, Object> paramMap);

	public int boardDelete(String boardIdx); 
}
