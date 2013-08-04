<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="wyf.zrk.AdminBean,wyf.zrk.DBcart,java.util.*"%>
<% 
	if(session.getAttribute("admin")==null)
	{
		response.sendRedirect("adlogin.jsp");
	}
	else
	{
 %>
 <html>
   <head>
     <title>-------------------====</title>
     <script language="javascript" src="script/trim.js"></script>
     <script language="javascript">
       function addCheck()
       {
         if(document.addform.gname.value.trim()=="")
         {
         	alert("��Ʒ��Ʋ���Ϊ��!!!");
         	return;
         }
         if(document.addform.gprice.value.trim()=="")
         {
         	alert("��Ʒ�۸���Ϊ��!!!");
         	return;
         }
         if(isNaN(document.addform.gprice.value*1))
         {
         	alert("��Ʒ�۸�ֻ��������!!!");
         	return;
         }
         if(document.addform.gamount.value.trim()=="")
         {
         	alert("��Ʒ��������Ϊ��!!!");
         	return;
         }
         if(isNaN(document.addform.gamount.value*1))
         {
         	alert("��Ʒ����ֻ��������!!!");
         	return;
         }
         if(document.addform.gintro.value.trim()=="")
         {
         	alert("��Ʒ˵������Ϊ��!!!");
         	return;
         }
         if(document.addform.gbrief.value.trim()=="")
         {
         	alert("��Ʒ��鲻��Ϊ��!!!");
         	return;
         }
         document.addform.submit();         
       }
     </script>
   </head>
   <body>
     <table width="100%">
       <tr>
         <td><%@ include file="admintop.jsp" %></td>
       </tr>
       <tr>
         <td align="center">
           <form action="AdminServlet" method="post" name="addform">
             <table>
               <tr bgcolor="#E4EDFA">
                 <td>��Ʒ���:</td>
                 <td><input name="gname"/></td>
               </tr>
               <tr>
                 <td>��Ʒ�۸�:</td>
                 <td><input name="gprice" /></td>
               </tr>
               <tr bgcolor="#E4EDFA">
                 <td>��Ʒ����:</td>
                 <td><input name="gamount" /></td>
               </tr>
               <tr>
                 <td>��Ʒ���:</td>
                 <td><input name="gclass" /></td>
               </tr>
               <tr bgcolor="#E4EDFA">
                 <td>ͼƬURL:</td>
                 <td><input name="gurl" /></td>
               </tr>
               <tr>
                 <td>��Ʒ˵��:</td>
               </tr>
               <tr>
                 <td colspan="2"><textarea cols="60" rows="6" name="gintro"></textarea></td>
               </tr>
               <tr>
                 <td>��Ʒ���:</td>
               </tr>
               <tr>
                 <td colspan="2"><textarea cols="60" rows="6" name="gbrief"></textarea></td>
               </tr>
               <tr>
                 <td align="center" colspan="2">
                   <input type="button" value="��Ʒ���" onclick="addCheck()"/>
                   <input type="hidden" name="action" value="addgoods"/>
                   <input type="reset" value="����"/>
                   <input type="button" value="����" onClick="history.back()">
                 </td>
               </tr>
             </table>
           </form>
         </td>
       </tr>
     </table>
   </body>
 </html>
 <% 
 	}
  %>