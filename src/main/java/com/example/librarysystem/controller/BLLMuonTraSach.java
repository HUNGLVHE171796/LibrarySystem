package com.example.librarysystem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALMuonTraSach;
import QuanLyThuVien.model.DAL.DALMuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.MuonTraSach;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;
import QuanLyThuVien.model.DAL.Object.TheLoai;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "MuonTraSachQuanLy", urlPatterns = {"/MuonTraSachQuanLy", "/MuonTraSachQuanLy/delete",
    "/MuonTraSachQuanLy/list", "/MuonTraSachQuanLy/insert", "/MuonTraSachQuanLy/update",
    "/MuonTraSachQuanLy/edit", "/MuonTraSachQuanLy/add"})
public class BLLMuonTraSach extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int soDongTrenMotTrang = 6;
    private DALMuonTraSach dal_muonTraSach;
    private DALMuonTraSachChiTiet dal_muonTraSachChiTiet;

    public void init() {
        String a = getServletContext().getInitParameter("");
        try {
            dal_muonTraSach = new DALMuonTraSach();
            dal_muonTraSachChiTiet = new DALMuonTraSachChiTiet();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
                case "/MuonTraSachQuanLy/insert":
                    insertMuonTraSach(request, response);
                    break;
                case "/MuonTraSachQuanLy/delete":
                    deleteMuonTraSach(request, response);
                    break;
                case "/MuonTraSachQuanLy/update":
                    updateMuonTraSach(request, response);
                    break;
                case "/MuonTraSachQuanLy/edit":
                    editMuonTraSach(request, response);
                    break;
                case "/MuonTraSachQuanLy/add":
                    addMuonTraSach(request, response);
                    break;
                default: // list
                    listMuonTraSach(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void deleteMuonTraSach(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int code = Integer.parseInt(request.getParameter("maMuonSach"));

        try {
            dal_muonTraSach.Delete(code);

            int pages = 0;
            if (request.getParameter("pages") != null) {
                pages = (int) Integer.parseInt(request.getParameter("pages"));
            } else {
                pages = 1;
            }

            int total = 0;
            try {
                total = dal_muonTraSach.getSoLuongPhanTu(0, "default");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

            int soTrang = 0;
            if (total % soDongTrenMotTrang == 0) {
                soTrang = (int) (total / soDongTrenMotTrang);
            } else {
                soTrang = (int) (total / soDongTrenMotTrang) + 1;
            }

            if (pages > soTrang) {
                pages = soTrang;
            }

            response.sendRedirect("/QuanLyThuVien/MuonTraSachQuanLy" + "?pages=" + pages);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void listMuonTraSach(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<MuonTraSach> listMuonTraSach = new ArrayList<MuonTraSach>();

        int pages = 0, minRes = 0, maxRes = 0, total = 0;
        if (request.getParameter("pages") != null) {
            pages = (int) Integer.parseInt(request.getParameter("pages"));
        } else {
            pages = 1;
        }
        String search = "default";
        if (request.getParameter("txtSearch") != null) {
            search = request.getParameter("txtSearch");
        }
        String sort = "default";
        if (request.getParameter("selectSort") != null) {
            sort = request.getParameter("selectSort");
        }
        try {
            total = dal_muonTraSach.getSoLuongPhanTu(0, search);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        if (total <= soDongTrenMotTrang) {
            minRes = 1;
            maxRes = total;
        } else {
            minRes = (pages - 1) * soDongTrenMotTrang + 1;
            maxRes = minRes + soDongTrenMotTrang - 1;
        }

        int soTrang = 0;
        if (total % soDongTrenMotTrang == 0) {
            soTrang = (int) (total / soDongTrenMotTrang);
        } else {
            soTrang = (int) (total / soDongTrenMotTrang) + 1;
        }

        int maxCode = 0;
        try {
            maxCode = dal_muonTraSach.maxCode("MuonTraSach");
            listMuonTraSach = dal_muonTraSach.getAllPhanTrang(minRes, maxRes, 0, sort, search);

            request.setAttribute("maxCode", maxCode);
            request.setAttribute("txtSearch", search);
            request.setAttribute("selectSort", sort);
            request.setAttribute("soTrang", soTrang);
            request.setAttribute("total", total);
            request.setAttribute("soTrangHienTai", pages);
            request.setAttribute("listMuonTraSach", listMuonTraSach);
            RequestDispatcher dispatcher = request.getRequestDispatcher("MuonTraSachQuanLy.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateMuonTraSach(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        MuonTraSach record = new MuonTraSach();

        record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
        record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
        record.setTienDatCoc(request.getParameter("numberTienDatCoc"));
        record.setGhiChu(request.getParameter("txtGhiChu"));

        int pages = 0;
        if (request.getParameter("pages") != null) {
            pages = (int) Integer.parseInt(request.getParameter("pages"));
        } else {
            pages = 1;
        }

        try {
            dal_muonTraSach.Update(record);
            response.sendRedirect("/QuanLyThuVien/MuonTraSachQuanLy" + "?pages=" + pages);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void editMuonTraSach(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int code = Integer.parseInt(request.getParameter("maMuonSach"));

        int pages = 0;
        if (request.getParameter("pages") != null) {
            pages = (int) Integer.parseInt(request.getParameter("pages"));
        } else {
            pages = 1;
        }

        try {
            MuonTraSach muonTraSach = new MuonTraSach();
            muonTraSach = dal_muonTraSach.GetOne(code);
            request.setAttribute("muonTraSachIU", muonTraSach);
            request.getRequestDispatcher("/MuonTraSachQuanLy" + "?pages=" + pages).forward(request, response);
            ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void insertMuonTraSach(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        MuonTraSach record = new MuonTraSach();

        record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
        record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
        record.setTienDatCoc(request.getParameter("numberTienDatCoc"));
        record.setGhiChu(request.getParameter("txtGhiChu"));

        try {
            dal_muonTraSach.Add(record);

            // Sau khi insert sẽ về pages cuối
            int total = 0;
            try {
                total = dal_muonTraSach.getSoLuongPhanTu(0, "default");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

            int soTrang = 0;
            if (total % soDongTrenMotTrang == 0) {
                soTrang = (int) (total / soDongTrenMotTrang);
            } else {
                soTrang = (int) (total / soDongTrenMotTrang) + 1;
            }

            response.sendRedirect("/QuanLyThuVien/MuonTraSachQuanLy" + "?pages="
                    + soTrang);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
 private void addMuonTraSach(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        TaiKhoan tkDN = (TaiKhoan) session.getAttribute("tkDN");

        String maMuonSach = request.getParameter("txtMaMuonSach");
        if (maMuonSach != null && !maMuonSach.isEmpty()) {
            MuonTraSach recordMuonTraSach = new MuonTraSach();
            recordMuonTraSach.setMaMuonSach(Integer.parseInt(maMuonSach));
            recordMuonTraSach.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
            recordMuonTraSach.setTienDatCoc(request.getParameter("numberTienDatCoc"));
            recordMuonTraSach.setGhiChu(request.getParameter("txtGhiChu"));

            try {
                dal_muonTraSach.Add(recordMuonTraSach);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        String maCuonSach = request.getParameter("txtMaCuonSach");
        if (maCuonSach != null && !maCuonSach.isEmpty()) {
            MuonTraSachChiTiet recordMuonTraSachChiTiet = new MuonTraSachChiTiet();
            recordMuonTraSachChiTiet.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
            recordMuonTraSachChiTiet.setMaCuonSach(Integer.parseInt(maCuonSach));

            if (request.getParameter("dateNgayMuon") != null) {
                try {
                    Date ngayMuon = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayMuon"));
                    recordMuonTraSachChiTiet.setNgayMuon(new java.sql.Date(ngayMuon.getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if (request.getParameter("dateNgayHenTra") != null) {
                try {
                    Date ngayHenTra = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayHenTra"));
                    recordMuonTraSachChiTiet.setNgayHenTra(new java.sql.Date(ngayHenTra.getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if (request.getParameter("dateNgayTra") != null) {
                try {
                    Date ngayTra = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayTra"));
                    recordMuonTraSachChiTiet.setNgayTra(new java.sql.Date(ngayTra.getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            recordMuonTraSachChiTiet.setTrangThai(request.getParameter("txtTrangThai"));
            recordMuonTraSachChiTiet.setSoLuong(Integer.parseInt(request.getParameter("numberSoLuong")));

            try {
                dal_muonTraSachChiTiet.Add(recordMuonTraSachChiTiet);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Sau khi hoàn tất, chuyển hướng về trang chi tiết sách
        response.sendRedirect("/QuanLyThuVien/maCuonSach?maThe=" + tkDN.getMaThe());
    }
   
}
