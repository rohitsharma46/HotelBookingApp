package JspJdbcServlet;

import java.sql.*;

public class DBClass {
	
	Connection conn = null;

// 1	
	public boolean dbConnect() throws Exception {
		String dbURL="jdbc:mysql://localhost:3306/userData";
		String dbUser="test";
		String dbPwd="Test1234";
		Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(dbURL,dbUser,dbPwd);
			} catch (Exception e) {
				System.out.println("Connection Failed");
				e.printStackTrace();
			}
		System.out.println("Connected to Database");
		return true;	
	}
	

/*	



// 2	
						// To get All users Data from Database
	public boolean getAllUsers() throws Exception {
		String query1 = "select * from users";
		boolean result = false;
		dbConnect();
		Statement st=null;
		ResultSet rs= null;
		
		st= conn.createStatement();
		rs =st.executeQuery(query1);
		
		
		
		System.out.println("First Name : "+"   Last Name : "+ "      Password");
		while(rs.next()) {
			
			String first_Name = rs.getString(1);
			String last_Name = rs.getString(2);
			String password =rs.getString(3);
			System.out.println(first_Name+"           "+last_Name+"            "+password);
			result=true;
		}
	return result;
	}
*/	
	
	
// 3	
								// To verify the user Login Credentials
	
	public boolean userAuth(String name,String pwd){
		PreparedStatement st=null;
		ResultSet rs= null;
		
		String query2 = "select * from users where fname =? and pwd=?";
		boolean result = false;
		
		try {
			dbConnect();
			st= conn.prepareStatement(query2);
			st.setString(1, name);
			st.setString(2, pwd);
			rs = st.executeQuery();
			
			if(rs.next()) {
				result=true;
				System.out.println("user authentication successful");
				System.out.println("request received from "+name);
				System.out.println("User Name: "+rs.getString(2)+" "+rs.getString(3)+"\nUser Password is : "+rs.getString(4));
			}
			else {
				System.out.println("user auth failed");
				result=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return result;
	}

						
											// To create the User

	public boolean CreateUser(String nUser, String nPwd,String age,String lUser) {
		
		PreparedStatement st=null;
		boolean result = false;
		
		try {
			dbConnect();
			boolean greenFlag = checkExisting(nUser);
			
			if(greenFlag) {
				String create = "INSERT INTO users (fname,pwd) VALUES ('" +nUser+ "','" +nPwd+ "')";
				st= conn.prepareStatement(create);
				int i = st.executeUpdate();
					if(lUser!=null ) {
						String lQuery = "update users set lname = '" +lUser+ "', Age ='" +age+ "' where fname ='"+nUser+"'";
						st= conn.prepareStatement(lQuery);
						st.executeUpdate();
						}
				if(i>0) {
					result=true;
					System.out.println("user created successfully");
				}
				else {
					System.out.println("user not Created");
				}		
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return result;
		
	}


	
	
												// To Make UserID unique
	public boolean checkExisting(String nUser) {
		String confirmUser = "select * from users where fname=?";
		boolean result = false;
		
		try {
			dbConnect();
			PreparedStatement st=null;
			ResultSet rs= null;
			
			st = conn.prepareStatement(confirmUser);
			st.setString(1, nUser);
			rs =st.executeQuery();	
			
					if(rs.next()) {
						System.out.println("UserName Not Available");
						result=false;
					}
					else {
						System.out.println("UserName Available");
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	return result;
		
}


	public boolean updatePwd(String user,String pwd) {
		PreparedStatement st=null;
		boolean result = false;
		
		try {
			dbConnect();

			String lQuery = "update users set pwd =? where fname =?";
			st= conn.prepareStatement(lQuery);
			st.setString(1,pwd);
			st.setString(2, user);
			st.executeUpdate();
			System.out.println(user+"'s Password updated to "+pwd);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return result;
		
	}
	

}
