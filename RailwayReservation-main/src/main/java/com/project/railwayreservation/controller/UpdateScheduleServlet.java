package com.project.railwayreservation.controller;

import com.project.railwayreservation.CRUD.DanujaCRUD.DanujaUpdate;
import com.project.railwayreservation.model.TrainSchedule;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

@WebServlet("/updateSh")
public class UpdateScheduleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int tid = Integer.parseInt(req.getParameter("train"));
        int fid =Integer.parseInt(req.getParameter("from"));
        int toid = Integer.parseInt(req.getParameter("to"));
        Date date = Date.valueOf(req.getParameter("date"));
        Time time = Time.valueOf(req.getParameter("time")+":0");

        TrainSchedule updatedt = new TrainSchedule(tid, date, time, fid, toid);
        TrainSchedule exsistingt = ShowSchedulesServlet.toUpdateSchedule;

        try {
            DanujaUpdate.updateSchedule(updatedt, exsistingt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.sendRedirect("/admin-schedules");
    }
}
