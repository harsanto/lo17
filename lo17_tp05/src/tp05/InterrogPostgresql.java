package tp05;

/* UV : LO17 - TP05
 * Interrogation base de données SQL
 * Auteurs : Dany Ferreira - Antoine Hars
 * Fichier : InterrogPostgresql.java
 */

import java.sql.*;
import java.util.StringTokenizer;

public class InterrogPostgresql {
	
	private String username;
	private String password;
	private String url;
	private String requete;
	
	public InterrogPostgresql() {
	
		// ---- configure START
		username = "lo17xxx";
		password = "dblo17";
	
		// The URL that will connect to TECFA's MySQL server
		// Syntax: jdbc:TYPE:machine:port/DB_NAME
		url = "jdbc:postgresql://tuxa.sme.utc/dblo17";
	}
	
	public void exec_sql() {
		// INSTALL/load the Driver (Vendor specific Code)
		try {
			Class.forName("org.postgresql.Driver");
		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			Connection con;
			Statement stmt;
	    
			// Establish Connection to the database at URL with usename and password
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			// Send the query and bind to the result set
			ResultSet rs = stmt.executeQuery(requete);
			
			String s, str;
			StringTokenizer st;
			
			while (rs.next()) {
				
				st = affich(requete);
				while (st.hasMoreTokens()) {
					
					str = st.nextToken();
					s = rs.getString(str);
					System.out.print(s + "\t");
				}
				System.out.println();
			}
			// Close resources
			stmt.close();
			con.close();
		}
		// print out decent erreur messages
		catch(SQLException ex) {

			System.err.println("==> SQLException: ");
			while (ex != null) {
				System.out.println("Message:   " + ex.getMessage());
				System.out.println("SQLState:  " + ex.getSQLState());
				System.out.println("ErrorCode: " + ex.getErrorCode());
				ex = ex.getNextException();
				System.out.println("");
			}
		}
	}
	
	public void setRequete(String re) {
		requete = re;
	}
	
	public String getRequete() {
		return requete;
	}
	
	public StringTokenizer affich(String req) {
		
		String tr, tmp = "";
		StringTokenizer st = new StringTokenizer(req);
		int i = 0;
		
		while (st.hasMoreTokens()) {

			tr = st.nextToken();
			tr = tr.replace(",", "");
			
			if (tr.compareTo("from") == 0) {
				i = 0;
			}
			
			if (i == 1) {
				if (tr.contains("count(") == true) {
					tmp = tmp.concat("count ");
				} else {
					tmp = tmp.concat(tr + " ");
				}
			}
			
			if (tr.compareTo("select") == 0) {
				i = 1;
			}
		}
		st = new StringTokenizer(tmp);
		
		return st;
	}
}