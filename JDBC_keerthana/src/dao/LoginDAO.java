package dao;

import java.sql.*;

import ConnectionManager.ConnectionManager;

import model.Login;

public class LoginDAO {

    public boolean validate(Login login) throws ClassNotFoundException, SQLException

    {

    	String username=login.getUsername();

    	String Password=login.getPassword();

    	ConnectionManager conn = new ConnectionManager();

    	Connection con = conn.establishConnection();

    	//Create a statement obj to execute a query

    	Statement st=con.createStatement();

    	//Execute the statement obj and return a query resultset

    	ResultSet rs=st.executeQuery("Select * from login");

    	while(rs.next())

    	{

    		if(username.equals(rs.getString("username"))&& Password.equals(rs.getString("password")))

    		{

    			//close the connection

    			conn.closeConnection();

    			return true;

    				}

    	}

    	conn.closeConnection();

    	return false;

    }

}



