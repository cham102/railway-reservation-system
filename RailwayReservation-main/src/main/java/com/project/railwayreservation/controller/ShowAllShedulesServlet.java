package com.project.railwayreservation.controller;

import com.project.railwayreservation.CRUD.DanujaCRUD.DanujaSelect;
import com.project.railwayreservation.model.TrainSchedule;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin-schedules")
public class ShowAllShedulesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<TrainSchedule> shedules = null;
        try {
            shedules = DanujaSelect.selectAllSchedules();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("shedules", shedules);
        RequestDispatcher rd = req.getRequestDispatcher("views/admin_schedules.jsp");
        rd.forward(req, res);
    }
}
