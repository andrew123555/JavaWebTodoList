package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.Todo;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {
	private Integer id;
	private Integer no;
	private String text;
	private Boolean completed ; 
	
}