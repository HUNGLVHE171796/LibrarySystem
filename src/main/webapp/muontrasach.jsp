<!-- filepath: d:\Spring2025\QuanLyThuVien\WebContent\muontrasach.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Muon Tra Sach</title>
</head>
<body>
<h2>Danh sách Mượn Trả Sách</h2>
<table border="1">
    <tr>
        <th>Mã Mượn Sách</th>
        <th>Mã Thẻ</th>
        <th>Tiền Đặt Cọc</th>
        <th>Ghi Chú</th>
    </tr>
    <c:forEach var="muonTraSach" items="${muonTraSachList}">
        <tr>
            <td>${muonTraSach.maMuonSach}</td>
            <td>${muonTraSach.maThe}</td>
            <td>${muonTraSach.tienDatCoc}</td>
            <td>${muonTraSach.ghiChu}</td>
        </tr>
    </c:forEach>
</table>

<h2>Danh sách Chi Tiết Mượn Trả Sách</h2>
<table border="1">
    <tr>
        <th>Mã Mượn Sách</th>
        <th>Mã Sách</th>
        <th>Ngày Mượn</th>
        <th>Ngày Trả</th>
    </tr>
    <c:forEach var="muonTraSachChiTiet" items="${muonTraSachChiTietList}">
        <tr>
            <td>${muonTraSachChiTiet.maMuonSach}</td>
            <td>${muonTraSachChiTiet.maCuonSach}</td>
            <td>${muonTraSachChiTiet.ngayMuon}</td>
            <td>${muonTraSachChiTiet.ngayTra}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>