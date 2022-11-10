package com.project.railwayreservation.controller;

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

@WebServlet("/")
public class ShowSchedulesServlet extends HttpServlet {

    public static TrainSchedule toUpdateSchedule;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getServletPath();

        switch(action) {
            case "/update" : {
                try {
                    showUpdateForm(req, res);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            default:
                List<TrainStations> stations = null;
                try {
                    stations = DanujaSelect.selectAllStations();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                req.setAttribute("stations", stations);
                RequestDispatcher rd = req.getRequestDispatcher("views/home.jsp");
                rd.forward(req, res);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ServletException {
        int tid = Integer.parseInt(req.getParameter("tid"));
        String tname = req.getParameter("tname");
        int fid = Integer.parseInt(req.getParameter("fid"));
        String fname = req.getParameter("fname");
        int toid = Integer.parseInt(req.getParameter("toid"));
        String toname = req.getParameter("toname");
        Date date = Date.valueOf(req.getParameter("date"));
        Time time = Time.valueOf(req.getParameter("time"));

        TrainSchedule eSchedules = new TrainSchedule(tid, tname, fname, toname, date, time, fid, toid);
        toUpdateSchedule = new TrainSchedule(tid,date,time,fid,toid);

        List<TrainStations> stations = null;
        List<Trains> trains = null;

        try {
            stations = DanujaSelect.selectAllStations();
            trains = DanujaSelect.selectAllTrains();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("views/update-schedules.jsp");

        req.setAttribute("eSchedules", eSchedules);
        req.setAttribute("stations", stations);
        req.setAttribute("trains", trains);

        rd.forward(req, res);

    }

}



