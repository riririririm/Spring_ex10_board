package com.iu.validator;

import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iu.member.MemberDAO;
import com.iu.member.MemberDTO;

public class MemberValidate implements Validator{
	@Inject
	private MemberDAO memberDAO;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MemberDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberDTO memberDTO = (MemberDTO)target;
		String id=memberDTO.getId();
		String pw=memberDTO.getPw();
		String pw2 = memberDTO.getPw2();
		String name = memberDTO.getName();
		String email = memberDTO.getEmail();
		String ex1 = "[a-z]+[A-Z]+{6,12}";
		
		boolean check=Pattern.matches(ex1, id);
		System.out.println(check);
		
		
		if(id==null || id.length()==0) {
			//errors.rejectValue("멤버변수명", "properties key");
			errors.rejectValue("id", "member.id");
		}else {
			try {
				MemberDTO chekId = memberDAO.getID(memberDTO);
				if(chekId != null) {
					errors.rejectValue("id", "member.id.duplicate");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pw==null || pw.length()==0) {
			errors.rejectValue("pw2", "member.pw");
		}else {
			if(!pw.equals(pw2)) {
				errors.rejectValue("pw2", "member.pw.equal");
			}
		}
		
		if(name==null||name.length()==0) {
			errors.rejectValue("name", "member.name");
		}
		
		if(email==null||email.length()==0) {
			errors.rejectValue("email", "member.email");
		}
	}
}
