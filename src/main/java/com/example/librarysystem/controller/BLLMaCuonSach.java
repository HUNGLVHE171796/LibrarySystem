/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.example.librarysystem.controller;

import QuanLyThuVien.model.DAL.DALMuonTraSach;
import QuanLyThuVien.model.DAL.DALMuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.MuonTraSach;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 
 */
@WebServlet(name="BLLMaCuonSach", urlPatterns={"/maCuonSach"})
public class BLLMaCuonSach extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;
    private DALMuonTraSach dalMuonTraSach;
    private DALMuonTraSachChiTiet dal_MuonTraSachChiTiet;

	public void init() {
		
		try {
			dalMuonTraSach = new DALMuonTraSach();
                        dal_MuonTraSachChiTiet = new DALMuonTraSachChiTiet();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maThe = Integer.parseInt(request.getParameter("maThe"));
        try {
            List<MuonTraSach> muonTraSachList = dalMuonTraSach.getAllByMaThe(maThe);
            List<MuonTraSachChiTiet> muonTraSachChiTietList = dal_MuonTraSachChiTiet.getAllChiTietByMaThe(maThe);

            request.setAttribute("muonTraSachList", muonTraSachList);
            request.setAttribute("muonTraSachChiTietList", muonTraSachChiTietList);

            request.getRequestDispatcher("/UserMyBook.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }
}
