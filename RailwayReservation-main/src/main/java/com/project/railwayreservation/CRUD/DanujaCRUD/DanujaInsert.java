package com.project.railwayreservation.CRUD.DanujaCRUD;

import com.project.railwayreservation.connection.JDBCUtils;
import com.project.railwayreservation.model.TrainSchedule;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DanujaInsert {

    //INSERT QUERY
    private static final String INSERT_SCHEDULES = "insert into shedules(tid, fromStationId, toStationId, sdate, stime) values (?, ?, ?, ?, ?)";

    public static void insertShedules(TrainSchedule tShedules) throws SQLException {
        try(Connection con = JDBCUtils.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_SCHEDULES)){
            ps.setInt(1, tShedules.getTid());
            ps.setInt(2, tShedules.getFromId());
            ps.setInt(3, tShedules.getToId());;
            ps.setDate(4, (Date)tShedules.getDate());
            ps.setTime(5, tShedules.getTime());
            ps.executeUpdate();
        }
    }
}
