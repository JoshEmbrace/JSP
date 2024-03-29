package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.dao.oracle.NoticeView;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeFile;

public interface NoticeFileDao {
	   List<NoticeFile> getListByNoticeId(int noticeId) throws ClassNotFoundException, SQLException;
	      
	   int insert(NoticeFile noticeFile) throws ClassNotFoundException, SQLException;
	   int update(NoticeFile noticeFile) throws ClassNotFoundException, SQLException;
	   int delete(int id) throws ClassNotFoundException, SQLException;
}