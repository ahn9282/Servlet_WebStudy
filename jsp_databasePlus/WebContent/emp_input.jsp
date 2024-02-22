<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원 정보 입력</h1>
<hr>
<hr>

<form action="check_info.jsp">

<table>

<tr>
<td>사원번호</td>
<td><input type="number" name="empno" size="20"><br></td>
</tr>

<tr>
<td>사원이름</td><td><input type="text" name="ename" size="20"><br></td>
</tr>

<tr>
<td>직급</td> <td><select name = "job">
	<option value = "clerk">clerk</option>
	<option value = "salesman"selected = "selected">salesman</option>
	<option value = "manager">manager</option>
	<option value = "analyst">analyst</option>
	<option value = "president">president</option>
	</select><br/></td>
</tr>

<tr>
<td>매니저 </td>
<td><select name = "mgr">
	<option value = "jones">jones</option>
	<option value = "ford"selected = "selected">ford</option>
	<option value = "clark">clark</option>
	<option value = "blake">blake</option>
	<option value = "king">king</option>
	</select><br/></td>
	</tr>
	
<tr>
<td>입사일</td>
<td> <input type="date" name="hiredate" size="20"><br/></td>
</tr>

<tr>
<td>급여 </td>
<td><input type="text" name="sal" size="20"><br/></td>
</tr>

<tr>
<td>커미션 
<td><input type="text" name="comm" size="20"><br/></td>
</tr>

<tr>
<td>부서명 
<td><select name = "dname">
	<option value = "accounting">accounting</option>
	<option value = "research"selected = "selected">research</option>
	<option value = "sales">sales</option>
	<option value = "operations">operations</option>
	</select><br/></td>
	</tr>
	
</table>
<input type="submit" value="전송">
</form>
</body>
</html>