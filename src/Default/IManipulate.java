package Default;

import java.util.ArrayList;

public interface IManipulate<O> {

    public O getOne(Object identify);
    public ArrayList<O> getAll();
    public boolean insert (O object);
    public boolean delete (int identify);
    public boolean update (O object);

}
