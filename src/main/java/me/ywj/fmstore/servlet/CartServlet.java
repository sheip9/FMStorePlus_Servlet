package me.ywj.fmstore.servlet;

import me.ywj.fmstore.dto.CartDto;
import me.ywj.fmstore.service.CartService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * CartQueryServlet
 *
 * @author sheip9
 * @since 2023/11/7 14:13
 */
@WebServlet("/cart/list")
public class CartServlet extends MyHttpServlet {
    private final CartService service = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String json = gson.toJson(service.listCart(1L));
        out.print(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CartDto cartDto = fromJson(req, CartDto.class);
        boolean isSuccess = service.add(cartDto);

    }
}
