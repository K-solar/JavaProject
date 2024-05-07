package com.itbank.model;

import java.util.List;


import com.itbank.vo.BoardVO;


public interface BoardDAO {
	
	List<BoardVO> selectAll();

	int insert(BoardVO input);

	int delete(int idx);

	int update(BoardVO input);

}
