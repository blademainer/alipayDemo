<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>支付宝-消息发送页面</title>
</head>
<body>
   
     <h1>消息发送表单页面</h1>
     
    <c:choose>
      <c:when test="${result}">
      <font color="blue">
         <c:out value="${sucessMsg}"></c:out>
      </font>
      </c:when>
      <c:otherwise>
      <font color="red">
        <c:out value="${errorMsg}"></c:out>
      </font>
      </c:otherwise>
    </c:choose>
     
    <a href="tel:95188">95188</a> 
     <form action="msginput.do" enctype="application/x-www-form-urlencoded" method="post">
 		 <p>消息内容(xml): <textarea cols="100" rows="23"  name="content" ><c:out value="${msgContent}"></c:out></textarea></p><p>  
 		 <input type="submit" value="发送消息" />
 		 <p></p>
 		 消息样例(xml):<textarea cols="100" rows="23" name="example" readonly="readonly">
<XML>
  <ArticleCount><![CDATA[1]]></ArticleCount>
  <Articles>
    <Item>
      <Title><![CDATA[绑定卡001]]></Title>
      <Desc/>
      <ImageUrl/>
      <Url><![CDATA[http:///110.76.38.30:8080/alipayDemoDev/applyAuth.do?tokenId=dd421890-aa35-41a2-bc8e-071a85acb819&userId=2088102135126443]]></Url>
      <ActionName/>
      <AuthType/>
    </Item>
  </Articles>
  <AppId><![CDATA[2013121100055554]]></AppId>
  <ToUserId><![CDATA[2088102135126443]]></ToUserId>
  <AgreementId/>
  <CreateTime><![CDATA[1392859338048]]></CreateTime>
  <MsgType><![CDATA[image-text]]></MsgType>
  <ShowType/>
</XML>
 	  </textarea>
    </form>
</body>
</html>