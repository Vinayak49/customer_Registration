package com.hotwax.model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
public class UserObjects {
	
	public Connection getDbConnection() throws IOException{
		try {
			Properties properties = new Properties();
			InputStream is = new FileInputStream("dataconfigure.properties");
			properties.load(is);
			String uname = properties.getProperty("name");
			String url = properties.getProperty("url");
			String password = properties.getProperty("password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, uname,password);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
	}	
	public void addUser(User user){
		
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String address = user.getAddress();
		String city = user.getCity();
		int zip = user.getZip();
		String state= user.getState();
		String country= user.getCountry();
		int phone=user.getPhone();
		String userId = user.getUserId();
		String password= user.getPassword();
		
		try{
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root","123456");
			UserObjects userObjects = new UserObjects();
			Connection connection = userObjects.getDbConnection();
			int party = 0;
			PreparedStatement preparedStatement1 = connection.prepareStatement("select max(partyId) from party");
			ResultSet rs = preparedStatement1.executeQuery();
			if (rs.next()){
				party = rs.getInt(1);
				party++;
			PreparedStatement preparedStatement = connection.prepareStatement("insert into party(partyId,firstname,lastname,address,city,zip,state,country,phone,password) values(?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, party);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, city);
			preparedStatement.setInt(6, zip);
			preparedStatement.setString(7, state);
			preparedStatement.setString(8, country);
			preparedStatement.setInt(9, phone);
			preparedStatement.setString(10, password);
			preparedStatement.executeUpdate();
			
			PreparedStatement preparedStatement2 = connection.prepareStatement("insert into userlogin(userLoginId,password,partyId) values(?,?,?)");
			preparedStatement2.setString(1, userId);
			preparedStatement2.setString(2,password);
			preparedStatement2.setInt(3, party);
			preparedStatement2.executeUpdate();
			
			connection.close();
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public User loginUser(String userId, String password) throws SQLException, ClassNotFoundException, IOException{
		UserObjects userObjects = new UserObjects();
		Connection connection = userObjects.getDbConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from userlogin where userLoginId =? and password =?");
		preparedStatement.setString(1, userId);
		preparedStatement.setString(2, password);
		
		ResultSet rs = preparedStatement.executeQuery();
		rs.next();
		int partyId = rs.getInt("partyId");
		rs.close();
		preparedStatement.close();
		
		
		PreparedStatement preparedStatement1 = connection.prepareStatement("select * from party where partyId = ?");
		preparedStatement1.setInt(1, partyId);
		ResultSet rs1 = preparedStatement1.executeQuery();
		rs1.next();
		User user = new User();
		user.setFirstName(rs1.getString("firstName"));
		user.setLastName(rs1.getString("lastName"));
		user.setAddress(rs1.getString("address"));
		user.setCity(rs1.getString("city"));
		user.setZip(rs1.getInt("zip"));
		user.setState(rs1.getString("state"));
		user.setCountry(rs1.getString("country"));
		user.setPhone(rs1.getInt("phone"));
		user.setPassword(rs1.getString("password"));
		
		rs1.close();
		preparedStatement1.close();
		connection.close();
		
		
		return user;
		
	}
	public ResultSet selectAll() throws SQLException, IOException{
		UserObjects userObjects = new UserObjects();
		Connection connection = userObjects.getDbConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select partyId,firstName,lastName,address,city,zip,state,country,phone,password from party");
		ResultSet rs = preparedStatement.executeQuery();
		return rs;
	}
	
	public ResultSet updateRecordRetreive(int partyId) throws SQLException, IOException{
		UserObjects userObjects = new UserObjects();
		Connection connection = userObjects.getDbConnection();
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("Select * from party where partyId ="+partyId);
		return rs;
	}
	
	public void updateRecordPost(User user) throws SQLException, IOException{
		UserObjects userObjects = new UserObjects();
		Connection connection = userObjects.getDbConnection();
		int partyid = user.getPartyid();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String address = user.getAddress();
		String city = user.getCity();
		int zip = user.getZip();
		String state= user.getState();
		String country= user.getCountry();
		int phone=user.getPhone();
		String userId = user.getUserId();
		String password= user.getPassword();
		
		PreparedStatement preparedStatement = connection.prepareStatement("update party set partyId=?,firstName=?,lastName=?,address=?,city=?,zip=?,state=?,country=?,phone=?,password=? where partyId=?");

		preparedStatement.setInt(1,partyid);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, lastName);
		preparedStatement.setString(4, address);
		preparedStatement.setString(5, city);
		preparedStatement.setInt(6, zip);
		preparedStatement.setString(7, state);
		preparedStatement.setString(8, country);
		preparedStatement.setInt(9, phone);
		preparedStatement.setString(10, password);
		preparedStatement.setInt(11, partyid);
		
		preparedStatement.executeUpdate();
	}
	public boolean deleteRecord( int partyId ) throws SQLException, IOException{
		UserObjects userObjects = new UserObjects();
		Connection connection = userObjects.getDbConnection();
		Statement s1 = connection.createStatement();
		int j = s1.executeUpdate("Delete from userlogin where partyId="+partyId);
		Statement s = connection.createStatement();
		int i  = s.executeUpdate("Delete from party where partyId ="+partyId);
		if (i>0){
			return true;
		}
		else{
			return false;
		}		
	}
	
	public ResultSet searchUser(String firstName, String lastName) throws SQLException, IOException{
		UserObjects userObjects = new UserObjects();
		Connection connection = userObjects.getDbConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("select partyId,firstName,lastName,address,city,zip,state,country,phone,password from party where firstName like ? and lastName like ?");
		
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		
		ResultSet rs =  preparedStatement.executeQuery();
		
		return rs;
	}
	

//	public static void sendMail(String r) throws Exception{
//		System.out.println("doing");
//
//		Properties properties = new Properties();
//		
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.port", "587");
//		
//		String myAccGmail= "vinshot75@gmail.com";
//		String pswd= "zvrpsptvhmhurscx";
//		
//		Session session = Session.getInstance(properties, new Authenticator() {
//			
//			protected PasswordAuthentication getPasswordAuthentication(){
//				return new PasswordAuthentication(myAccGmail, pswd);
//			}
//		});
//		
//		Message message = prepareMessage(session,myAccGmail,r);
//		Transport.send(message);
//		System.out.println("done");	
//	}

//	private static Message prepareMessage(Session session, String myAccGmail, String r) throws AddressException, MessagingException {
//		Message message = new MimeMessage(session);
//		message.setFrom(new InternetAddress(myAccGmail));
//		message.setRecipient(Message.RecipientType.TO, new InternetAddress(r));
//		message.setSubject("chala ja bhai");
//		message.setText("helloooooo");
//		return message;
//		
//	}
	
}