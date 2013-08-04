<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*,TOI.model.UserInfo" %>

<html>
  <head>
    <title>趣活宜家代购联盟</title>
  </head>
  <link href="css/generalstyle.css" type="text/css" rel="stylesheet">
  <body>
    <jsp:useBean id="mycart" class="wyf.zrk.CartBean" scope="session"/>
    <center>
      <table border="0" width="100%" height="100%" cellpadding="0" cellspacing="0">
        <tr height="100">
          <td colspan="2" align="center"><%@ include file="top.jsp" %></td>
        </tr>
        <tr height="100">
          <td width="200" height="100" align="center">
          <% 
             if(session.getAttribute("user")==null)
             {
          %>
              		
          <% 
             }
             else
             {
             	out.println("<table border='0' bgcolor='#FFF0E1' width='80%' height='150'>");
             	out.println("<tr align='center' height='80'><td>");
             	out.println(session.getAttribute("userName")+"你好<br/>!!!");
             	out.println("<a href='CartServlet?action=logout'>[注销]</a>");
             	out.println("</td></tr></table>");
             }
            %>
          </td>
        </tr>
      </table>
    </center>
  </body>
</html>