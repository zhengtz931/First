package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.xerces.internal.xinclude.XInclude11TextReader;
import com.sun.org.apache.xpath.internal.operations.And;

import dao.StudentDao;

public class test {
	public static void main(String[] args) throws SQLException
	{
		//计算第i门课程的第j个能力点的学生调查加权平均能力值
		//第一个参数是学生的第i门课
		//第二个参数是学生的第i门课的第j项能力
		//s[0][0]第一门课所占权重
		//s[0][1]第i门课程的第j个能力点专业评估能力值（即老师给出的能力点数值5,4,3,2,1）
		//s[0][2]第i门课程的第j个能力点的学生调查加权平均能力值
		//s[0][3]第i门课程的第j个能力点的能力值
		//学生调查中第i门课程的第j个能力点的选择人数：从数据库中读入查询
		
		//学生调查中第i门课程的第j个能力点的第k级提升程度的选择人数：数据库读入等级为1,2,3,4,5的人数
		
	
		Connection conn=StudentDao.getConnection();
		if (conn == null) {
			System.out.println(conn);
		}
		java.sql.Statement stmt = conn.createStatement();
//		Statement stmt =  conn.createStatement();
//		ResultSet rs = stmt.executeQuery("select username,password from admin where username = ? and password = ?");
     	String sql = "select * from user where course = ? ";
		//where username = ? and password = ?"
		PreparedStatement ptmt=(PreparedStatement) conn.prepareStatement(sql);
		for(int j = 0; j < 50; j++ )
		{
			int course = 42;
			double k = 0;
			double s[][] = new double[7][];
			double l[][] = new double[7][];
			int count[][] = new int[7][];
			s[0] = new double[7];
			l[0] = new double[7];
			count[0] = new int[7];
			count[1] = new int[7];
			count[2] = new int[7];
			count[3] = new int[7];
			count[4] = new int[7];
			count[5] = new int[7];
			int Z = 0;
			double S = 0;
			double X = 0;
			ptmt.setInt(1, j);
			ResultSet rs=ptmt.executeQuery();
			while(rs.next())
			{
				Z++;
				if(rs.getInt("a") == 1 )
				{
					count[0][0]++;
					s[0][0] = s[0][0] + 6-rs.getInt("1");
					if(rs.getInt("1") == 1)
						count[0][1]++;
					if(rs.getInt("1") == 2)
						count[0][2]++;
					if(rs.getInt("1") == 3)
						count[0][3]++;
					if(rs.getInt("1") == 4)
						count[0][4]++;
					if(rs.getInt("1") == 5)
						count[0][5]++;
				}
				
				if(rs.getInt("b") == 1 )
				{
					count[1][0]++;
					s[0][1] = s[0][1] + 6-rs.getInt("2");
					if(rs.getInt("2") == 1)
						count[1][1]++;
					if(rs.getInt("2") == 2)
						count[1][2]++;
					if(rs.getInt("2") == 3)
						count[1][3]++;
					if(rs.getInt("2") == 4)
						count[1][4]++;
					if(rs.getInt("2") == 5)
						count[1][5]++;
				}
				if(rs.getInt("c") == 1 )
				{
					count[2][0]++;
					s[0][2] = s[0][2] + rs.getInt("3");
					if(rs.getInt("3") == 1)
						count[2][1]++;
					if(rs.getInt("3") == 2)
						count[2][2]++;
					if(rs.getInt("3") == 3)
						count[2][3]++;
					if(rs.getInt("3") == 4)
						count[2][4]++;
					if(rs.getInt("3") == 5)
						count[2][5]++;
				}
				if(rs.getInt("d") == 1 )
				{
					count[3][0]++;
					s[0][3] = s[0][3] + 6-rs.getInt("4");
					if(rs.getInt("4") == 1)
						count[3][1]++;
					if(rs.getInt("4") == 2)
						count[3][2]++;
					if(rs.getInt("4") == 3)
						count[3][3]++;
					if(rs.getInt("4") == 4)
						count[3][4]++;
					if(rs.getInt("4") == 5)
						count[3][5]++;
				}
				if(rs.getInt("e") == 1 )
				{
					count[4][0]++;
					s[0][4] = s[0][4] + 6-rs.getInt("5");
					if(rs.getInt("5") == 1)
						count[4][1]++;
					if(rs.getInt("5") == 2)
						count[4][2]++;
					if(rs.getInt("5") == 3)
						count[4][3]++;
					if(rs.getInt("5") == 4)
						count[4][4]++;
					if(rs.getInt("5") == 5)
						count[4][5]++;
				}
			}
			//一共多少分+一共多少人
//	         System.out.println(s[0][0]);
//	         System.out.println(s[0][1]);
//	         System.out.println(s[0][2]);
//	         System.out.println(s[0][3]);
//	         System.out.println(s[0][4]);
			//所求的b[i][j]
			System.out.println("第j门课所有能力及等级选择人数：");
			for(int i = 0; i < 5; i++ )
			 for(int p = 1; p < 6; p++)
			 {
				 System.out.println(count[i][p]); 
				
			 }
			for(int i = 0; i < 5; i++)
				{
					k = s[0][i] + k;
				}
			for(int i = 0; i < 5; i++)
				for( int j1 = 1;j1 < 6; j1++)
				{
					X = count[i][j1] + X; 
				}
			//B[i][j]
	
			System.out.println("aij：学生调查中第i门课程的第j个能力点的选择人数");
	         System.out.println(count[0][0]);
	         System.out.println(count[1][0]);
	         System.out.println(count[2][0]);
	         System.out.println(count[3][0]);
	         System.out.println(count[4][0]);
	         //计算权重xij2
	         System.out.println("Ai:");
	         System.out.println(X);
	         double[] xij2 = new double[7];
	         System.out.println("xij2:");
	         for(int i = 0;i < 5; i++)
	         { 
	        	
	        	 xij2[i] = s[0][i] / count[i][0];
	        	 System.out.println(xij2[i]);
	         }
	
				
	         for(int i = 0; i < 5; i++)
	         {
	        	 System.out.println(count[i][0]/X);
	         }
	      
			//固定老师的评分为4
			int xij1 = 5;
			double zij;
			System.out.println("第i门课程第j个能力的能力值");
			for(int i = 0; i < 5; i++)
			{
				if(xij1 != 0 && (count[i][0]/X) != 0)
				{
					zij = 0.6*xij1 + 0.4*(count[i][0]/X)*xij2[i];
					System.out.println(zij);
					
				}
			}
			System.out.println("*****************************************");
//			double S = 0;
//			for(int i = 0; i < 2; i++)
//			{
//				S = s[i][1] + S; 
//			}
//			s[0][2] = S / 2;
	//
//			System.out.println(s[0][2]);
		}
		 
	}
 
}
