<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="${css}/kabank.css">
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<section>
<article>
<div id="wrapper">
<h1>카카오 뱅크</h1>
<table id="kakao_table">
	<tr>
		<td colspan="3"><button id="create_passBook">통장 개설</button></td>
	</tr>
	<tr>
		<td><button>입금</button></td>
		<td><button>출금</button></td>
		<td><button>송금</button></td>
	</tr>
</table>
</div>
</article>
</section>
<aside></aside>
<%@ include file="../common/foorter.jsp" %>
</body>
<script>
document.querySelector('#create_passBook').addEventListener("click",function(){
	alert("통장개설")
	location.href="${pageContext.request.contextPath}/kakao.do?cmd=createanum&dir=kakao&page=result"
},false);
</script>
</html>