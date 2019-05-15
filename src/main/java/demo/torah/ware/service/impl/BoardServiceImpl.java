package demo.torah.ware.service.impl;

import demo.torah.ware.mapper.BoardMapper;
import demo.torah.ware.paging.Paging;
import demo.torah.ware.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
@Slf4j
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	public BoardMapper boardMapper;
	
	@Override
	@Cacheable(value="akm_boardCache", key = "#currentPage")
	public List<Map<String,Object>> boardList(int currentPage, Paging paging){
		System.out.println("@@@@@@ serviceImpl");
		 log.debug("@@@@@@@@@@ log를 찍어보고싶다...");
		try {
            Thread.sleep(3000);
        }catch (Exception ex){
            ex.printStackTrace();
//            log.error(ex.getMessage());
        }
		
		return this.boardMapper.boardList(paging);
	}
	
	@Override
	public int boardTotalCnt() {
		return this.boardMapper.boardTotalCnt();
	}
	
	@Override
	public int boardRegist(Map<String, Object> paramMap) {
		return boardMapper.boardRegist(paramMap);
	}
	
	@Override
	public Map<String, Object> boardView(String boardIdx){
		return boardMapper.boardView(boardIdx);
	}
	
	@Override
	public int boardEdit(Map<String, Object> paramMap) {
		return boardMapper.boardEdit(paramMap);
	}
	
	@Override
	public void boardDelete(String boardIdx) {
		boardMapper.boardDelete(boardIdx);
	}

}
