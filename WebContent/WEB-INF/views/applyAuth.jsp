<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, user-scalable=yes" />
<title>֧����-�����ⲿ����ҳ��</title>
</head>
<body>
   
     �ⲿ���󶨱�ҳ��
     
     <h1><c:out value="${errorMsg}"></c:out></h1>
     <form action="commitAuth.do" enctype="application/x-www-form-urlencoded" method="post">
         <p>����: <label><c:out value="${userName}"></c:out></label></p>
 		 <p>֧�����˺�: <label><c:out value="${loginId}"/></label></p>
   		 <p>��Ա��: <input type="text" name="cname" /></p>
 		 <p>��Ա����: <input type="text" name="cno" /></p>
 		 <p><input type="hidden" name="userId"  value="${userId}" /></p>
 		 <input type="submit" value="Submit" />
     </form>

</body>
</html>