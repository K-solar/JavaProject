package com.itbank.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/*
IDX     NOT NULL NUMBER        
USERID           VARCHAR2(30)  
USERPW  NOT NULL VARCHAR2(200) 
NICK             VARCHAR2(60)  
EMAIL   NOT NULL VARCHAR2(50)  
J_DATE           DATE          
PROFILE NOT NULL NUMBER 
 */

@Getter
@Setter
public class AccountVO {
	
	private int idx, profile;
	private String userid, userwp;
	private String nick, email;
	private Date j_date;
	
	
}
