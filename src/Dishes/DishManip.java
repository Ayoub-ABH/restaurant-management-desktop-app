package Dishes;

import Default.Connect;
import Default.IManipulate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

public class DishManip implements IManipulate<Dish> {
    private PreparedStatement pstate;
    private Connection con = Connect.getCon();
    private ResultSet resultSet;

    @Override
    public Dish getOne(Object identify) {
        Dish dish = null;
        try{
            pstate = con.prepareStatement("SELECT * FROM Dishes WHERE lower(name) like ?");
            pstate.setString(1,((String)identify).toLowerCase(Locale.ROOT) );
            resultSet = pstate.executeQuery();
            while (resultSet.next()){
                dish = new Dish(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("timeToCook"),
                        resultSet.getString("type"));
            }
            pstate.close();
        }catch (SQLException e){
            e.getMessage();
        }
        return dish;
    }

    @Override
    public ArrayList<Dish> getAll() {
        ArrayList<Dish> LD=new ArrayList<>();
        String str="SELECT * FROM Dishes ";
        try{
            pstate= con.prepareStatement(str);
            resultSet= pstate.executeQuery();
            while(resultSet.next()){
                Dish D=new Dish(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("timeToCook"),
                        resultSet.getString("type"));
                LD.add(D);
            }

        }catch (SQLException e){
            e.getMessage();
        }

        return LD;
    }

    @Override
    public boolean insert(Dish object) {
        String str="INSERT INTO Dishes VALUES (?,?,?,?,?,?)";
        try{
            pstate=con.prepareStatement(str);
            pstate.setInt(1,object.getId());
            pstate.setString(2,object.getName());
            pstate.setFloat(3,object.getPrice());
            pstate.setString(4,object.getDescription());
            pstate.setInt(5,object.getTimeToCook());
            pstate.setString(6,object.getType());
            pstate.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }

        return true;
    }

    @Override
    public boolean delete(int identify) {
        String str="delete from Dishes where id=?";
        try {
            pstate=con.prepareStatement(str);
            pstate.setInt(1,identify);
            pstate.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
        return true;
    }

    @Override
    public boolean update(Dish object) {
        String str="update Dishes set  name=?, price=?, description=?, timeToCook=?, type=? where id=?";
        try{
            pstate=con.prepareStatement(str);
            pstate.setInt(6,object.getId());
            pstate.setString(1,object.getName());
            pstate.setFloat(2,object.getPrice());
            pstate.setString(3,object.getDescription());
            pstate.setInt(4,object.getTimeToCook());
            pstate.setString(5,object.getType());
            pstate.executeUpdate();
        }catch(SQLException e){
            e.getMessage();
        }
        return true;
    }


}
