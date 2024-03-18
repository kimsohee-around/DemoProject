<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
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
		<link rel="stylesheet" href="assets/css/main.css" />
		  <link rel="stylesheet" href="css/layout.css" />
	</head>
	<body class="is-preload">
		<div id="page-wrapper">

			<%@ include file="./layout/header.jsp" %>

			<!-- Main -->
				<section class="wrapper style1">
					<div class="container">
						<div class="row gtr-200">
							<div class="col-3 col-12-narrower">
								<div id="sidebar1">

									<!-- Sidebar 1 -->

										<section>
											<h3>이달의 책벌레</h3>
											<p>Phasellus quam turpis, feugiat sit amet ornare in, hendrerit in lectus.
											Praesent semper mod quis eget mi. Etiam eu ante risus. Aliquam erat volutpat.
											Aliquam luctus et mattis lectus sit amet pulvinar. Nam turpis et nisi etiam.</p>
											<footer>
												<a href="#" class="button">Continue Reading</a>
											</footer>
										</section>

										<section>
											<h3>인기 블로그</h3>
											<ul class="links">
												<li><a href="#"></a></li>
												<li><a href="#">Ornare in hendrerit lectus</a></li>
												<li><a href="#">Semper mod quis eget dolore</a></li>
												<li><a href="#">Consequat lorem phasellus</a></li>
												<li><a href="#">Amet turpis feugiat amet</a></li>
												<li><a href="#">Semper mod quisturpis nisi</a></li>
											</ul>
											<footer>
												<a href="#" class="button">More Random Links</a>
											</footer>
										</section>

								</div>
							</div>
							<div class="col-6 col-12-narrower imp-narrower">
								<div id="content">

									<!-- Content -->

										<article>
											<header>
												<h2>책벌레</h2>
												<p>단순 컨텐츠만 담을 페이지 입니다.</p>
											</header>

											<span class="image featured"><img src="images/banner.jpg" alt="" /></span>

											<p>Phasellus quam turpis, feugiat sit amet ornare in, hendrerit in lectus.
											Praesent semper mod quis eget mi. Etiam eu ante risus. Aliquam erat volutpat.
											Aliquam luctus et mattis lectus sit amet pulvinar. Nam turpis nisi
											consequat etiam lorem ipsum dolor sit amet nullam.</p>

											<h3>And Yet Another Subheading</h3>
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac quam risus, at tempus
											justo. Sed dictum rutrum massa eu volutpat. Quisque vitae hendrerit sem. Pellentesque lorem felis,
											ultricies a bibendum id, bibendum sit amet nisl. Mauris et lorem quam. Maecenas rutrum imperdiet
											rhoncus dui quis euismod. Maecenas lorem tellus, congue et condimentum ac, ullamcorper non sapien.
											Donec sagittis massa et leo semper a scelerisque metus faucibus. Morbi congue mattis mi.
											Phasellus sed nisl vitae risus tristique volutpat. Cras rutrum commodo luctus.</p>

											<p>Phasellus odio risus, faucibus et viverra vitae, eleifend ac purus. Praesent mattis, enim
											quis hendrerit porttitor, sapien tortor viverra magna, sit amet rhoncus nisl lacus nec arcu.
											Maecenas tortor mauris, consectetur pellentesque dapibus eget, tincidunt vitae arcu.
											Vestibulum purus augue, tincidunt sit amet iaculis id, porta eu purus.</p>
										</article>

								</div>
							</div>
							<div class="col-3 col-12-narrower">
								<div id="sidebar2">

									<!-- Sidebar 2 -->

										<section>
											<h3>Cubilia Adipiscing</h3>
											<ul class="links">
												<li><a href="#">Amet turpis, feugiat sit amet</a></li>
												<li><a href="#">Ornare in hendrerit lectus</a></li>
												<li><a href="#">Semper mod quis eget dolore</a></li>
												<li><a href="#">Consequat lorem phasellus</a></li>
												<li><a href="#">Amet turpis feugiat amet</a></li>
												<li><a href="#">Semper mod quisturpis nisi</a></li>
											</ul>
											<footer>
												<a href="#" class="button">More Random Links</a>
											</footer>
										</section>

										<section>
											<h3>Nisl sed Adipiscing</h3>
											<p>Phasellus quam turpis, feugiat sit amet ornare in, hendrerit in lectus.
											Praesent semper mod quis eget mi. Etiam eu ante risus. Aliquam erat volutpat.
											Aliquam luctus et mattis lectus sit amet pulvinar. Nam turpis et nisi etiam.</p>
											<footer>
												<a href="#" class="button">Continue Reading</a>
											</footer>
										</section>

								</div>
							</div>
						</div>
					</div>
				</section>

				<%@ include file="layout/footer.jsp" %>
				<div data-num="4" id="datanum"></div>
		</div>

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