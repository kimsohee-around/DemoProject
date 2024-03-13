<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>커피24 북카페</title>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/community.css?v=3">  <!-- 절대경로 -->
<!-- 상대경로는 ../css/community.css 입니다. 
request객체의 contextPath를 el로 접근할 때에는 현재 jsp 객체 pageContext 를 사용해야 합니다. -->
</head>
<body>
			<main id="write">
			<h3>관리자 :: 공지사항</h3>
			<p>관리자만 새로운 공지사항을 작성할 수 있습니다.</p>
			<hr style="color:white;">
			<form method="post" action="save" enctype="multipart/form-data">
			 <table>
			 	<tr><th><label>제목</label></th>
			 		<td><input type="text" name="title" size="50" required></td>
			 	</tr>
			 	<tr><th><label>첨부파일</label></th>
			 		<td><input type="file" name="attachfile"></td>
			 	</tr>
			 	<tr><th><label>내용</label></th>  <!-- textarea 의 크기 : rows="30" 는 행 크기, cols="80"은 열  크기 -->
			 		<td><textarea  rows="30" cols="80" name="content" style="resize:none;"  required></textarea>
			 	</tr>
			 	<tr>
			 	<td style="text-align: center;padding: 10px;" colspan="2">
			 	<button type="submit">저장</button>
			 	<button type="reset">다시쓰기</button>
			 	<button type="button" onclick="location.href='list?page=${(page eq null)?1:page}'">목록</button>
			 	<!-- 목록 돌아갈 페이지 값 없을 때 오류 방지를 위해 page 애트리뷰트값이 null 이면 1  -->
			 	</td></tr>
			 </table>
			 </form>
			 </main>
</body>
</html>
