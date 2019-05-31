package com.newlecture.web.entity;

import java.util.Date;

public class Notice {

	private int id;
	private String title;
	private String content;
	private String writerId;
	private Date regDate;
	private int hit;

//	public Notice(int i) {
//
//	}
	
	public Notice(String[] args) {
		this.id = Integer.parseInt(args[0]);
		this.title = args[1];
		this.content = args[2];
		this.writerId = args[3];
		this.regDate = null;
		this.hit = Integer.parseInt(args[4]);
	}

	public Notice(int id, String title, String content, String writerId, Date regDate, int hit) {
		
		this.id = id;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;
		
	}
	
	
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	
	
}
