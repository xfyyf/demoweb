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
  <form action="/empweb/update.sw" method="post">
       <input type="hidden" name="eid" value="${emp.eid }" >
       员工姓名<input type="text"  name="ename"  value="${emp.ename }"><br>
       员工性别<input type="radio"  name="sex"  value="M"  ${emp.sex eq "M" ? "checked":"" }>男
       <input type="radio"  name="sex"  value="F"  ${emp.sex eq "F" ? "checked":"" }>女<br>
       员工薪水<input type="text"  name="sar"  value="${emp.sar }"><br>
       入职时间<input type="text"  name="hire" value="${emp.hire }"><br>
       所属部门<select name="did">
       	<c:forEach items="${depts }" var="d">
       		<option value="${d.did }"  ${emp.did eq d.did ? "selected": "" }>${d.dname }</option>
       	</c:forEach>
       </select><br>
       分配帐号<br>
       用户名<input type="text" name="user.username"  value="${emp.user.username }"><br>
       密码<input type="password" name="user.pwd"  value="${emp.user.pwd }"><br>
       <input type="submit" value="保存"> 
  </form>
</body>
</html>