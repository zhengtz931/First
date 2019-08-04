package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import dao.StudentDao;
import sun.security.util.Password;

public class StudentLogin {
	public static boolean login(String number,String password) throws SQLException
	{
	Connection conn=StudentDao.getConnection();
	if (conn == null) {
		System.out.println(conn);
	}
	
	java.sql.Statement stmt = conn.createStatement();
//	Statement stmt =  conn.createStatement();
//	ResultSet rs = stmt.executeQuery("select number,password from admin where number = ? and password = ?");
 	String sql = "select * from student where number = ? and password = ?";
	PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
	ptmt.setString(1,number);
	ptmt.setString(2, password);
	ResultSet rs=ptmt.executeQuery();
	if(rs.next())
	{
		System.out.println("登录成功");
		return true;
		
	}
	else
	{
		return false;
	}
	

}
}