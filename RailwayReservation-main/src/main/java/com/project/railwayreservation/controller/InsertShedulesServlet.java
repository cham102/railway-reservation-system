package com.project.railwayreservation.controller;

import com.project.railwayreservation.CRUD.DanujaCRUD.DanujaInsert;
import com.project.railwayreservation.CRUD.DanujaCRUD.DanujaSelect;
import com.project.railwayreservation.model.TrainSchedule;
import com.project.railwayreservation.model.TrainStations;
import com.project.railwayreservation.model.Trains;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

@WebServlet("/insert")
public class InsertShedulesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<TrainStations> stations = null;
        List<Trains> trains = null;
        try {
            stations = DanujaSelect.selectAllStations();
            trains = DanujaSelect.selectAllTrains();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("stations", stations);
        req.setAttribute("trains", trains);
        RequestDispatcher rd = req.getRequestDispatcher("views/add-schedules.jsp");
        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws  IOException {
        int tid = Integer.parseInt(req.getParameter("train"));
        int fromId = Integer.parseInt(req.getParameter("from"));
        int toId = Integer.parseInt(req.getParameter("to"));
        Date date = Date.valueOf(req.getParameter("date"));
        Time time = Time.valueOf(req.getParameter("time")+":0");

        TrainSchedule shedule = new TrainSchedule(tid, date, time, fromId, toId);

        try {
            DanujaInsert.insertShedules(shedule);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        res.sendRedirect("/admin-schedules");

    }
}
