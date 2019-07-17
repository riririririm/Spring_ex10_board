package com.iu.validator;

import org.apache.ibatis.io.ResolverUtil.IsA;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iu.board.BoardDTO;

public class QnaDTOValidate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return BoardDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BoardDTO boardDTO = (BoardDTO) target;

		// title검증
		if (boardDTO.getTitle() == null || boardDTO.getTitle().length() == 0) {
			errors.rejectValue("title", "title.require");
		}

		// writer검증
		if (boardDTO.getWriter() == null || boardDTO.getWriter().length() == 0) {
			errors.rejectValue("writer", "writer.require");
		}

		// contents검증
		if (boardDTO.getContents() == null || boardDTO.getContents().length() == 0) {
			errors.rejectValue("contents", "require");
		}
	}

}
