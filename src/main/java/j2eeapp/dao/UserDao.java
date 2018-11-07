package j2eeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import j2eeapp.config.JdbcConfig;
import j2eeapp.model.User;

public class UserDao {

	/*save user*/
	public static int save(User e) {
		int status = 0;
		String query = "insert into user(userId,userName,userCity) values(?,?,?)";
		try {
			Connection con = JdbcConfig.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, e.getUserId());
			ps.setString(2, e.getUserName());
			ps.setString(3, e.getUserCity());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(User user){  
        int status=0;  
        try{  
            Connection con=JdbcConfig.getConnection();  
            PreparedStatement ps=con.prepareStatement("update user set userName=?,userCity=?, where userId=?");  
            ps.setInt(1,user.getUserId());
            ps.setString(2,user.getUserName());  
            ps.setString(3,user.getUserCity());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  	
	
	/*delete user*/
	public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=JdbcConfig.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from user where userId=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
	
	 public static User userById(int id){
	        User user= new User();  
	          
	        try{  
	            Connection con=JdbcConfig.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user where userId=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                user.setUserId(rs.getInt(1));  
	                user.setUserName(rs.getString(2));  
	                user.setUserCity(rs.getString(3));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return user;  
	    }  
	
	  public static List<User> allUsers(){  
	        List<User> list=new ArrayList<User>();  
	          
	        try{  
	            Connection con=JdbcConfig.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from user");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	User user=new User();  
	            	user.setUserId(rs.getInt(1));  
	            	user.setUserName(rs.getString(2));  
	            	user.setUserCity(rs.getString(3));
	                list.add(user);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	  }
}
