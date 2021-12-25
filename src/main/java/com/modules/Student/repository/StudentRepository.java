package com.modules.Student.repository;

import com.modules.Administration.Domain.User;
import com.modules.Student.EducationalCenter;
import org.hibernate.Session;

import javax.ejb.Stateful;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static com.modules.database.ConnectionDatabase.connectDB;

@Stateful
public class StudentRepository {
    public void addStudent(EducationalCenter educationalCenter, Session session){
        session.save(educationalCenter);
    }
//    public void addStudent(EducationalCenter eCenter) throws SQLException {
//        Connection conn = connectDB();
//        Statement stmt = null;
//        PreparedStatement ps = conn.prepareStatement("INSERT INTO students(ecname, address, phone, email, ectype, cityid) " +
//                "values (?,?,?,?,? , (select id from city where city.category='student'))");
//        ps.setString(1, eCenter.getECname());
//        ps.setString(2, eCenter.getAddress());
//        ps.setString(3, eCenter.getPhone());
//        ps.setString(4, eCenter.getEmail());
//        ps.setString(5, eCenter.getType());
//        ps.executeUpdate();
//    }
}
