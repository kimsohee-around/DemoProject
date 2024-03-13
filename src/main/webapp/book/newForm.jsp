<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>커피24 북카페</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/layout.css" />
	<link rel="stylesheet" href="../assets/css/style.css" />  <!-- 회원가입 (temp.css 는 미사용)-->
	<link rel="stylesheet" href="../assets/css/main.css" />	
	<link rel="stylesheet" href="../css/book.css" />
	<link href="//cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
	<script src="//cdn.quilljs.com/1.3.6/quill.js"></script>

<!-- 상대경로는 ../css/community.css 입니다. 
request객체의 contextPath를 el로 접근할 때에는 현재 jsp 객체 pageContext 를 사용해야 합니다. -->
</head>
	<body class="is-preload">
		<div id="page-wrapper">
			<!-- Header -->
			<%@ include file="../layout/header.jsp" %>
			<section id="book">
			<h3>새로나온 책 </h3>
			<p class="sub">새로 나온 책을 소개해 주세요. </p>
			<hr style="color:white;">
			<form method="post" action="new" enctype="multipart/form-data">
				<input type="hidden" name="userid" value="${user.userid }">
			 <table>
			 	<tr><th style="width:25%;"><label>책 제목</label></th>
			 		<td><input type="text" name="title" size="50" required></td>
			 	</tr>
			 	<tr>
			 	<!-- 사용자가 선택 이미지 파일이 서버에 업로드 되도록합니다. form 태그의 enctype 속성-->
					<th><label>책 커버<br>(대표 이미지)</label></th>
			 		<td><input type="file" name="coverfile" accept="image/*">
			 		<!-- <input type="file" name="coverfile" accept="image/*"> -->
			 		<!-- 웹에서 파일형식 MIME 으로 설정. 이미지 파일 선택 accept 속성 설정 
			 		 파일 선택 대화상자에 모든파일이 있으므로 추가로 자바스크립트에서 확장자 체크하는 함수 필요합니다.
			 		 필요에 따라 file 타입 input을 여러개 사용하거나 또는
			 		 multiple="multiple" 설정은 동시에 여러개 파일 선택 가능하고 컨트롤러에서는 
			 		 이것을 Enumeration 타입으로 받습니다.
참고 : https://velog.io/@virtualplastic/JSP-Servlet-%EC%97%AC%EB%9F%AC-%EA%B0%9C%EC%9D%98-%ED%8C%8C%EC%9D%BC%EC%9D%84-%ED%95%9C%EB%B2%88%EC%97%90-%EC%97%85%EB%A1%9C%EB%93%9C
			 		-->
			 		</td>
			 	</tr>
			 	<tr><th colspan="2"><label>추천 글(스포일러가 있으면 미리 알려주세요.)<br>
			 	- 글에 이미지를 포함할 수 있습니다.</label></th> </tr>
			 	<tr>
			 		<td colspan="2">
			 		<div id="editor"></div>
					<input type="hidden" id="quill_html" name="summary">
			 		</td>
			 	</tr>
			 	<tr>
			 	<!-- <th></th> -->
			 	<td style="text-align: center;padding: 10px;" colspan="2">
			 	<button type="submit" class="book-btn">저장</button>
			 	<button type="reset" class="book-btn">다시쓰기</button>
			 	<button type="button" onclick="location.href='list'" class="book-btn">목록</button>
			 	</td></tr>
			 </table>
			 </form>
			 </section>
			 <div data-num="2" id="datanum"></div>
	</div>		 
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/jquery.dropotron.min.js"></script>
				<script src="../assets/js/browser.min.js"></script>
			<script src="../assets/js/breakpoints.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<script src="../assets/js/main.js"></script>
			<script src="../js/nav.js"></script>
			<script src="../js/editor.js"></script>
</body>
</html>
