package com.bit.emaillist.vo;

import java.util.Date;

//DTO (OR VO) 객체
//내부에 로직 코드는 가능한 작성하지 않는다
//기본 생성자는 반드시 있어야 함
//데이터 접근은 GETTER/SETTER로 함
//TOSSTRING .EQUALS 정도는 오버라이드 하기도 함
public class EmailVO {
	//필드
	private Long no;
	private String lastName;
	private String firstName;
	private String email;
	private Date createdAt;
	
	//생성자
	public EmailVO() {}

	public EmailVO(Long no, String lastName, String firstName, String email, Date createdAt) {
		super();
		this.no = no;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.createdAt = createdAt;
	}

	public EmailVO(String lastName, String firstName, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}

	//GETTER/SETTER
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreateAt(Date createdAt) {
		this.createdAt = createdAt;
	}
//TOSTRING 오버라이드
	@Override
	public String toString() {
		return "EmailVO [no=" + no + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}
	
	

}

