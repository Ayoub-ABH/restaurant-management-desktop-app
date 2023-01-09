package Persons;

import Default.Connect;
import Default.IManipulate;

import java.sql.*;
import java.util.ArrayList;

public class CustomerManip implements IManipulate<Customer> {

    private Connection con = Connect.getCon();
    private PreparedStatement ps;
    private Statement s;
    private ResultSet rs;

    @Override
    public Customer getOne(Object identify) {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }

    @Override
    public boolean insert(Customer o) {

        try {
            ps = con.prepareStatement("INSERT INTO Customers VALUES (?,?)");
            ps.setInt(1,o.getId());
            ps.setString(2,o.getName());


            int t = ps.executeUpdate();
            if (t!=0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int identify) {
        return false;
    }

    @Override
    public boolean update(Customer object) {
        return false;
    }
}
