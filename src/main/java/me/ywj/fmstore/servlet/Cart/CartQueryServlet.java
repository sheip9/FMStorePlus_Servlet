package me.ywj.fmstore.servlet.Cart;

import com.google.gson.Gson;
import me.ywj.fmstore.service.CartService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * CartQueryServlet
 *
 * @author sheip9
 * @since 2023/11/7 14:13
 */
@WebServlet("/cart/list")
public class CartQueryServlet extends HttpServlet {
    private final Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String json = gson.toJson(CartService.listCart(1L));
        out.print(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
