package com.demoweb.vo;

import java.sql.Date;
import java.util.List;

public class Board {

	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int readCount;
	private boolean deleted;
	
	//Board - BoardAttach 사이의 1:Many 관계를 구현하는 필드
	private List<BoardAttach> attachments;
	//Board - BoardComment 사이의 1:Many 관계를 구현하는 필드
	private List<BoardComment> comments;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public List<BoardAttach> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<BoardAttach> attachments) {
		this.attachments = attachments;
	}
	public List<BoardComment> getComments() {
		return comments;
	}
	public void setComments(List<BoardComment> comments) {
		this.comments = comments;
	}
	
	
}
