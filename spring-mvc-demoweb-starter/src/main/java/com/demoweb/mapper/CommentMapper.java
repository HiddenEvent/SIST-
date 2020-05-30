package com.demoweb.mapper;

import java.util.List;

import com.demoweb.vo.BoardComment;

public interface CommentMapper {
	
	void insertComment(BoardComment boardComment);
	void updateStep(BoardComment boardComment);
	void updateGroupNo(BoardComment boardComment);
	void updateComment(BoardComment boardComment);
	void deleteComment(int commentNo);
	
	List<BoardComment> selectCommentsByBoardNo(int boardNo);
	BoardComment selectCommentByCommentNo(int commentNo);
	
}
