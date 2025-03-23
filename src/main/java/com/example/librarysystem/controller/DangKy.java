package com.example.librarysystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALDocGia;
import QuanLyThuVien.model.DAL.Object.DocGia;

/**
 * Servlet implementation class DangKy
 */
@WebServlet(name = "DangKy", urlPatterns = { "/DangKy" })
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALDocGia dal_dg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKy() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			dal_dg = new DALDocGia();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthdate = request.getParameter("birthdate");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		DocGia newDG = null;
		response.setContentType("text/plain");

		try {
			// Check if email is already registered
			List<DocGia> list = dal_dg.getAll();
			for (DocGia dg : list) {
				if (email.equals(dg.getEmail())) {
					response.getWriter().write("errorEmail");
					return;  // Exit early if email is already registered
				}
			}

			// Create a new DocGia object
			newDG = new DocGia();
			newDG.setTenDocGia(name);
			newDG.setGioiTinh(sex);

			// Parse the birthdate (assuming it's coming in 'yyyy-MM-dd' format)
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse(birthdate);
			newDG.setNgaySinh(new java.sql.Date(date.getTime()));
			
			newDG.setDiaChi(address);
			newDG.setEmail(email);
			newDG.setSoDienThoai(phone);

			// Add the new DocGia to the database
			dal_dg.Add(newDG);

			response.getWriter().write("success");
		} catch (ClassNotFoundException | SQLException e) {
			// Handle SQL and ClassNotFound exceptions
			e.printStackTrace();
			response.getWriter().write("errorDatabase");
		} catch (ParseException e) {
			// Handle date parsing error
			e.printStackTrace();
			response.getWriter().write("errorDateParse");
		}
	}
}
