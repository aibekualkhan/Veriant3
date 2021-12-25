package com.modules.Administration.Domain.repository;


import com.modules.Administration.Domain.User;
import org.hibernate.Session;

import javax.ejb.Stateful;
import java.sql.*;
import java.util.List;

import static com.modules.database.ConnectionDatabase.connectDB;

@Stateful
public class UserRepository {

    public void addUser(User user, Session session){
        session.save(user);
    }

    public List<User> getAll(Session session){
        return session.createQuery("SELECT a FROM User a", User.class).getResultList();
    }
    public User getUserById(Long id, Session session){
        return session.get(User.class, id);
    }

    public void update(User user, Session session) {
        session.update(user);
    }

    public void delete(User user, Session session) {
        session.delete(user);
    }
//    public void addUser(User user) throws SQLException {
//        Connection conn = connectDB();
//        Statement stmt = null;
//        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username, password, usertype) " +
//                "values (?,?,?)");
//        ps.setString(1, user.getUsername());
//        ps.setString(2, user.getPassword());
//        ps.setString(3, user.getUsertype());
//        ps.executeUpdate();
//    }

    /*public List<User> getUsers() throws SQLException{
        Connection conn = connectDB();
        Statement stmt = null;
        stmt = conn.createStatement();
        List<User> users = new ArrayList<>();
        User user;
        String sql = "SELECT * FROM students";
        ResultSet res = stmt.executeQuery(sql);
        while(res.next()) {
            int id = res.getInt("id");
            String username = res.getString("username");
            String password = res.getString("password");
            int typeId = res.getInt("typeId");
            user = new User(id, username, password, typeId);
            users.add(user);
        }
        return users;
    }
    public User getUserById(int id) throws SQLException {
        User user = null;
        Connection connection = connectDB();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * users WHERE  id = ?");
        preparedStatement.setInt(1, id);
        System.out.println(preparedStatement);
        ResultSet res = preparedStatement.executeQuery();
        while (res.next()) {
            String username = res.getString("username");
            String password = res.getString("password");
            int typeId = res.getInt("typeId");
            user = new User(id, username, password, typeId);
        }
        return user;
    }
    public void updateUser(int id, User user) throws  SQLException{
        Connection conn = connectDB();
        String query = "update users set username =?, password=?, typeId =? where id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString   (1, user.getUsername());
        preparedStmt.setString   (2, user.getPassword());
        preparedStmt.setInt   (3, user.getTypeId());
        preparedStmt.executeUpdate();
    }
    public void deleteUser(int id) throws  SQLException{
        Connection conn = connectDB();
        PreparedStatement preparedStmt = conn.prepareStatement("DELETE FROM users WHERE id=?;");
        preparedStmt.setInt(1, id);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }*/
}
