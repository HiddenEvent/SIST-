package com.demoweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(value = "*.action")
public class BoardFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
				
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		
		if (uri.contains("/board/") &&
			uri.contains("/delete.action") ||
			uri.contains("/update.action") ||
			uri.contains("/reply.action") ||
			uri.contains("/detail.action")) {
			//데이터 읽기
			
			req.setCharacterEncoding("utf-8");
			
			String sPageNo = req.getParameter("pageno");		
			String sBoardNo = req.getParameter("boardno");		
			if (sPageNo == null || sBoardNo == null || 
				sPageNo.length() == 0 || sBoardNo.length() == 0) {
				resp.sendRedirect("list.action");
				return;
			}
			
			int boardNo = -1, pageNo = -1;
			try {
				pageNo = Integer.parseInt(sPageNo);
				boardNo = Integer.parseInt(sBoardNo);
			} catch (Exception ex) {
				resp.sendRedirect("list.action");
				return;
			}
			
			req.setAttribute("boardno", boardNo);
			req.setAttribute("pageno", pageNo);
		}
		
		chain.doFilter(request, response);
	}

}







