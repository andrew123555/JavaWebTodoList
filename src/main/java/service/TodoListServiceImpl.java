package service;

import java.util.ArrayList;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import model.dto.TodoDTO;
import model.entity.Todo;

public class TodoListServiceImpl implements TodoListService {
	
	private TodoListDao dao = new TodoListDaoImpl();
	
	/*
	@Override
	public List<TodoDTO> findAllTodos() {
		List<Todo> todos = dao.findAllTodos();
		// List<Todo> 轉 List<TodoDTO>
		List<TodoDTO> todoDTOs = new ArrayList<>();
		for(Todo todo : todos) {
			todoDTOs.add(transferToDTO(todo));
		}
		return todoDTOs;
	}
	*/
	@Override
	public List<TodoDTO> findAllTodos() {
		return dao.findAllTodos()
				  .stream()
				  .map(this::transferToDTO)
				  //.map(todo -> transferToDTO(todo))
				  .toList();
	}

	@Override
	public TodoDTO getTodo(Integer id) {
		return transferToDTO(dao.getTodo(id));
	}

	@Override
	public void addTodo(Integer no,String text, Boolean completed) {
		Todo todo = new Todo(0, no, text, completed);
		dao.addTodo(todo);
	}

	@Override
	public void updateTodoComplete(Integer id,Integer no , Boolean completed) {
		dao.updateTodoComplete(id, no,completed);
	}

	@Override
	public void updateTodoText(Integer id,Integer no , String text) {
		dao.updateTodoText(id, no ,text);
	}

	@Override
	public void deleteTodo(Integer id) {
		dao.deleteTodo(id);
	}
	
	// 轉換成 DTO
	private TodoDTO transferToDTO(Todo todo) {
		return new TodoDTO(todo.getId(), todo.getNo(),todo.getText(), todo.getCompleted());
	}
	
	// 轉換成 Entity
	private Todo transferToEntity(TodoDTO todoDTO) {
		return new Todo(todoDTO.getId(), todoDTO.getNo(),todoDTO.getText(), todoDTO.getCompleted());
	}

}