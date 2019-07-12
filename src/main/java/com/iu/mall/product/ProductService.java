package com.iu.mall.product;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.mall.options.OptionsDAO;
import com.iu.mall.options.OptionsVO;
import com.iu.mall.thumbnail.ThumbnailDAO;
import com.iu.mall.thumbnail.ThumbnailVO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Service
public class ProductService {
	@Inject
	private ProductDAO productDAO;
	@Inject
	private OptionsDAO optionsDAO;
	@Inject
	private ThumbnailDAO thumbnailDAO;
	@Inject
	private FileSaver fileSaver;
	
	//list
	public List<ProductVO> getList(PageMaker pageMaker) throws Exception {
		pageMaker.setPerPage(9);
		//startRow,
		
		//pageing
	}
	
	//write
	public int setWrite(ProductVO productVO, List<MultipartFile> f1, HttpSession session) throws Exception {
		//1. PID 생성
		//현재시간을 밀리세컨즈로 변환
		//F/T/B+현재시간
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis(); //혹은  System.currentTimeMills();
		
		String pid = productVO.getCategory()+time;
		
		//2. 상품등록
		productVO.setPid(pid);
		int result = productDAO.setWrite(productVO);
		
		//3. 옵션등록
		/*List<OptionsVO> options = productVO.getOptions();
		for(OptionsVO option : options) {
			result = optionsDAO.setWrite(option);
		}*/
		
		//4. 파일 HDD에 저장
		String realPath = session.getServletContext().getRealPath("/resources/mall/thumbnail");
		System.out.println("realPath: "+realPath);
		
		for(MultipartFile file : f1) {
			String fname = fileSaver.saveFile3(realPath, file);
			ThumbnailVO thumbnailVO = new ThumbnailVO();
			thumbnailVO.setPid(productVO.getPid());
			thumbnailVO.setFname(fname);
			thumbnailVO.setOname(file.getOriginalFilename());
			result = thumbnailDAO.setWrite(thumbnailVO);
		}
		
		//5. 섬네일등록
		
		return 0;
	}
}
