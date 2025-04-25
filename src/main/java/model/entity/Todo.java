package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Todo {
	private Integer id;
	private Integer no;
	private String text;
	private Boolean completed ; 
	
}
