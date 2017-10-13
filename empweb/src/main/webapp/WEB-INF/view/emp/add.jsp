<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
</head>
<body>
  <form action="/empweb/add.sw" method="post">
       员工姓名<input type="text"  name="ename" ><br>
       员工性别<input type="radio"  name="sex"  value="M">男
       <input type="radio"  name="sex"  value="F">女<br>
       员工薪水<input type="text"  name="sar" ><br>
       入职时间<input type="text"  name="hire" ><br>
       所属部门<select name="did">
       	<c:forEach items="${depts }" var="d">
       		<option value="${d.did }">${d.dname }</option>
       	</c:forEach>
       </select><br>
       分配帐号<br>
       用户名<input type="text" name="user.username"><br>
       密码<input type="password" name="user.pwd"><br>
       <input type="submit" value="保存"> 
  </form>
</body>
</html>