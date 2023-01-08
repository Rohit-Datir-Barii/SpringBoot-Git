package com.rd.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorError {
	
	private LocalDateTime date;
	private String msg;
	private String status;

}
