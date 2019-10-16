package com.codegym.servletTask.web;

import javax.servlet.http.*;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int attempt = 1;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("gameAttempt")) {
                attempt = Integer.parseInt(cookie.getValue());
                attempt++;
                cookie.setValue("" + attempt);
                resp.addCookie(cookie);
                break;
            }
        }
        if (attempt == 1) {
            Cookie cookie = new Cookie("gameAttempt", "" + attempt);
            resp.addCookie(cookie);
        }
        HttpSession session = req.getSession(true);
        String name = req.getParameter("name");
        session.setAttribute("name", name);
        resp.sendRedirect("/quest");
    }
}
