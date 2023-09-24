package me.ywj.fmstore.servlet.Item;

import me.ywj.fmstore.dto.ItemDto;
import me.ywj.fmstore.service.ItemService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del")
public class ItemDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        ItemService.delete(new ItemDto(Long.parseLong(id)));
    }
}
