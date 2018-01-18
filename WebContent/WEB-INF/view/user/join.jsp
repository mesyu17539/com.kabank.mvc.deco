<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css" />
<body>
<%@ include file="../common/header.jsp" %>
<section>
<article>
	<header id="join_header">
		회원가입
	</header>
</article>
<article>
	<div id="wrapper">
		<form id="join_form" action="${pageContext.request.contextPath}/user.do?">
		<table id="join_table">	
			<tr>
				<td>ID : </td>
				<td>
					<input id="join_id" type="text" name="id"/>
					<button id="check_dupl" name="check_dupl" >중복확인</button>
				</td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" id="join_pass" name="pass"/> 일치합니다<br /></td>
			</tr>
			<tr>
				<td>비밀번호 확인 : </td>
				<td><input type="password" name="pass2"/><br /></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="name"/><br /></td>
			</tr>
			<tr>
				<td>주민번호 : </td>
				<td><input type="text" name="ssn1" placeholder="생년월일 1991.01.01"/>-<input type="text" name="ssn2" placeholder="뒷자리"/><br /></td>
			</tr>
			<tr>
				<td>전화번호 : </td>
				<td>
				<select name="phone1" id="phone1">
				<option value="010">010</option>
				</select>
				<input style="width:70px;" pattern="[0-9]{4}" name="phone2" placeholder=""/>-
				<input style="width:70px;" pattern="[0-9]{4}" name="phone3" placeholder=""/><br /></td>
			</tr>
			<tr>
				<td>이메일 :</td>
				<td><input type="email" name="email" placeholder="아이디"/>
				@<select name="url" id="url">
				<option value="@naver.com">naver.com</option>
				<option value="@gmail.com">gmail.com</option>
				<option value="@daum.net">daum.net</option>
				</select><br /></td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td><input type="text" name="addr"/><br /></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="2"> <button id="join_conform_btn">회원가입</button> <button id="join_clear">취소</button></td>
			</tr>
		</table>
			<!-- 프로필사진 : <input type="image" name="profile"/><br /> -->
			<input type="hidden" name="cmd" value="memberjoin"/>
			<input type="hidden" name="dir" value="user"/>
			<input type="hidden" name="page" value="login"/>
		</form>
	</div>
</article>
</section>
<%@ include file="../common/foorter.jsp" %>
</body>
<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/member.css">
<script>
document.querySelector('#join_conform_btn').addEventListener("click",
		function () {
	alert("가입하러간다~");
	document.querySelector('#join_form').submit();
},false);
document.querySelector('#check_dupl').addEventListener("click",
		function () {
	alert("첵킹!");
	document.querySelector('#join_form').submit();
},false);
</script>
</html>