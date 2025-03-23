package com.example.librarysystem.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import QuanLyThuVien.model.DAL.DALTaiKhoan;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;

/**
 * Servlet implementation class DoiMatKhau
 */
@WebServlet(name = "DoiMatKhau", urlPatterns = { "/DoiMatKhau" })
public class DoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DALTaiKhoan dal_tk;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoiMatKhau() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			dal_tk = new DALTaiKhoan();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		HttpSession session = request.getSession();
		TaiKhoan tkDN = (TaiKhoan)session.getAttribute("tkDN");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		int result = 0;
		if(tkDN.getMatKhau().equals(oldPassword)){
			try {
				result = dal_tk.changePassword(newPassword, tkDN.getMaTaiKhoan());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result > 0){
				tkDN.setMatKhau(newPassword);
				session.setAttribute("tkDN", tkDN);
				response.getWriter().write("success");
			}else{
				response.getWriter().write("error");
			}
				
		}else{
			response.getWriter().write("wrong password");
		}
	}

}
