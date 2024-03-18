<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE HTML>
<!--
	Arcana by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>커피24 북카페</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<link rel="stylesheet" href="assets/css/main.css?v=3" />
		<link rel="stylesheet" href="css/layout.css?v=3" />
		<script src="https://kit.fontawesome.com/352c53403e.js" crossorigin="anonymous"></script>
	</head>
	<body class="is-preload">
		<div id="page-wrapper">

			<!-- Header -->
			<%@ include file="./layout/header.jsp" %>

			<!-- Main -->
				<section class="wrapper style1">
					<div class="container">
						<div class="row gtr-200">
							<div class="col-8 col-12-narrower">
								<div id="content">

									<!-- Content -->
										<article>
											<header>
												<h2>커피24 북카페</h2>
												<p>커피24 북카페는 무인 카페로 운영됩니다. 이용하시는 분들이 이야기를 나누는 온라인 공간입니다.</p>
											</header>

											<span class="image featured"><img src="images/banner.jpg" alt="" /></span>

											<p></p>

											<h3>새로나온 책</h3>
											<p>신간을 소개하는 내용을 작성해 주세요.</p>

											<h3>책장</h3>
											<p>회원 여러분이 소장한 도서를 거래하실 수 있습니다.</p>

											<h3>책벌레</h3>
											<p>책을 좋아하시는 회원을 소개합니다.</p>
											
											<h3>북챗</h3>
											<p>책과 관련된 소소한 이야기를 나눠주세요.</p>


											<p></p>
										</article>

								</div>
							</div>
							<div class="col-4 col-12-narrower">
								<div id="sidebar">

									<!-- Sidebar -->

										<section>
											<h3>이용안내</h3>
											<p>무인으로 잘 운영이 되기 위해 함께 이용하시는 분들에 대해 배려를 당부드립니다.</p>
											<!-- <footer>
												<a href="#" class="button">Continue Reading</a>
											</footer> -->
										</section>

										<section>
											<h3>이용시간</h3>
											<ul class="links">
												<li>오전 06:00 ~ 오후 10:00</a></li>
												<li>매장의 책은 대여자 명단에 꼭 작성하고 이용해 주세요.</li>
												<!-- <li><a href="#">Semper mod quis eget mi dolore</a></li>
												<li><a href="#">Consequat etiam lorem phasellus</a></li>
												<li><a href="#">Amet turpis, feugiat et sit amet</a></li>
												<li><a href="#">Semper mod quisturpis nisi</a></li> -->
											</ul>
											<footer>
												<a href="#" class="button">책 목록</a>
											</footer>
										</section>

								</div>
							</div>
						</div>
					</div>
				</section>

			<!-- Footer -->
				<div id="footer">
					<div class="container">
						<div class="row">
							<section class="col-3 col-6-narrower col-12-mobilep">
								<h4>지역 공공도서관</h4>
								<ul class="links">
									<li><a href="#">국립어린이청소년도서관</a></li>
									<li><a href="#">역삼도서관</a></li>
									<li><a href="#">역삼푸른솔도서관</a></li>
									<li><a href="#">지식재산전문도서관</a></li>
								</ul>
							</section>
							<section class="col-3 col-6-narrower col-12-mobilep">
								<h4>지역 유명서점</h4>
								<ul class="links">
									<li><a href="#">알라딘 중고서점(강남점)</a></li>
									<li><a href="#">영풍문고 강남역점</a></li>
									<li><a href="#">영풍문고 강남포스코점</a></li>
									<li><a href="#">교보문고 강남점</a></li>
									<li><a href="#">한티문고</a></li>
									<li><a href="#">최인아 책방</a></li>
								</ul>
							</section>
							
						</div>
					</div>

					<!-- Icons -->
						<ul class="icons">
							<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon brands fa-github"><span class="label">GitHub</span></a></li>
							<li><a href="#" class="icon brands fa-google-plus-g"><span class="label">Google+</span></a></li>
						</ul>

					<!-- Copyright -->
						<div class="copyright">
							<ul class="menu">
								<li>&copy; BookCafe24🧵SHiKim. All rights reserved</li>
							</ul>
						</div>

				</div>

		</div>
	<div data-num="1" id="datanum"></div>
	<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="js/nav.js"></script>
	</body>
</html>