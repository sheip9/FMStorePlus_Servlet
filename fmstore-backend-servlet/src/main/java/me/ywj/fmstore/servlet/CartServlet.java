package me.ywj.fmstore.servlet;

import me.ywj.fmstore.dto.CartDto;
import me.ywj.fmstore.pojo.RestResponse;
import me.ywj.fmstore.service.CartService;
import me.ywj.fmstore.service.UserService;
import me.ywj.fmstore.util.JWTUtil;

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
@WebServlet("/cart")
public class CartServlet extends MyHttpServlet {
    private final CartService service = new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        String username = JWTUtil.extractClaim(req, "username");
        Long userId = UserService.getUserId(username);
        printRestResponse(resp, new RestResponse<>(200, "", service.listCart(userId)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CartDto cartDto = fromJson(req, CartDto.class);
        boolean isSuccess = service.add(cartDto);
        RestResponse<?> restResponse = isSuccess ? new RestResponse<>(201, "已添加至购物车") : new RestResponse<>(500, "添加失败");
        printRestResponse(resp,restResponse);
    }
}
