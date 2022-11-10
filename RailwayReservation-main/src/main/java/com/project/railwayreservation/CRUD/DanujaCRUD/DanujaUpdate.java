package com.project.railwayreservation.CRUD.DanujaCRUD;

import com.project.railwayreservation.connection.JDBCUtils;
import com.project.railwayreservation.model.TrainSchedule;

import java.sql.*;

public class DanujaUpdate {

     private static final String UPDATE_SCHEDULE = "update shedules set tid=?, fromStationId=?, toStationId=?, sdate=?, stime=? where tid=? and fromStationId=? and toStationId=? and sdate=? and stime=?";

     public static boolean updateSchedule(TrainSchedule schedule, TrainSchedule scheduleW) throws SQLException {
         boolean isRowUpdated;

         try(Connection con = JDBCUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_SCHEDULE)){
             ps.setInt(1, schedule.getTid());
             ps.setInt(2, schedule.getFromId());
             ps.setInt(3, schedule.getToId());
             ps.setDate(4, (Date) schedule.getDate());
             ps.setTime(5,schedule.getTime());

             ps.setInt(6, scheduleW.getTid());
             ps.setInt(7, scheduleW.getFromId());
             ps.setInt(8, scheduleW.getToId());
             ps.setDate(9, (Date) scheduleW.getDate());
             ps.setTime(10, scheduleW.getTime());

             isRowUpdated = ps.executeUpdate() > 0;
         }
         return isRowUpdated;
     }
}
