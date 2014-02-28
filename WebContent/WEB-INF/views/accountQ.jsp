<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, user-scalable=yes" />
<title>支付宝-菜单查询页面</title>
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
				<td >支付宝userId：</td>
				<td>
					<input type="text" name="userId" size="60" value="${userId}"  /><font color="red">*</font>
				</td>
			</tr>		
			<tr>
				<td >
				</td>
				<td>
				<button style="color:#000000; width:20; margin: 0px 20px 0px 20px;"  class="left" onclick="query()">查询</button>
				
				</td>
			</tr>
		</table>
	</form>
	
	<center>
	
	<c:choose>
	  <c:when test="${hasNotBinds}">
	   <font color="red">
	    用户id:<c:out value="${userId}"></c:out>在公众号:<c:out value="${publicId}"></c:out>下没有任何外部户绑定信息!
	   </font>
	  </c:when>
	  <c:when test="${result}">
	  <font color="blue">
	   用户id:<c:out value="${userId}"></c:out>在公众号:<c:out value="${publicId}"></c:out>下的外部户列表如下:
	  </font>
	  </c:when>
	 
	</c:choose>
	
	<table align="center" border="1" width="600px" cellpadding="0" cellspacing="0">
	   <c:forEach items="${bindAccountList}" var="item" varStatus="status">
	     <tr>
	       <td rowspan="6"><c:out value="${status.count}"></c:out></td>
	       <td>appId:</td><td><c:out value="${item.appId}"></c:out></td>
	      
	     </tr>
	     <tr>
	       <td>bindAccountNo:</td><td><c:out value="${item.bindAccountNo}"></c:out></td>
	     </tr>
	     <tr>
	       <td>displayName:</td><td><c:out value="${item.displayName}"></c:out></td>
	     </tr>
	     <tr>
	       <td>fromUserId:</td><td><c:out value="${item.fromUserId}"></c:out></td>
	     </tr>
	     <tr>
	       <td>realName:</td><td><c:out value="${item.realName}"></c:out></td>
	     </tr>
	     <tr>
	       <td>agreementId:</td><td><c:out value="${item.agreementId}"></c:out></td>
	     </tr>
	   
	   </c:forEach>
	</table>
	</center>


<script type="text/javascript">
	function query(){
		var form = document.getElementById("accountquery");
		form.action = "accountQuery.do?action=query";
		form.method = "post";
		form.submit();
	}
	
	
	
</script>

      
   
  
</body>
</html>