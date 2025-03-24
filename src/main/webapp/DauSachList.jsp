<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Books Store Application</title>
</head>
<body>
	<center>
		<h1>Books Management</h1>
        <h2>
        	<a href="new">Add New Book</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Books</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>MaDauSach</th>
                <th>MaNxb</th>
                <th>MaTheLoai</th>
                <th>TenDauSach</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="dauSach" items="${listDauSach}">
                <tr>
                    <td><c:out value="${dauSach.MaDauSach}" /></td>
                    <td><c:out value="${dauSach.MaNxb}" /></td>
                    <td><c:out value="${dauSach.MaTheLoai}" /></td>
                    <td><c:out value="${dauSach.TenDauSach}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${dauSach.MaDauSach}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${dauSach.MaDauSach}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
