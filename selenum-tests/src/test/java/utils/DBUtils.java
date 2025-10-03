package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBUtils {

	
		public static List<Object[]> leerSumas() {
			List<Object[]> datos = new ArrayList<>();
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://root:password@localhost:3306/ejemplo");
				
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery("select num1,num2,res from sumas");
				
				while(rs.next()) {
					String num1 = rs.getString("num1");
					String num2 = rs.getString("num2");
					String res = rs.getString("res");
					datos.add(new Object[] {num1, num2, res});
				}
						
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return datos;
			
		}
	
}
