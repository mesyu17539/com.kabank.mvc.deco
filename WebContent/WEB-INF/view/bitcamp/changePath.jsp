<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bitc.css" />
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
	<aside id="bitc_aside">
		<h1>비트 캠프 메인</h1>
	</aside>
<section id="bitc_section">
<div id="wrapper">
<form action="${pageContext.request.contextPath}/user.do?cmd=CHANGE" id="bit_form">
<table id="bitca_table">
	<tr>
		<th>현재 비밀번호</th>
		<td><input type="text" name="nowpass" value="${sessionScope.user.pass}"/></td>
	</tr>
	<tr>
		<th>변경 비밀번호</th>
		<td><input type="text" name="newpass1" value="32"/></td>
	</tr>
	<tr>
		<th>변경 비밀번호 확인</th>
		<td><input type="text" name="newpass2" value="32"/></td>
	</tr>
	<tr>
		<td colspan="2">
		</td>
	</tr>
</table>
<input type="hidden" name="cmd" value="change"/>
<input type="hidden" name="dir" value="user"/>
<input type="hidden" name="page" value="mypage"/>
</form>
<button id="changepass">확인</button><button id="cancel">취소</button>
</div>
</section>
</body>
<script>
document.querySelector('#changepass').addEventListener("click",function () {
	alert("비밀번호 변경 확인");
	document.querySelector('#bit_form').submit();
},false);
document.querySelector('#cancel').addEventListener("click",function(){
	alert("취소");
	location.href="${pageContext.request.contextPath}/user.do?cmd=move&dir=user&page=mypage"
},false);
</script>
</html>
