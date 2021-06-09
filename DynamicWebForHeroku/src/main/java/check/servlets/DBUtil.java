package check.servlets;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil 
{
	Connection connection=null;
	static Connection getConnection() throws URISyntaxException, SQLException
	{
		URI dbu=new URI("postgres://lspgnzrpxbkvxi:d808900c579ee255fa35b18ab6f81c3cc5d2aafa3d9f4bbb965788a32a1d919f@\r\nec2-54-74-60-70.eu-west-1.compute.amazonaws.com:5432/d3lr7ih8pubb7m");
		String username=dbu.getUserInfo().split(":")[0];
		String pass=dbu.getUserInfo().split(":")[1];
		String ur="jdbc:postgresql://"+dbu.getHost()+":"+dbu.getPort()+dbu.getPath();
		return DriverManager.getConnection(ur,username,pass);
		
	}
}
