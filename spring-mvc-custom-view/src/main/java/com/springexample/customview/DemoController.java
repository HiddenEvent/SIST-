package com.springexample.customview;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.View;

@Controller
public class DemoController {
	
	@RequestMapping(value = "/simplecustomview1.action")
	public View simpleCustomView1() {
		
		//ViewResolver를 사용해서 View를 선택하도록 View 이름 반환
		//return "result"; //viewName -> JstlView가 /WEB-INF/views/ + result + .jsp를 처리
		
		//ViewResolver를 사용하지 않고 직접 View를 선택
		MyView view = new MyView();
		return view;
		
	}
	
	@RequestMapping(value = "/simplecustomview2.action", produces="text/plain;charset=utf-8")
	@ResponseBody //return 하는 내용은 View이름이 아니고 응답 컨텐츠입니다.
	public String simpleCustomView2() {
		
		return "Hello, Spring Custom View !!!!!";
		
	}
	
	@PostMapping(value = "/upload.action")
	public String upload(MultipartHttpServletRequest req, String data) {		
		
		System.out.println("Form Data : " + data);
		
		MultipartFile attach = req.getFile("files");
		
		if (attach != null && !attach.isEmpty()) {
			//파일 저장
			String path = req.getServletContext().getRealPath("/WEB-INF/upload-file/" + attach.getOriginalFilename());//저장 경로 만들기
			
			try {
				attach.transferTo(new File(path)); //파일 저장하기
				
			} catch (Exception ex) {				
				ex.printStackTrace();
			}
		}
		
		return "home";
	}

	@RequestMapping(value = "/download.action")
	public View download() {
		
		return new DownloadView();
		
	}

}









