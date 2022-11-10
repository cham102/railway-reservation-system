package com.project.railwayreservation.controller;

import com.project.railwayreservation.CRUD.DanujaCRUD.DanujaDelete;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

@WebServlet("/delete")
public class DeleteSchedulesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        PrintWriter out = res.getWriter();

        int tid = Integer.parseInt(req.getParameter("tid"));
        int fStation = Integer.parseInt(req.getParameter("fstation"));
        int tStation = Integer.parseInt(req.getParameter("tstation"));
        Date date = Date.valueOf(req.getParameter("date"));
        Time time = Time.valueOf(req.getParameter("time"));

        try{
           if( DanujaDelete.deleteSchedule(tid,fStation,tStation,date,time)){
               res.sendRedirect("/admin-schedules");
           }else{
                out.println("<h1>Error While Deleting!</h1>");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
