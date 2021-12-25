package com.modules.Tourism.repository;

import com.modules.Student.EducationalCenter;
import com.modules.Tourism.TourPlace;
import org.hibernate.Session;

import javax.ejb.Stateful;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static com.modules.database.ConnectionDatabase.connectDB;

@Stateful
public class TourRepository {

    public void addTourPlace(TourPlace tourPlace, Session session){
        session.save(tourPlace);
    }


//    public void addTourPlace(TourPlace tourPlace) throws SQLException {
//        Connection conn = connectDB();
//        Statement stmt = null;
//        PreparedStatement ps = conn.prepareStatement("INSERT INTO tourists(placename, address, phone, placetype, cityid) " +
//                "values (?,?,?,?, (select id from city where city.category='tourist'))");
//        ps.setString(1, tourPlace.getPlaceName());
//        ps.setString(2, tourPlace.getAddress());
//        ps.setString(3, tourPlace.getPhone());
//        ps.setString(4, tourPlace.getPlaceType());
//        ps.executeUpdate();
//    }
}
