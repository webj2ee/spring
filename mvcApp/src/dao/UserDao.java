package dao;

import java.sql.*;

import javax.sql.DataSource;

import entity.User;

public class UserDao {

	//dependency of the Dao
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//Method to save a user in the DB
	public void save(User user) throws Exception
	{
		Connection con=dataSource.getConnection();
		PreparedStatement stmt=con.prepareStatement(
		"insert into UserMaster (name,mailId,password) values(?,?,?)");
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getMailId());
		stmt.setString(3, user.getPassword());
		stmt.executeUpdate();
		con.close();
	}
	//Method to search a mailId in the DB
		public boolean exists(String mailId) throws Exception
		{
			boolean flag=false;
			Connection con=dataSource.getConnection();
			PreparedStatement stmt=con.prepareStatement(
			"select * from UserMaster where mailId=?");
			stmt.setString(1, mailId);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
				flag=true;
			
			con.close();
			return flag;
		}
		
		//Method to search a user using mailId and password
				public boolean find(User user) throws Exception
				{
					boolean flag=false;
					Connection con=dataSource.getConnection();
					PreparedStatement stmt=con.prepareStatement(
					"select * from UserMaster where mailId=? and password=?");
					stmt.setString(1, user.getMailId());
					stmt.setString(2, user.getPassword());
					ResultSet rset=stmt.executeQuery();
					if(rset.next())
					{
						flag=true;
						//Id & name are stored in the user
						user.setId(rset.getInt(1));
						user.setName(rset.getString(2));
					}
					con.close();
					return flag;
				}
}










