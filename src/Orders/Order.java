package Orders;


import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {

    private static final long serialVersionUID = 6L;
    private int id;
    private float total_price;
    private int id_client;
    private int id_waiter;
    private int id_cooker;
    private int table;
    private Date creation_date;
    private Date treated_date;

    public Order(int id, float total_price, int id_client, int id_waiter, int id_cooker, int table, Date creation_date, Date treated_date) {
        this.id = id;
        this.total_price = total_price;
        this.id_client = id_client;
        this.id_waiter = id_waiter;
        this.id_cooker = id_cooker;
        this.table = table;
        this.creation_date = creation_date;
        this.treated_date = treated_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_waiter() {
        return id_waiter;
    }

    public void setId_waiter(int id_waiter) {
        this.id_waiter = id_waiter;
    }

    public int getId_cooker() {
        return id_cooker;
    }

    public void setId_cooker(int id_cooker) {
        this.id_cooker = id_cooker;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getTreated_date() {
        return treated_date;
    }

    public void setTreated_date(Date treated_date) {
        this.treated_date = treated_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total_price=" + total_price +
                ", id_client=" + id_client +
                ", id_waiter=" + id_waiter +
                ", id_cooker=" + id_cooker +
                ", table=" + table +
                ", creation_date=" + creation_date +
                ", treated_date=" + treated_date +
                '}';
    }
}
