<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<meta name="viewport" content="width=device-width, user-scalable=yes" />
<title>支付宝-会员授权登录页面</title>
</head>
<body>
   
      <h1>会员授权信息:</h1>
       
       <table style="width:60px"  border="1">
         <tr>
          <td>ALIPAY_AUTH:</td>
          <td><c:out value="${alipayInAuthInfo.alipayAuth}"></c:out></td>
         </tr>
         <tr>
          <td>PUBLIC_ID:</td>
          <td><c:out value="${alipayInAuthInfo.publicId}"></c:out></td>
         </tr>
         <tr>
          <td>APP_ID:</td>
          <td><c:out value="${alipayInAuthInfo.appId}"></c:out></td>
         </tr>
         <tr>
          <td>AUTH_CODE:</td>
          <td><c:out value="${alipayInAuthInfo.authCode}"></c:out></td>
         </tr>
         <tr>
          <td>ALIPAY_USER_ID:</td>
          <td><c:out value="${alipayInAuthInfo.alipayUserId}"></c:out></td>
         </tr>
         <tr>
          <td>SOURCE_ID:</td>
          <td><c:out value="${alipayInAuthInfo.sourceId}"></c:out></td>
         </tr>
       </table>
       
       <h1>授权码获取信息:</h1>
       <c:choose>
         <c:when test="${toAlipayTokenModelResp.success}">
         
         
        <table style="width:60px"  border="1">
         <tr>
          <td>ALIPAY_USER_ID:</td>
          <td><c:out value="${tokenInfo.alipayUserId}"></c:out></td>
         </tr>
         <tr>
          <td>ACCESS_TOKEN:</td>
          <td><c:out value="${tokenInfo.accessToken}"></c:out></td>
         </tr>
         <tr>
          <td>EXPIRE_IN:</td>
          <td><c:out value="${tokenInfo.expireIn}"></c:out></td>
         </tr>
         <tr>
          <td>REFRESH_TOKEN:</td>
          <td><c:out value="${tokenInfo.refreshToken}"></c:out></td>
         </tr>
         <tr>
          <td>REEXPIRE_IN:</td>
          <td><c:out value="${tokenInfo.reExpireIn}"></c:out></td>
         </tr>
       </table>
            
         </c:when>
         <c:otherwise>
            <font color="red" size="14px">换取accessCode失败</font>
         </c:otherwise>
       
       </c:choose>
       
       
</body>
</html>