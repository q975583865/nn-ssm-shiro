<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function refreshCaptcha() {
	var _captcha_id = document.getElementById("img_captcha");
    _captcha_id.src="servlet/captchaCode?t=" + Math.random();
}
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">  
<pre>
<input type="text" name="username" >

<input type="password" name="password">

<td valign="middle">
<img title="点击更换"   id="img_captcha" onclick="javascript:refreshCaptcha();"  src="servlet/captchaCode"><input type="text" id="captcha"  name="captcha" size="4" maxlength="4" class="required" />
</td>  

<td valign="middle" align="right">
</td>  
<input type="submit">
</pre>

</body>
</html>