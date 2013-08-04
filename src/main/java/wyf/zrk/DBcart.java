package wyf.zrk;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

public class DBcart
{
	private static int span=2;
	
	public static int getSpan()
	{
		return span;
	}
	
	public static void setSpan(int i)
	{
		span = i;
	}
	
	public static Vector<String> getInfo(String sql)
	{
		Vector<String> vclass = new Vector<String>();
		try
		{
            Connection con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
            	String str = rs.getString(1);
            	str = new String(str.getBytes("ISO-8859-1"),"gb2312");
            	vclass.add(str);
            }
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vclass;
	}
	
	public static boolean isLegal(String sql)
	{
		boolean flag = false;
		try
		{
            Connection con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
            	flag = true;
            }			
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int getID(String tname,String colname)
	{
		int id = 0;
		try
		{
            Connection con=getConnection();
            Statement st = con.createStatement();
            String sql = "select Max("+colname+") from "+tname;
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
            	id = rs.getInt(1);
            }
            id++;
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public static int updateTable(String sql)
	{
		int i = 0;
		try
		{
			
            Connection con=getConnection();
            Statement st = con.createStatement();
            i = st.executeUpdate(sql);
            st.close();
            con.close();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	
	public static Vector<String[]> getInfoArr(String sql)
	{
		Vector<String[]> vtemp = new Vector<String[]>();
		try
		{
			
            Connection con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmt = rs.getMetaData();
            int count = rsmt.getColumnCount();
            while(rs.next())
            {
            	String[] str = new String[count];
            	for(int i=0;i<count;i++)
            	{
            		str[i] = rs.getString(i+1);
            		str[i] = new String(str[i].getBytes("ISO-8859-1"),"gb2312");
            	}
            	vtemp.add(str);
            }
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vtemp;
	}

	public static int getTotalPage(String sql)
	{
		int totalpage = 1;
		try
		{
			
            Connection con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int rows = rs.getInt(1);
            totalpage = rows/span;
            if(rows%span!=0)
            {
            	totalpage++;
            }
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return totalpage;
	}
	
	public static Vector<String[]> getPageContent(int page,String sql)
	{
		Vector<String[]> vcon = new Vector<String[]>();
		try
		{
            Connection con=getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmt = rs.getMetaData();
            int count = rsmt.getColumnCount();
            int start = (page-1)*span;
            if(start!=0)
            {
            	rs.absolute(start);
            }
			int temp=0;
            while(rs.next()&&temp<span)
            {
            	temp++;
            	String[] str = new String[count];
            	for(int i=0;i<str.length;i++)
            	{
            		str[i] = rs.getString(i+1);
            		str[i] = new String(str[i].getBytes("ISO-8859-1"),"gb2312");
            	}
            	vcon.add(str);
            }
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vcon;
	}
	
	public static int getSelectId(String sql)
	{
		int id = 0;
		try
		{
            Connection con=getConnection();
            Statement st = con.createStatement();
			sql = new String(sql.getBytes(),"ISO-8859-1");
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
            rs.close();
            st.close();
            con.close();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public static boolean batchSql(String[] sql)
	{
		boolean flag = true;
		Connection con = null;
		try
		{
            con=getConnection();
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            for(String str:sql)
            {
            	str = new String(str.getBytes(),"ISO-8859-1");
            	st.addBatch(str);
            }
            st.executeBatch();
            con.commit();
            con.setAutoCommit(true);
            st.close();
		}
		catch(Exception e)
		{
			flag = false;
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
		}
		finally
		{
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8";
        Class.forName("com.mysql.jdbc.Driver");
        String userName = "root";
        String password = "491272";
        Connection con = DriverManager.getConnection(url, userName, password);
        return con;
    }
}