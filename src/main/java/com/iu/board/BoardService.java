package com.iu.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.file.FileDTO;
import com.iu.util.PageMaker;

public interface BoardService {
	//글 등록
		public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception;
		
		public int setDelete(int num, HttpSession session)throws Exception;
		
		public int setUpdate(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception;
		
		public BoardDTO getSelect(int num) throws Exception;
		
		public List<BoardDTO> getList(PageMaker pageMaker) throws Exception;


}
