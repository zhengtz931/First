package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import dao.StudentDao;

public class jisuan {
	
	public static double[] result(int a)throws SQLException
	{
		
		Connection conn=StudentDao.getConnection();
		if (conn == null) {
			System.out.println(conn);
		}
		java.sql.Statement stmt = conn.createStatement();
//		Statement stmt =  conn.createStatement();
//		ResultSet rs = stmt.executeQuery("select username,password from admin where username = ? and password = ?");
	 	String sql = "select * from relationship where c_id = ? ";
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, a);
		ResultSet rs=ptmt.executeQuery();
		int [] count = new int[5];
		int [] S = new int[5];
		double[] Zi;
		Zi = new double[5];
		for(int i = 0;i < 5;i++)
		{
			Zi[i] = 0;
		}
		while(rs.next())
		{
			//System.out.println(rs.getInt("value1"));
			
			if (rs.getInt("value1") != 0) {
				S[0] = S[0] + rs.getInt("value1"); 

				count[0] =count[0] + 1;
				
			}
			if (rs.getInt("value2") != 0) {
				S[1] = S[1] + rs.getInt("value1"); 
				count[1] =count[1] + 1;
				
			}
			if (rs.getInt("value3") != 0) {
				S[2] = S[2] + rs.getInt("value2"); 
				count[2] =count[2] + 1;
				
			}
			if (rs.getInt("value4") != 0) {
				S[3] = S[3] + rs.getInt("value3"); 
				count[3] =count[3] + 1;
				
			}
			if (rs.getInt("value5") != 0) {
				S[4] = S[4] + rs.getInt("value4"); 
				count[4] =count[4] + 1;
				
			}
			double Ai = 0;
			double X = 0;
			for(int i = 0; i < 5; i++)
			{
				Ai = Ai +  count[i];
				X = S[i] + X;
				
			}
			//所求Bij
			double p = 0;
			
			for(int i = 0; i < 5;i++)
			{
				p = count[i]/Ai;

			}
			
		
			
		}
		
		String sql1 = "select * from course where id = ? ";
		PreparedStatement ptmt1=(PreparedStatement) conn.prepareStatement(sql1);
		ptmt1.setInt(1, 1);
		
		ResultSet rs1=ptmt1.executeQuery();
		
	while(rs1.next())
		{
		
			for(int i = 0;i < 5;i++)
			{
				if(count[i] != 0)
				{
					if(i == 0)
					{
						double Y = S[i]/count[i];
						Zi[0] = 0.6*rs1.getInt("value1") +  0.4*Y + Zi[0];
					}
					if(i == 1)
					{
						double Y = S[i]/count[i];
						Zi[1] = 0.6*rs1.getInt("value2") +  0.4*Y + Zi[1];
					}
					if(i == 2)
					{
						double Y = S[i]/count[i];
						Zi[2] = 0.6*rs1.getInt("value3") +  0.4*Y + Zi[2];
					}
					if(i == 3)
					{
						double Y = S[i]/count[i];
						Zi[3] = 0.6*rs1.getInt("value4") +  0.4*Y + Zi[3];
					}
					if(i == 4)
					{
						double Y = S[i]/count[i];
						Zi[4] = 0.6*rs1.getInt("value5") +  0.4*Y + Zi[4];
			
					}
					
					
					
					
				}
			
			}
			
		}

	return Zi;
	}
}
