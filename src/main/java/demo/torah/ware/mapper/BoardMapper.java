package demo.torah.ware.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import demo.torah.ware.paging.Paging;

@Mapper
public interface BoardMapper {
 
	public List<Map<String,Object>> boardList(Paging paging);

	public int boardTotalCnt();

	public int boardRegist(Map<String, Object> paramMap);

	public Map<String, Object> boardView(String boardIdx);

	public int boardEdit(Map<String, Object> paramMap);

	public int boardDelete(String boardIdx); 
}
