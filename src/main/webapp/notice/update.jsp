<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<head>
	<title>커피24 북카페</title>
	<meta content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/community.css?v=3">  <!-- 절대경로 -->
	<script src="https://kit.fontawesome.com/352c53403e.js" crossorigin="anonymous"></script>
</head>
<body>
<main id="write">
<h3>이용안내 :: 공지사항</h3>
<p>우리동네 북카페는 편안하고 행복합니다.</p>
<hr style="color:white;">
<form name="frm1" method="post" action="update" onreset="onReset()" enctype="multipart/form-data">
	<input type="hidden" name="idx" value="${vo.idx }">
	<!-- 현재페이지 번호 전달 - 세션에 있으므로 생략 -->
 <table>
 	<tr><th>제목</th>
 		<td>
 			<c:choose>
 				<c:when  test="${fn:contains(vo.title,'[수정]') }">
 					<input type="text" name="title" size="50" value="${vo.title }" readonly>	
 				</c:when>
 				<c:otherwise>
 					<input type="text" name="title" size="50" value="[수정]${vo.title }" readonly>
 				</c:otherwise>
 			</c:choose>
 			<!-- readonly : 입력불가 -->
 		</td>
 	</tr>
 	<tr>
		<th>작성 날짜</th>
 		<td><c:out value="${vo.createdAt }"/></td>
 	</tr>
 	 <tr>
		<th>첨부 파일</th>
 		<td id="attach">
 		<c:if test="${vo.attachFile == null }">
 			<input type="file" name="attachfile">
 		</c:if>
 		<c:if test="${vo.attachFile != null }">
 			<a href=""><c:out value="${vo.attachFile }" /></a>
 			<input type="hidden" value="${vo.uploadFile }" name="uploadFile">
 			<input type="hidden" value="${vo.attachFile }" name="attachFile">
 			<button id="remove"><i class="fa-solid fa-circle-xmark"></i>삭제</button>
		</c:if>
 		</td>
 	</tr>
 	
 	<tr><th>내용</th>  <!-- textarea 의 크기 : rows="20" cols="80" -->
 		<td>
 			<textarea  rows="30" cols="80" name="content" id="content" required><c:out value="${vo.content }"/></textarea>
 		</td>
 	</tr>
 	<tr>
 	<td colspan="2" align="center">
	 	<button type="submit">저장</button>
	 	<button type="reset">다시쓰기</button>
	 	<button type="button" onclick="golist()">목록</button>  <!-- 현재페이지 번호 전달 - 순서5) -->
 	</td>
 	</tr>
 </table>
 </form>
</main> 
<script type="text/javascript">
	const attach =`
			<a href=""><c:out value='${vo.attachFile }' /></a>
			<input type="hidden" value='${vo.uploadFile }' name="uploadFile">
			<input type="hidden" value='${vo.attachFile }' name="attachFile">
			<button id="remove"><i class="fa-solid fa-circle-xmark" id="remove"></i>삭제</button>
			`
	document.querySelector("#remove").addEventListener('click',function(){
		 const inputFile = document.createElement('input');
		 inputFile.type = 'file';
  	     inputFile.name = 'attachfile';
  	     
  	   	 document.querySelector("#attach").innerHTML='';
  	   	 document.querySelector("#attach").appendChild(inputFile);
	})
	
	function onReset(event){
			const status = '${vo.attachFile }'
			if(status !='')
				document.querySelector("#attach").innerHTML=attach
			document.frm1.reset();
	}
	
	function golist(){
				let	url='list?'
				url += 'page='+${paging.currentPage };    //파라미터에 페이지번호 추가
				if('${paging.findText }'!='')		//검색값이 있을 때 파라미터에 검색값 2개 추가
						url += '&findText=${paging.findText }&column=${paging.column }'
				location.href=url
  }/* location.href='list?page=${paging.currentPage}&findText=${paging.findText }&column=${paging.column }' */
</script>
</body>
</html>