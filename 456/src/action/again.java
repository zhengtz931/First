package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import dao.StudentDao;

public class again {
	//第一步计算Bij，即第i门课第j个能力点一共有多少人选了
	public static int[][] course(String number) throws SQLException
	{
	Connection conn=StudentDao.getConnection();
	if (conn == null) {
		System.out.println(conn);
	}
	java.sql.Statement stmt = conn.createStatement();
//	Statement stmt =  conn.createStatement();
//	ResultSet rs = stmt.executeQuery("select username,password from admin where username = ? and password = ?");
 	String sql = "select * from student where number = ? ";
	PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
	ptmt.setString(1,number);
	ResultSet rs=ptmt.executeQuery();
	int b[][] = new int[10][6];
	int i =0;
	int j = 0;
	int k = 0;
	while(rs.next())
	{
		int a = rs.getInt("id");
		String sql1 = "select relationship.c_id,course.term from relationship,course where s_id = ? and relationship.c_id = course.id";
		PreparedStatement ptmt1=(PreparedStatement) conn.prepareStatement(sql1);
		ptmt1.setInt(1, a);
		ResultSet rs1=ptmt1.executeQuery();
		
		while(rs1.next())
		{
			if (rs1.getInt("term") == 2018) {
			
				b[0][i] = rs1.getInt("c_id");
				i++;
			}
			if (rs1.getInt("term") == 2019) {
			
				b[1][j] = rs1.getInt("c_id");
				j++;
			}
			if (rs1.getInt("term") == 2020) {
			
				b[2][k] = rs1.getInt("c_id");
				k++;
			}
	
	
			
		}
	}
	return b;

}
}
