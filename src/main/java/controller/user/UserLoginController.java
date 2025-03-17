package controller.user;

import dao.implement.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;
import model.Users;

import java.io.IOException;


@WebServlet("/login")
public class UserLoginController extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("save-for-next");

        // Validate user
        Users user = userDAO.validateUser(email, password);

        if (user != null) {
            // Tạo session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Xử lý "Remember me"
            if ("on".equals(rememberMe)) {
                Cookie emailCookie = new Cookie("userEmail", email);
                emailCookie.setMaxAge(30 * 24 * 60 * 60); // 30 ngày
                response.addCookie(emailCookie);
            }

            // Chuyển hướng tới trang dashboard
            response.sendRedirect("homepage.jsp");
        } else {
            // Nếu login thất bại, gửi thông báo lỗi về form
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("loginModal.j").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Nếu truy cập bằng GET, hiển thị form login
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
    }

}

