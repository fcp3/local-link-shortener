import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.mysql.jdbc.Statement;


public class C1 {
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		String pw;
		String url = "jdbc:mysql://localhost/test";
		
		//System.out.println("Enter your mySQL password:");
		//pw = kb.next();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url, "root", "9218jB77");
			System.out.println("Enter the URL you want to shorten: ");
			String longURL = kb.next();
			
			String rand = String.valueOf(Math.random()*100000);
			StringTokenizer stringTokenizer = new StringTokenizer(rand, ".");
			rand = stringTokenizer.nextToken();
			//System.out.println(rand); testing random num generator
			
			String baseURL = "http://bit.ly.com/";
			Statement statement = (Statement)conn.createStatement();
			String shortURL = baseURL + rand;
			statement.execute("INSERT INTO url_shortener_table_1 VALUES ('" + longURL + "', '" + shortURL + "')" ); 
			System.out.println(shortURL);
					
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
	}
}
