package me.ywj.fmstore.servlet;

import com.google.gson.Gson;
import me.ywj.fmstore.dto.CartDto;
import me.ywj.fmstore.pojo.RestResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

/**
 * MyHttpServlet
 *
 * @author sheip9
 * @since 2023/12/27 19:12
 */
public class MyHttpServlet extends HttpServlet {
    protected final Gson gson = new Gson();
    private static final String METHOD_PATCH = "PATCH";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        if(method.equals(METHOD_PATCH)) {
            doPatch(req, resp);
        }
        super.service(req, resp);
    }

    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "");
    }
    public <T> T fromJson(HttpServletRequest req,Class<T> clazz) throws IOException {
        BufferedReader reader = req.getReader();
        return gson.fromJson(reader, clazz);
    }
    public String toJson(Object object){
        return gson.toJson(object);
    }
    public void printJson(HttpServletResponse resp, Object o) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        out.print(toJson(o));
    }
    public void printRestResponse(HttpServletResponse resp, RestResponse<?> restBody) throws IOException {
        resp.setStatus(restBody.getCode());
        printJson(resp, restBody);
    }
}
