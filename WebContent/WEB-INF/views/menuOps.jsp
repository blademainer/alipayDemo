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
		
       <form action="menuInfo.do" method="post" id="menuform" name="menuform">
	   <table align="center" border="0" width="600px" cellpadding="0" cellspacing="0">
			<tr>
				<td >公众号ID：</td>
				<td>
					<input type="text" name="appId" size="60" value="${publicId}"  readonly="readonly"/><font color="red">*</font>
				</td>
			</tr>		
			<tr>
				<td>自定义菜单：</td>
				<td>
					<textarea name="menuContent" rows="10" cols="60"    ><c:out value="${menuContent}"></c:out></textarea>
				</td>
			</tr>
			
			<tr>
				<td >
				</td>
				<td>
				<button style="color:#000000; width:20; margin: 0px 20px 0px 20px;"  class="left" onclick="query()">查询</button>
				<button  style="color:#000000; width:20; margin: 0px 0px 0px 20px;"  onclick="create()" class="left">创建</button>
				<button  style="color:#000000; width:20; margin: 0px 0px 0px 20px;"  onclick="save()" class="left">更新</button>
				</td>
			</tr>
		</table>
	</form>


<script type="text/javascript">
	function query(){
		var form = document.getElementById("menuform");
		form.action = "menuInfo.do?action=query";
		form.method = "post";
		form.submit();
	}
	
	function save(){
		var form = document.getElementById("menuform");
		form.action = "menuInfo.do?action=save";
		form.method = "post";
		form.submit();
	}
	
	function create(){
		var form = document.getElementById("menuform");
		form.action = "menuInfo.do?action=create";
		form.method = "post";
		form.submit();
	}
	
</script>

      
   
  
</body>
</html>