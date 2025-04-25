package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.TodoDTO;
import service.TodoListService;
import service.TodoListServiceImpl;

@WebServlet("/todolist/*")
public class TodoListServlet extends HttpServlet  {
	
	private TodoListService service = new TodoListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String id = req.getParameter("id");
		String no = req.getParameter("no");
		String completed = req.getParameter("checked");
		String text = req.getParameter("text");
		
		resp.getWriter().print("pathInfo = " + pathInfo);
		
		switch (pathInfo) {
			case "/":  // 顯示 Todo List 首頁
			case "/*": // 顯示 Todo List 首頁
				List<TodoDTO> todos = service.findAllTodos();
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/todolist.jsp");
				req.setAttribute("todos", todos);
				rd.forward(req, resp);
				return;
			case "/delete":
				service.deleteTodo(Integer.parseInt(id));
				resp.sendRedirect("/JavaWebTodoList/todolist/");
				return;
				
			case "/update":
				if(completed != null) {
				service.updateTodoComplete(Integer.parseInt(id),Integer.parseInt(no), Boolean.parseBoolean(completed));
				resp.sendRedirect("/JavaWebTodoList/todolist/");
				return;
				}else if(text != null) {
					service.updateTodoText(Integer.parseInt(id), Integer.parseInt(no),text);
					resp.sendRedirect("/JavaWebTodoList/todolist/");
					return;
					}
				
				break;
				
			
				
			default:  // 錯誤路徑
				resp.getWriter().print("path error");
				return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(!pathInfo.equals("/add")) {
			// 錯誤路徑
			
			return;
		}
		// 進行新增程序
		String no = req.getParameter("no");
		String text = req.getParameter("text");
		Boolean completed = false;
		service.addTodo(Integer.parseInt(no) ,text, completed);
		resp.sendRedirect("/JavaWebTodoList/todolist/");
	}
	
	
	
	
}