<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>֧����-������Ϣ����ҳ��</title>
</head>
<body>
   
     ��Ϣ���ͱ�ҳ��
     
     <form action="push.do" enctype="application/x-www-form-urlencoded" method="post">
 		 <p>��Ϣ����: <textarea cols="100" rows="15"  name="content"></textarea></p><p>  ��ʽ����:<textarea cols="100" rows="15" name="example" readonly="readonly"><?xml version="1.0" encoding="utf-8"?>

<Xml>
  <MsgType><![CDATA[image-text]]></MsgType>
  <ShowType><![CDATA[show_icon_left]]></ShowType>
  <AppId><![CDATA[2013111400037744]]></AppId>
  <ToUserId><![CDATA[2088102122560081]]></ToUserId>
  <AgreementId><![CDATA[]]></AgreementId>
  <Push><![CDATA[false]]></Push>
  <CreateTime><![CDATA[1384272441626]]></CreateTime>
  <ArticleCount>1</ArticleCount>
  <Articles>
    <Item>
      <Title><![CDATA[��л��ע�й��ƶ���]]></Title>
      <Desc><![CDATA[]]></Desc>
      <ImageUrl><![CDATA[]]></ImageUrl>
      <ActionParam><![CDATA[]]></ActionParam>
      <ActionType><![CDATA[]]></ActionType>
      <AuthType><![CDATA[]]></AuthType>
      <ActionName><![CDATA[]]></ActionName>
    </Item>
  </Articles>
</Xml>
 		 </textarea></p>
 		 <p>userId:<input type="text" name="userId"></input></p>
 		 <input type="submit" value="Submit" />
     </form>

</body>
</html>