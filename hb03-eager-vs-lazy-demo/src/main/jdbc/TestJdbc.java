package main.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.sun.xml.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("connecting... to database: "+jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successfull!!!");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
