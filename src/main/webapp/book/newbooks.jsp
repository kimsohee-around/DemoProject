<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>커피24 북카페</title>		 <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="" />
	<link rel="stylesheet" href="../css/bookmodal.css" />
	<link rel="stylesheet" href="../css/layout.css" />
	<link rel="stylesheet" href="../assets/css/style.css" />  <!-- 회원가입 (temp.css 는 미사용)-->
	<link rel="stylesheet" href="../assets/css/main.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/booklist.css?v=3">  <!-- 절대경로 -->
	<script src="https://kit.fontawesome.com/352c53403e.js" crossorigin="anonymous"></script>
    </head>

</head>
<body class="is-preload">
		<div id="page-wrapper">
			<!-- Header -->
			<%@ include file="../layout/header.jsp" %>
<section id="booklist">
<h3>새로나온 책 </h3>
<p>새로 나온 책을 자유롭게 소개해 주세요. </p>
<hr style="color:white;">
<div id="mainarea">
			<c:forEach var="bo" items="${books }">
			<div class="gallery">
				<div style="height:80%;">
				<i class="icon solid fa-regular fa-bookmark"></i> <span></span> <!-- <i class="fa-duotone fa-bookmark"></i> -->
				<img src="/upload/${bo.coverfile }" alt="${bo.title }" data-num="${bo.idx }">
				<!-- 이미지가 저장된 서버의 파일시스템 경로는 url /upload 로 설정을 해야합니다.
					 server.xml 에서 하러 갑니다.
			<Context docBase="d:\iclass1020\upload" path="/upload" reloadable="true"/>
			</Host>바로위에 작성하기 
				 -->
				</div>
				<hr>
				<p>${bo.title }</p>
				<p style="font-size: 0.8em;">${bo.userid }</p>
			</div>
			</c:forEach>

</div>
	<div style="float:right;margin:40px;padding-right: 100px;">
		<a href="new" class="button" >쓰기</a>  
	</div>
</section>
<div data-num="2" id="datanum"></div>
</div>

<!-- The Modal -->
<div class="modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h6 class="modal-title">New Book</h6>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<h3 id="userid"></h3>
					<p id="regdate"></p>
					<h2 id="title"></h2>
					<p id="summary"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					<!--  <button type="button" class="btn btn-primary">Save changes</button>-->
				</div>
			</div>
		</div>
	</div>


	<!--  -->
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/jquery.dropotron.min.js"></script>
			<script src="../assets/js/browser.min.js"></script>
			<script src="../assets/js/breakpoints.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<script src="../assets/js/main.js"></script>
			<script src="../js/nav.js"></script>
			<!-- 부트스트랩 - 모달 사용 -->
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
			<!-- 비동기 http 통신 axios api-->
			<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
		async function requestBookOne(idx){
			const result = await axios.get('../api/book?idx='+idx)
			return result.data
		}

	  	const modal = new bootstrap.Modal(document.querySelector(".modal"))  /* 부트스트랩의 모달 기능을 제공하는 객체*/
		document.querySelector("#mainarea").addEventListener('click',function(evt){
			evt.preventDefault()			//a 태그 등 pagination 안에 있는 기본 클릭 동작을 중지
			//evt.stopPropagation()			//클릭 이벤트는 자식 또는 부모요소에 전달되는데 그것을 중지
			const target = evt.target
			if(target.tagName !== 'IMG') {return}			

			const idx = target.getAttribute("data-num")
			const obj = {idx : idx}
			console.log(obj)
			requestBookOne(idx)
				.then(result => {
					console.log('result',result);
					document.querySelector(".modal-body #userid").innerHTML = result.userid
					document.querySelector(".modal-body #regdate").innerHTML = result.regdate
					document.querySelector(".modal-body #title").innerHTML = result.title
					document.querySelector(".modal-body #summary").innerHTML = result.summary
				})
				.catch(e=> {
					console.error(e.response)
				})
				
			modal.show();
		})
		
</script>			
</body>
</html>












