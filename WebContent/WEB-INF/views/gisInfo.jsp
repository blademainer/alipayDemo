<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, user-scalable=yes" />
<title>֧����-����λ�ò�ѯҳ��</title>
</head>
<body>
     <center>
	  <c:choose >
	    <c:when test="${result}">
	       <font color="blue"><c:out value="${resultMsg}"></c:out></font>
	    </c:when>
	    <c:otherwise>
	       <font color="red"><c:out value="${resultMsg}"></c:out></font>
	    </c:otherwise>
	  </c:choose>
	  </center>
		
       <form action="accountQuery.do" method="post" id="accountquery" name="accountquery">
	   <table align="center" border="1" width="600px" cellpadding="0" cellspacing="0">
			<tr>
				<td >֧����userId��</td>
				<td>
					<input type="text" name="userId" size="60" value="${userId}"  /><font color="red">*</font>
				</td>
			</tr>		
			<tr>
				<td >
				</td>
				<td>
				<button style="color:#000000; width:20; margin: 0px 20px 0px 20px;"  class="left" onclick="query()">��ѯ</button>
				
				</td>
			</tr>
		</table>
	</form>
	
<center>
	<c:choose>
	  <c:when test="${gisExist}">
	   <font color="red">
	    �û�id:<c:out value="${userId}"></c:out>�ڹ��ں�:<c:out value="${publicId}"></c:out>��û�е�ַλ����Ϣ!
	   </font>
	  </c:when>
	  <c:when test="${result}">
	  <font color="blue">

	   �û�id:<c:out value="${userId}"></c:out>�ڹ��ں�:<c:out value="${publicId}"></c:out>�µ���Ϣ���£�<br>



	  </font>
	  </c:when>
	</c:choose>
	
	γ�ȣ�<c:out value="${gisInfo.latitude}"></c:out><br>
	���ȣ�<c:out value="${gisInfo.longitude}"></c:out><br>
	��<c:out value="${gisInfo.accuracy}"></c:out><br>
	
	
</center>


<script type="text/javascript">
	function query(){
		var form = document.getElementById("accountquery");
		form.action = "gisInfo.do?action=query";
		form.method = "post";
		form.submit();
	}
	
	
	
</script>

      
   
  
</body>
</html>