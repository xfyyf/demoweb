<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>员工管理</h2>
   <form action="/empweb/list.sw"  method="post">
        姓名<input type="text" name="ename">
        帐号<input type="text" name="username"><br>
        性别<input type="radio" name="sex" value="A" checked>全部
        <input type="radio" name="sex" value="M">男
        <input type="radio" name="sex" value="F">女<br>
        部门<select  name="did">
        		<option value="0">请选择</option>
        		<c:forEach items="${depts }" var="d">
        			<option value="${d.did }">${d.dname }</option>
        		</c:forEach>
        </select>
        <input type="submit" value="查询">
   </form>
   
    <table border="1">
    		<tr><td>编号</td><td>姓名</td><td>性别</td><td>入职时间</td><td>薪水</td><td>部门</td><td>帐号</td><td>操作 <a href="/empweb/toadd.sw">添加新员工</a></td></tr>
    		
    		<c:forEach items="${emplist }" var="emp">
    		<tr><td>${emp.eid}</td><td>${emp.ename}</td>
    		<td>${emp.sex}</td><td>${emp.hire}</td>
    		<td>${emp.sar}</td><td>${emp.dept.dname}</td>
    		<td>${emp.user.username}</td>
    		<td><a href="/empweb/toupdate.sw?eid=${emp.eid }">修改</a>
    		<a href="/empweb/delete.sw?eid=${emp.eid }">删除</a>
    		</td></tr>
    		</c:forEach>
    		
    </table>
</body>
</html>