package com.consumer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomMessage {
	
	private String mId;
	private String msg;
	private Date mDate;

}
