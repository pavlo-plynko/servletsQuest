package com.codegym.servletTask.web;

import com.codegym.servletTask.model.Step;
import com.codegym.servletTask.model.Repository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class QuestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String option = request.getParameter("option");
        Integer optionId = option == null ? 1 : Integer.parseInt(option);
        Step step = Repository.getStepById(optionId);
        request.setAttribute("step", step);
        addStatistics(request);
        request.getRequestDispatcher("/quest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    private void addStatistics(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        request.setAttribute("userName", session.getAttribute("name"));
        request.setAttribute("ip", request.getRemoteAddr());
        request.setAttribute("attempt", findCookiesValueByName("gameAttempt", cookies));
    }

    private String findCookiesValueByName(String name, Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
