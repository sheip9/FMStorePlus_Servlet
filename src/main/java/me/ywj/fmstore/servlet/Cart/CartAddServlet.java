package me.ywj.fmstore.servlet.Cart;

import me.ywj.fmstore.dto.CartDto;
import me.ywj.fmstore.service.UserService;
import me.ywj.fmstore.util.JWTUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CartAddServlet
 *
 * @author sheip9
 * @since 2023/10/24 14:29
 */
@WebServlet("/cart/add")
public class CartAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        Long productId = Long.valueOf(req.getParameter("product_id"));
        Long amount = 1L;
        String username = JWTUtil.extractClaim(req, "username");
        Long userId = UserService.getUserId(username);
        CartDto cartDto = new CartDto(userId, productId, amount);
    }
}
