package service;

import java.util.ArrayList;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import model.dto.TodoDTO;
import model.entity.Todo;

public class TodoListServiceImpl implements TodoListService {

	private TodoListDao dao = new TodoListDaoImpl();
	
	
	@Override
	public List<TodoDTO> findAll() {
		
		List<Todo> todos = dao.findAllTodos();
		List<TodoDTO> todoDTOs =new ArrayList<>();
		for(Todo todo :todos) {
			todoDTOs.add(transferToDTO(todo));
		}
		
		return null;
	}

	@Override
	public TodoDTO getTodo(Integer id) {
		
		return transferToDTO(dao.getTodo(id));
	}

	@Override
	public void addTodo(String text, Boolean completed) {
			Todo todo = new Todo(0,text , completed);
			dao.addTodo(todo);
	}

	@Override
	public void updateTodoComplete(Integer id, Boolean completed) {
		dao.updateTodoComplete(id, completed);
	}

	@Override
	public void updateTodoText(Integer id, String text) {
		dao.updateTodoText(id, text);
	}

	@Override
	public void deleteTodo(Integer id) {
		dao.deleteTodo(id);
	}

	private TodoDTO transferToDTO(Todo todo) {
		
		return new TodoDTO(todo.getId(), todo.getText(), todo.getCompleted());
		
	}
	
	private Todo transferToEntity(TodoDTO todoDTO) {
		return new Todo(todoDTO.getId(), todoDTO.getText(), todoDTO.getCompleted());
	}
}
