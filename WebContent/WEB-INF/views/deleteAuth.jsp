<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, user-scalable=yes" />
<title>支付宝-外部户删除绑定页面</title>
</head>
<body>
   
     外部户删除绑定表单页面
     
     <h1><font color="red"><c:out value="${errorMsg}"></c:out></font></h1>
     <c:choose>
     	<c:when test="${result}">
     	   <font color="blue">
     		<c:out value="${resultMsg}"></c:out><br>
     		
     		</font>
     	</c:when>
     	<c:otherwise>
     	   <font color="red">
     	   <c:out value="${resultMsg}"></c:out>
     	   </font>
     	</c:otherwise>
     
     </c:choose>
     
     
     <form action="deleteAuth.do" enctype="application/x-www-form-urlencoded" method="post">
     
       <table align="center" border="1" width="600px" cellpadding="0" cellspacing="0">
          <tr>
          	<td>外部户号:</td>
          	<td><input type="text" name="cthirdid" value="${cthirdid}"/></td>
          </tr>
          
          <tr>
          	<td>外部户协议号:</td>
          	<td><input type="text" name="agrId" value="${agrId}" /></td>
          </tr>
            <tr>
          	<td>支付宝userId:</td>
          	<td><input type="text" name="cuserid" value="${cuserid}" /></td>
          </tr>
          <tr>
          	<td><input type="submit" value="删除" /></td>
 		 </tr>
 	  </table>
     </form>

</body>
</html>