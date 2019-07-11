package com.iu.member;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.file.MemberFileDAO;
import com.iu.file.MemberFileDTO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

import oracle.net.aso.p;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private MemberFileDAO memberFileDAO;
	
	public List<MemberDTO> getList(PageMaker pageMaker) throws Exception{
		pageMaker.makeRow();
		pageMaker.makePage(memberDAO.getCount(pageMaker));
		List<MemberDTO> list = memberDAO.getList(pageMaker);
		
		return list;
	}
	
	public int setWrite(MemberDTO memberDTO, MultipartFile photo, HttpSession session)throws Exception{
		//1.저장 경로
		String realPath = session.getServletContext().getRealPath("/resources/member");
		String fname = fileSaver.saveFile3(realPath, photo);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFname(fname);
		memberFileDTO.setOname(photo.getOriginalFilename());
		int result = memberDAO.setWrite(memberDTO);
		result = memberFileDAO.setWrite(memberFileDTO);
		
		return result;
	}
	
	public MemberDTO getSelect(MemberDTO memberDTO)throws Exception{
		return memberDAO.getSelect(memberDTO);
	}
	
	public int setDelete(String[] id)throws Exception{
		List<String> list = Arrays.asList(id);
		return memberDAO.setDelete(list);
	}
	

}
