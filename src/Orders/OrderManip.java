package Orders;

import Default.Connect;
import Default.IManipulate;

import java.sql.*;
import java.util.ArrayList;

public class OrderManip implements IManipulate<Order> {

    private Connection con = Connect.getCon();
    private PreparedStatement ps;
    private Statement s;
    private ResultSet rs;

    @Override
    public Order getOne(Object identify) {
        return null;
    }

    @Override
    public ArrayList<Order> getAll() {
        return null;
    }

    @Override
    public boolean insert(Order o) {
        try {
            ps = con.prepareStatement("INSERT INTO ORDERS VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1,o.getId());
            ps.setFloat(2,o.getTotal_price());
            ps.setInt(3,o.getId_client());
            ps.setInt(4,o.getId_waiter());
            ps.setInt(5,o.getId_cooker());
            ps.setInt(6,o.getTable());
            ps.setDate(7,o.getCreation_date());
            ps.setDate(8,o.getTreated_date());

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
    public boolean update(Order object) {
        return false;
    }
}
