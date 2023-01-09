package Users;

import Default.Connect;
import Default.IManipulate;

import java.sql.*;
import java.util.ArrayList;

public class UserManip implements IManipulate<User> {

    private Connection con = Connect.getCon();
    private Statement state;
    private PreparedStatement pstate;
    private ResultSet resultSet;

    @Override
    public User getOne(Object identify) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() {

        ArrayList<User> users = new ArrayList<>();
        try {
            state = con.createStatement();
            resultSet = state.executeQuery("Select* FROM Users");
            while (resultSet.next()){
                users.add(new User(resultSet.getString("Username"),resultSet.getString("password")));
            }

        }catch(SQLException e){
            e.getMessage();
        }
        return users;
    }

    @Override
    public boolean insert(User object) {
        return false;
    }

    @Override
    public boolean delete(int identify) {
        return false;
    }

    @Override
    public boolean update(User object) {
        return false;
    }
}
