package service;

import java.util.List;

import model.dto.TodoDTO;


public interface TodoListService {

	List<TodoDTO> findAll();
	
	TodoDTO getTodo(Integer id);
	
	void addTodo (String text , Boolean completed);
	
	void updateTodoComplete(Integer id , Boolean completed);
	
	void updateTodoText(Integer id , String text);
	
	void deleteTodo(Integer id );
}
