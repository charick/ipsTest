<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="TOI.model.SendOrder,java.util.*"%>
<html>
<head>
    <title>发货清单-趣活宜家代购联盟</title>
    <link href="/css/css.css" rel="stylesheet" type="text/css">
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="top.jsp" %>
<table width="960" height="35" border="0" align="center" cellpadding="0" cellspacing="0" class="allge2" style="margin-top:20px;">
    <tbody><tr>
        <td> &nbsp;&nbsp;<strong>发货清单</strong></td>
    </tr>
    </tbody></table>



<table width="960" border="1" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="allge" style="height: 500px">
    <tbody><tr>
    <th>id</th>
    <th>订单号</th>
    <th></th>
        <th></th>
        <th></th>
        <th>订单详细信息</th>
    <th>操作</th>
  </tr>
  <% 
  	List<SendOrder> orders = (List<SendOrder>)request.getAttribute("orders");
	 if(orders!=null){
      for(int i=0;i<orders.size();i++)
	{
		SendOrder order = orders.get(i);
		if(i%2==0)
		{
			out.println("<tr align='center'>");
		}
		else
		{
			out.println("<tr align='center' bgcolor='#ebf9d0'>");
		}
   %>
   		<td><%= order.getId() %></td>
   		<td><%= order.getTid() %></td>
    <td><%= order.getReceiverName() %></td>
    <td><%= order.getReceiverMobile() %></td>
    <td><%= order.getReceiverAddress() %></td>
    <td><%= order.getSellerMemo() %></td>
   		<td><a href="AdminServlet?action=ordermanage&id=<%= order.getId()%>">发货</a></td>
   	 </tr>
   <% 
   	}
       }
   %>
   </tbody>
</table>
</body>
</html