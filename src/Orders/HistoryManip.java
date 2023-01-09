package Orders;

import Default.Connect;
import Default.IManipulate;

import java.sql.*;
import java.util.ArrayList;

public class HistoryManip implements IManipulate<History> {

    private Connection con = Connect.getCon();
    private PreparedStatement ps;
    private Statement s;
    private ResultSet rs;



    @Override
    public History getOne(Object identify) {
        return null;
    }

    @Override
    public ArrayList<History> getAll() {

        ArrayList<History> histories = new ArrayList<>();
        try{
            s = con.createStatement();
            rs = s.executeQuery("SELECT * FROM History");

            while (rs.next()){
                histories.add(new History(rs.getInt("id_client"),rs.getInt("id_order"),rs.getInt("id_dish"), rs.getInt("quantity")));
            }
            s.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return histories;
    }
    public ArrayList<History> getAllByDish(int d, int o, int c) {

        ArrayList<History> histories = new ArrayList<>();
        try{
            ps = con.prepareStatement("SELECT * FROM History WHERE id_dish = ? and id_order = ? and id_client = ?");
            ps.setInt(1,d);
            ps.setInt(2,o);
            ps.setInt(3,c);
            rs = ps.executeQuery();

            while (rs.next()){
                histories.add(new History(rs.getInt("id_client"),rs.getInt("id_order"),rs.getInt("id_dish"), rs.getInt("quantity")));
            }
            ps.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return histories;
    }

    @Override
    public boolean insert(History o) {
        try {
            ps = con.prepareStatement("INSERT INTO HISTORY VALUES (?,?,?,?)");
            ps.setInt(1,o.getId_client());
            ps.setInt(2,o.getId_order());
            ps.setInt(3,o.getId_dish());
            ps.setInt(4,o.getQuantity());

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
    public boolean update(History object) {
        return false;
    }
}
