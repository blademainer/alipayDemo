<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, user-scalable=yes" />
<title>֧����-�ⲿ�����ð�ҳ��</title>
</head>
<body>
   
     �ⲿ�����ð󶨱�ҳ��
     
     <h1><font color="red"><c:out value="${errorMsg}"></c:out></font></h1>
     <c:choose>
     	<c:when test="${result}">
     	   <font color="blue">
     		<c:out value="${resultMsg}"></c:out><br>
     		Э��ţ�<c:out value="${agreementId}"></c:out>
     		</font>
     	</c:when>
     	<c:otherwise>
     	   <font color="red">
     	   <c:out value="${resultMsg}"></c:out>
     	   </font>
     	</c:otherwise>
     
     </c:choose>
     
     
     <form action="updateAuth.do" enctype="application/x-www-form-urlencoded" method="post">
     
       <table align="center" border="1" width="600px" cellpadding="0" cellspacing="0">
          <tr>
            <td>��Ա��: </td>
            <td><input type="text" name="cname"  value="${cname}"/><font color="red">*</font></td>
          </tr>
          <tr>
           <td>��Ա����:</td>
           <td><input type="text" name="cno" value="${cno}" /><font color="red">*</font></td>
          </tr>
          <tr>
          	<td>�ⲿ����:</td>
          	<td><input type="text" name="cthirdid" value="${cthirdid}"/><font color="red">*</font></td>
          </tr>
          <tr>
          	<td>֧����userId:</td>
          	<td><input type="text" name="cuserid" value="${cuserid}" /><font color="red">*</font></td>
          </tr>
          <tr>
          	<td><input type="submit" value="����" /></td>
 		 </tr>
 	  </table>
     </form>

</body>
</html>