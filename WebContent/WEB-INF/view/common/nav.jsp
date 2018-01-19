<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="nav">
		<ul style="height: 10%">
			<li>
			<a id="burgerking" href="${ctx}/user.do?cmd=move&dir=burgerking&page=main">버거킹</a></li>
			<li>
			<a id="kakao" href="${ctx}/user.do?cmd=move&dir=kakao&page=main">카카오뱅크</a></li>
			<li>
			<a id="bitcamp" href="${ctx}/user.do?cmd=move&dir=bitcamp&page=main">비트캠프</a></li>
			<li>
			<a id="sktelecom" href="${ctx}/user.do?cmd=move&dir=sktelecom&page=main">sk텔레콤</a></li>
			<li>
			<a id="lotto" href="${ctx}/user.do?cmd=move&dir=lotto&page=main">로또</a></li>
			<li>
			<a id ="lotto" href="${ctx}/user.do?cmd=move&dir=user&page=mypage" >마이페이지</a></li>
			<li>
			 <a id ="lotto" href="${ctx}/user.do?cmd=leave&dir=user&page=login" >로그아웃</a></li>
		</ul>
</nav>