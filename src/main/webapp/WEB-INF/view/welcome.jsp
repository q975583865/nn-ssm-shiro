<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglibprefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<shiro:hasPermission name="caidan">
菜单
</shiro:hasPermission>
<shiro:hasPermission name="caidan:add">
新增菜单
</shiro:hasPermission>
<shiro:hasPermission name="caidan:del">
删除菜单
</shiro:hasPermission>
<shiro:hasPermission name="caidan:add:three">
3级菜单
</shiro:hasPermission>
<shiro:hasPermission name="caidan:del:asdasdasd">
乱写的：
</shiro:hasPermission>
<shiro:hasPermission name="caidan_del_asdasdasd">
乱写的_
</shiro:hasPermission>
<shiro:hasPermission name="quanxian">
权限
</shiro:hasPermission>



<a href="<%=request.getContextPath()%>/logout">退出</a>


</body>
</html>