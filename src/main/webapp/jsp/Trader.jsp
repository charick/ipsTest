<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="TOI.model.SendOrder,java.util.*"%>
<table width="100%" border="0">
  <tr>
    <th>id</th>
    <th>订单号</th>
    <th>订单详细信息</th>
    <th>操作</th>
  </tr>
  <% 
  	List<SendOrder> orders = (List<SendOrder>)request.getAttribute("orders");
	for(int i=0;i<orders.size();i++)
	{
		SendOrder order = orders.get(i);
		if(i%2==0)
		{
			out.println("<tr align='center'>");
		}
		else
		{
			out.println("<tr align='center' bgcolor='#F5F9FE'>");
		}
   %>
   		<td><%= order.getId() %></td>
   		<td><%= order.getTid() %></td>
   		<td><%= order.getSellerMemo() %></td>
   		<td><a href="AdminServlet?action=ordermanage&id=<%= order.getId()%>">发货</a></td>
   	 </tr>
   <% 
   	}
   %>
   <tr>
     <td colspan="5"><hr/></hr></td>
   </tr>
   
</table>