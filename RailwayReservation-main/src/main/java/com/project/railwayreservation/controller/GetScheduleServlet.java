package com.project.railwayreservation.controller;

import com.project.railwayreservation.CRUD.DanujaCRUD.DanujaSelect;
import com.project.railwayreservation.model.TrainSchedule;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/getschedule")
public class GetScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int fromId = Integer.parseInt(req.getParameter("from"));
        int toId = Integer.parseInt(req.getParameter("to"));
        Date sDate = Date.valueOf(req.getParameter("date"));
        int seats = Integer.parseInt(req.getParameter("seats"));

        List<TrainSchedule> listSchedules = null;

        try {
            listSchedules = DanujaSelect.selectSchedule(fromId, toId, sDate, seats);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("listShedules", listSchedules);
        RequestDispatcher rd = req.getRequestDispatcher("views/home.jsp");
        rd.forward(req, res);
    }

}
