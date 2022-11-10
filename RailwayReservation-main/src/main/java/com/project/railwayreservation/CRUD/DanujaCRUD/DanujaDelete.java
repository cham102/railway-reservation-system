package com.project.railwayreservation.CRUD.DanujaCRUD;

import com.project.railwayreservation.connection.JDBCUtils;

import java.sql.*;

public class DanujaDelete {

//    SQL QUERY
//    DELETE
    private static final String DELETE_SCHEDULE = "delete from shedules where tid=? and fromStationId=? and toStationId=? and sdate=? and stime=?";

    public static boolean deleteSchedule(int tid, int fStation, int tStation, Date sdate, Time stime) throws SQLException {
        boolean isRowDeleted;

        try(Connection con = JDBCUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(DELETE_SCHEDULE)){
            ps.setInt(1, tid);
            ps.setInt(2, fStation);
            ps.setInt(3, tStation);
            ps.setDate(4, sdate);
            ps.setTime(5, stime);

            isRowDeleted = ps.executeUpdate() > 0;
        }
        return isRowDeleted;
    }

}
