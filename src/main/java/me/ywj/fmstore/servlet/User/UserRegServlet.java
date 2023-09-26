package me.ywj.fmstore.servlet.User;

import com.google.gson.Gson;
import me.ywj.fmstore.dto.UserDto;
import me.ywj.fmstore.service.UserService;
import me.ywj.fmstore.vo.UserVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reg")
public class UserRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDto userDto = new UserDto(username, password);
        UserVo userVo = UserService.reg(userDto);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(userVo);
        out.print(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
