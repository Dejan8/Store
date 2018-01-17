package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    private final Connection conn;

    public CustomerDao() throws SQLException {
        conn = ConnDb.Connection.getConnection();
    }

    public void addCustomer(Person personBean) throws ClassNotFoundException, SQLException {
        String flowRate = personBean.getFlowRate();
        String rate = personBean.getRate();
        String duration = personBean.getDuration();
        String name = personBean.getName();
        String address = personBean.getAddress();
        
        Statement st = conn.createStatement();
        st.execute("insert into person(FlowRate,Rate,Duration,PersonName,Address) values('" + flowRate + "','" + rate + "','" + duration + "','" + name + "','" + address + "')");
        
    }

    public List getAllCustomers() {
        List customers = new ArrayList();
        try {

            String sql = "SELECT * FROM person";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Person personBean = new Person();
                personBean.setId(rs.getInt("PersonID"));
                personBean.setFlowRate(rs.getString("FlowRate"));
                personBean.setRate(rs.getString("Rate"));
                personBean.setDuration(rs.getString("Duration"));
                personBean.setName(rs.getString("PersonName"));
                personBean.setAddress(rs.getString("Address"));
                customers.add(personBean);
                
                
            }
        } catch (SQLException e) {
        }

        return customers;
    }

    public void deleteCustomer(int PersonID) {
        try {
            String sql = "DELETE FROM person WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, PersonID);
            ps.executeUpdate();
            
        } catch (SQLException e) {
        }
    }

 

   

   
}
