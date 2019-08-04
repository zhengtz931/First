package action;

import java.sql.SQLException;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class ceshi {
	public static double[] grade(String x) throws SQLException
	{
	
		//jisuan.result(43);
		int a[][] = new int[6][5];
		 a = again.course(x);
		 double[] b = new double[5];
		 double[] c = new double[5];
		 for(int i = 0;i < 5;i++)
		 {
			 c[i] = 0;
		 }
		 for(int i = 0; i < 3; i++)
			 for(int j =0; j < 5;j++)
			 {
				 if (a[i][j] != 0) 
				 {
					b =  jisuan.result(a[i][j]);
					c[1] = c[1] + b[1];
					c[2] = c[2] + b[2];
					c[3] = c[3] + b[3];
					c[4] = c[4] + b[4];
					c[0] = c[0] + b[0];
					
				}
				 
				
			 }
		return c;
		 		
		 	
	
	}

}
