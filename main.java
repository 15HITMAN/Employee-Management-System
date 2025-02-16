package EmployeeMangementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	
	static Connection con=null;
	static Employee e =null;
	 static {
		String url="jdbc:mysql://localhost:3306/emp";
		String user="root";
		String pass="548845";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url,user,pass);
			 System.out.println(con);
		   e=new Employee();
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
	public void login(String uname,String pass) throws SQLException {
		Statement stmt = con.createStatement();
		String query="select * from signup";
		ResultSet rs = stmt.executeQuery(query);
	
		
		while(rs.next()) {
			String username=rs.getString(3);
			String password=rs.getString(4);
			if(username.equals(uname) && password.equals(pass)) {
			   System.out.println("SUCCESFULLY LOGIN");
			   display();
			   
			}
			else {
				System.out.println("USER DOES NOT EXIST PLS SIGN UP");
                 
				choice();
			}
		}
		
	}
	public void signup(String fname,String lname,String user,String pass) throws SQLException {
		String query="insert into signup values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, fname);
		ps.setString(2, lname);
		ps.setString(3, user);
		ps.setString(4, pass);
		int row=ps.executeUpdate();
		if(row>0) {
			System.out.println("SIGN IN SUCCESFULLY");
			choice();
		}
		else {
			System.out.println("PLS ENTER VALID DEATAILS");
		}	
		
	}
	public void viewAllEmployee() throws SQLException {
		Statement stmt = con.createStatement();
	      String query="select * from employee";
	      ResultSet rs = stmt.executeQuery(query);
	      while(rs.next()) {
	   System.out.println("Employee id :"+rs.getInt(1)+" Employee name :"+rs.getString(2)+"Employee salary:"+rs.getInt(3)+"Employee Address:"+rs.getString(4)+"Employee Emailid :"+rs.getString(5));
	      }
	}
	public void viewEmployee(int id) throws SQLException {
		Statement stmt=con.createStatement();
		String query="select * from employee where eid='"+id+"'";
		  ResultSet rs = stmt.executeQuery(query);
		  while(rs.next()) {
	     System.out.println("Employee id :"+rs.getInt(1)+" Employee name :"+rs.getString(2)+"Employee salary:"+rs.getInt(3)+"Employee Address:"+rs.getString(4)+"Employee Emailid :"+rs.getString(5));
	   }
	}
	public void createEmployee( int id,String name,int salary,String address,String email) throws SQLException {
		
		String insert_query="insert into employee values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(insert_query);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, salary);
		ps.setString(4, address);
		ps.setString(5, email);
		int row = ps.executeUpdate();
		if(row>1) {
			System.out.println("Employee is created");
		}
		else {
			System.out.println("Employee is not created");
		}
	
	}
	public void updateEmployee(int salary,String address,int id) throws SQLException {
		Statement stmt = con.createStatement();
		String update_query="update employee set employee_salary='"+salary+"',employee_address='"+address+"' where eid='"+id+"'";
		int row= stmt.executeUpdate(update_query);
		if(row>0) {
			System.out.println("Emplouee is updated");
		}
		else {
			
			System.out.println("Employee is not updated");
		}
	}
	public void deleteEmployee(int id) throws SQLException {
		Statement stmt = con.createStatement();
		String query="delete from employee where eid='"+id+"'";
		int row = stmt.executeUpdate(query);
		if(row>0) {
			System.out.println("Employee is deleted successFully");
		}
		else {
			System.out.println("Employee dose not exist");
		}
		
		
	}
	public void display() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO EMS");
		System.out.println("1:CREATE EMPLOYEE");
		System.out.println("2:VIEW EMPLOYEE");
		System.out.println("3:VIEW ALL EMPLOYEE");
		System.out.println("4:UPDATE EMPLOYEE");
		System.out.println("5:DELETE EMPLOYEE");
		int choice=sc.nextInt();
		if(choice==1) {
			System.out.println("Enter a employee id");
			int eid=sc.nextInt();
			System.out.println("Enter a Employee name");
			String name = sc.next();
			System.out.println("Enter a Employee salary ");
			int sal=sc.nextInt();
			System.out.println("Enter a employee address");
			String address=sc.next();
			System.out.println("Enter a employee email");
			String email=sc.next();
			e.createEmployee(eid,name, sal, address, email);
			System.out.println("employee created succesfully");
		}
		else if(choice==2) {
			System.out.println("Enter a employee ID");
			int eid=sc.nextInt();
			e.viewEmployee(eid);
		}
		else if(choice==3) {
			e.viewAllEmployee();
		}
		else if(choice==4) {
		    System.out.println("Enter a salary:");
		   int salary= sc.nextInt();
		   System.out.println("Enter a address:");
		  String add= sc.next();
		  System.out.println("Enter employee id:");
		  int eid=sc.nextInt();
		  e.updateEmployee(salary, add, eid);
		  System.out.println("employee updated succesfully");
		}
		else if(choice==5) {
			System.out.println("Enter employee id");
			int id=sc.nextInt();
			e.deleteEmployee(id);
			System.out.println("Employee deleted succesfully");
		}
         
	}
	public static void choice() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Employee e=new Employee();
		System.out.println("WELCOME TO EMPLOYEE MANAGEMT SYSTEM");
		System.out.println("1:LOGIN");
		System.out.println("2:SIGNUP");
		
		
		int choice=sc.nextInt();
		if(choice==1) {
			System.out.println("ENTER A USERNAME :");
	      String uname=	sc.next();
	      System.out.println("ENTER A PASSWORD");
	      String pass=sc.next();
	      e.login(uname, pass);  
		}
		else if(choice==2) {
			System.out.println("PLS ENTER SIGNUP DETAILS");
			System.out.println("ENTER YOUR FIRSTNAME");
			String first=sc.next();
			System.out.println("ENTER YOUR LASTNAME");
			String last=sc.next();
			System.out.println("ENTER A USERNAME");
			String user_name=sc.next();
			System.out.println("ENTER A PASSWORD");
			 String pass_word=sc.next();
			 e.signup(first,last,user_name,pass_word);
		}
		else {
			System.out.println("ENTER A VALID CHOICE");
			choice();
		}
		e.closeConnection();
	}


	public static void main(String[] args) throws SQLException {
	       choice();
	}
	public void closeConnection() throws SQLException {
		con.close();
	}

}
