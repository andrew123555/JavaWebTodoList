package dao;

import java.util.List;


import model.entity.Todo;

public interface TodoListDao {
		
	
	List<Todo> findAllTodos();
	
	Todo getTodo(Integer id);
	
	void addTodo (Todo todo);
	
	void updateTodoComplete(Integer id , Boolean completed);
	
	void updateTodoText(Integer id , String text);
	
	void deleteTodo(Integer id );
	
}
