<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, user-scalable=yes" />
<title>֧����-�����Զ����ά��ͼƬ</title>
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
		
       <form action="genQrcode.do" method="post" id="genqrcode" name="genqrcode">
	   <table align="center" border="0" width="600px" cellpadding="0" cellspacing="0">
			<tr>
				<td >�Զ��������</td>
				<td>
					<input type="text" name="scenId" size="60" value="${scenId}"  /><font color="red">*</font>
				</td>
			</tr>		
			<tr>
				<td >
				</td>
				<td>
				<button style="color:#000000; width:20; margin: 0px 20px 0px 20px;"  class="left" onclick="query()">���ɶ�ά��</button>
				</td>
			</tr>
		</table>
	</form>
	
	<center>
	
	 <c:choose >
	    <c:when test="${result}">
	  ��ά���ַ��<c:out value="${imageUrl}"></c:out><br>
	  ��Ч�ڣ�<c:out value="${expiredTime}"></c:out><br>
	  </c:when>
	  </c:choose>
	
	</center>


<script type="text/javascript">
	function query(){
		var form = document.getElementById("genqrcode");
		form.action = "genQrcode.do";
		form.method = "post";
		form.submit();
	}
	
	
</script>

      
   
  
</body>
</html>