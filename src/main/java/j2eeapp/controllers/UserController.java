package j2eeapp.controllers;

import j2eeapp.dao.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j2eeapp.model.User;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final String users = "/user.jsp";
	public final String userForm = "/userForm.jsp";

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		List<User> userList = UserDao.allUsers();

		if (action.equalsIgnoreCase("delete")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			UserDao.delete(userId);
			request.setAttribute("userList", userList);
			forward = users;
		} else if (action.equalsIgnoreCase("add")) {
			forward = userForm;
		} else if (action.equalsIgnoreCase("edit")) {
			forward = userForm;
			int userId = Integer.parseInt(request.getParameter("userId"));
			User user = UserDao.userById(userId);
			request.setAttribute("user", user);
			System.out.println(user);
		} else {
			request.setAttribute("userList", userList);
			forward = users;
			for (User u : userList) {
				System.out.println(u.getUserId() + " " + u.getUserName() + " " + u.getUserCity());
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(forward);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("most method called");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String userCity = request.getParameter("userCity");
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setUserCity(userCity);
		System.out.println(user);
		int status = UserDao.save(user);
		if (status > 0) {
			System.out.print("Record saved successfully!");
		} else {
			System.out.println("Sorry! unable to save record");
		}
		
//		if (request.getParameter("userId") == null || request.getParameter("userId").isEmpty()) {
//			int status = UserDao.save(user);
//			if (status > 0) {
//				System.out.print("Record saved successfully!");
//			} else {
//				System.out.println("Sorry! unable to save record");
//			}
//		} else {
//			user.setUserId(userId);
//			int status = UserDao.update(user);
//			if (status > 0) {
//				System.out.print("Record saved successfully!");
//			} else {
//				System.out.println("Sorry! unable to save record");
//			}
//		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(users);
		rd.forward(request, response);
	}

}
