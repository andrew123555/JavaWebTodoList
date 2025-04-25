package dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Todo;

public interface TodoListDao {
	public List<Todo> todo = new CopyOnWriteArrayList<>();
	
	
	List<Todo> findAll();
	
	Todo getTodo(Integer id);
	
	void addTodo (Todo todo);
	
	void updateTodoComplete(Integer id , Boolean completed);
	
	void updateTodoText(Integer id , String text);
	
	void deleteTodo(Integer id );
	
}
