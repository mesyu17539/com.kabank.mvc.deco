<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>
<link rel="stylesheet" href="${css}/bitc.css" />
<div id ="wrapper">
<h2> 마이페이지 </h2>
<section>
<table id="bitc_table">
	<tr>
		<th rowspan="6" class="shema"><img src="${pageContext.request.contextPath}/resources/png/profile.png" alt="" /></th>
		<th class="shema">ID</th>
		<td>${sessionScope.user.id}</td>
		<th class="shema">생년월일</th>
		<td>${sessionScope.user.ssn}</td>
	</tr>
	<tr>
		<th class="shema">전화번호</th>
		<td>${sessionScope.user.mobile.phone}</td>
		<th class="shema">가입일</th>
		<td>${sessionScope.user.mobile.regDate}</td>
	</tr>
	<tr>
		<th class="shema">비밀번호</th>
		<td>${sessionScope.user.pass}</td>
		<th class="shema">전화번호</th>
		<td>${sessionScope.user.phone}</td>
	</tr>
	<tr>
		<th class="shema">이름</th>
		<td>${sessionScope.user.name}</td>
		<th class="shema">이메일</th>
		<td>${sessionScope.user.email}</td>
	</tr>
	<tr>
		<th class="shema">성별</th>
		<td>${sessionScope.user.id}</td>
		<th class="shema">주소</th>
		<td>${sessionScope.user.addr}</td>
	</tr>
	<tr>
		<th class="shema">회원번호</th>
		<td>${sessionScope.user.account.customerNum}</td>
		<th class="shema">ACCOUNT</th>
		<td>${sessionScope.user.account.accountNum}</td>
	</tr>
<tr><td colspan="5"><button id="bitcam_passbtn">비밀번호 변경</button> <button id="bitcam_leavebtn">탈퇴</button></td></tr>
</table>

</section>
</div>
<%@ include file="../common/foorter.jsp"%>
</body>
<script>
document.querySelector('#bitcam_passbtn').addEventListener("click",function () {
	alert("비밀번호 변경 클릭");
	location.href="${pageContext.request.contextPath}/user.do?cmd=move&dir=bitcamp&page=changePath"
},false);
document.querySelector('#bitcam_leavebtn').addEventListener("click",function(){
	alert("탈퇴버튼 클릭")
	location.href="${pageContext.request.contextPath}/user.do?cmd=leave&dir=user&page=login"
},false);
</script>