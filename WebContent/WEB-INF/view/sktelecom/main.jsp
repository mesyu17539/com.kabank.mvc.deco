<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/member.css" />
<body>
<%@ include file="../common/header.jsp" %>
<section>
<article>
	<header id="join_header">
		모바일 개통
	</header>
</article>
<article>
	<div id="wrapper">
		<table id="join_table">	
			<tr>
				<th><button id="join_conform_btn">개통 버튼</button></th>
			</tr>
		</table>
	</div>
</article>
</section>
<%@ include file="../common/foorter.jsp" %>
</body>
<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/member.css">
<script>
document.querySelector('#join_conform_btn').addEventListener("click",
		function () {
	alert("모바일 개통~");
	location.href="${pageContext.request.contextPath}/mobile.do?cmd=join&dir=user&page=mypage";
},false);

</script>
</html>