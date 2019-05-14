package demo.torah.ware.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import demo.torah.ware.paging.Paging;

@Service
public interface BoardService {
	public List<Map<String, Object>> boardList(int currentPage, Paging paging); 

	public int boardTotalCnt();

	public int boardRegist(Map<String, Object> paramMap);

	public Map<String, Object> boardView(String boardIdx);

	public int boardEdit(Map<String, Object> paramMap);

	public void boardDelete(String boardIdx);
}
