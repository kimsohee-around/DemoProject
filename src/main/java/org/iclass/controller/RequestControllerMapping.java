package org.iclass.controller;

import java.util.HashMap;
import java.util.Map;

import org.iclass.controller.api.ApiCheckIdController;
import org.iclass.controller.api.ApiGetBookOneController;
import org.iclass.controller.api.ApiMemberJoinController;
import org.iclass.controller.api.ApiMemberModifyController;
import org.iclass.controller.api.ApiNewBookImageUploadController;
import org.iclass.controller.api.ApiPaymentSaveController;
import org.iclass.controller.book.BookCaseFormController;
import org.iclass.controller.book.BookCaseListController;
import org.iclass.controller.book.BookCasePayRequestFailController;
import org.iclass.controller.book.BookCasePayRequestSuccessController;
import org.iclass.controller.book.BookCaseSaveController;
import org.iclass.controller.book.NewBookListController;
import org.iclass.controller.book.NewBookSaveController;
import org.iclass.controller.book.NewFormController;
import org.iclass.controller.community.CommentsController;
import org.iclass.controller.community.DeleteController;
import org.iclass.controller.community.ListController;
import org.iclass.controller.community.ReadController;
import org.iclass.controller.community.UpdateController;
import org.iclass.controller.community.UpdateViewController;
import org.iclass.controller.community.WriteController;
import org.iclass.controller.community.WriteViewController;
import org.iclass.controller.member.AuthCertSMSController;
import org.iclass.controller.member.LoginActionController;
import org.iclass.controller.member.LoginViewController;
import org.iclass.controller.member.LogoutController;
import org.iclass.controller.member.MemberDropController;
import org.iclass.controller.member.MemberJoinController;
import org.iclass.controller.member.MemberModifyController;
import org.iclass.controller.member.MemberSaveController;

public class RequestControllerMapping {
	private static final Map<RequestKeyValue,Controller> mapping = new HashMap<>();
	
	public static void init() {
		//설계된 url,method 에 따라 처리할 controller 구현체를 Key,Value 로 HashMap에 저장합니다.
		mapping.put(new RequestKeyValue("/community/list", "GET"), new ListController() );
		mapping.put(new RequestKeyValue("/community/write","GET"), new WriteViewController() );
		mapping.put(new RequestKeyValue("/community/write","POST"), new WriteController() );

//		//게시판 글 상세보기 ,수정하기,삭제하기
		mapping.put(new RequestKeyValue("/community/read", "GET"), new ReadController() );
		mapping.put(new RequestKeyValue("/community/update","GET"), new UpdateViewController() );
		mapping.put(new RequestKeyValue("/community/update","POST"), new UpdateController() );
		mapping.put(new RequestKeyValue("/community/delete","GET"), new DeleteController() );		//오류 처리 위해 POST로 변경
		mapping.put(new RequestKeyValue("/community/comments","POST"), new CommentsController());
		//회원가입
		mapping.put(new RequestKeyValue("/join","GET"), new MemberJoinController());
		mapping.put(new RequestKeyValue("/join","POST"), new MemberSaveController());
		mapping.put(new RequestKeyValue("/auth/cert/sms","GET"), new AuthCertSMSController());
//		
//		//회원정보수정
		mapping.put(new RequestKeyValue("/member/modify","GET"),new MemberModifyController());
		mapping.put(new RequestKeyValue("/api/modify","POST"),new ApiMemberModifyController());
		mapping.put(new RequestKeyValue("/member/drop","GET"),new MemberDropController());
//		
//		//로그인
		mapping.put(new RequestKeyValue("/login", "GET"), new LoginViewController());
		mapping.put(new RequestKeyValue("/login", "POST"), new LoginActionController());
		mapping.put(new RequestKeyValue("/logout", "GET"), new LogoutController());

		//새로나온책 (파일업로드)
		mapping.put(new RequestKeyValue("/book/new", "GET"), new NewFormController());
		mapping.put(new RequestKeyValue("/book/new", "POST"), new NewBookSaveController());
		mapping.put(new RequestKeyValue("/book/upload", "POST"), new ApiNewBookImageUploadController());
		mapping.put(new RequestKeyValue("/book/list", "GET"), new NewBookListController());

		//책장
		mapping.put(new RequestKeyValue("/book/bookcase","GET"), new BookCaseListController());
		mapping.put(new RequestKeyValue("/pay/success","GET"), new BookCasePayRequestSuccessController());
		mapping.put(new RequestKeyValue("/pay/fail","GET"), new BookCasePayRequestFailController());
		//추가
		mapping.put(new RequestKeyValue("/book/form","GET"), new BookCaseFormController());
		mapping.put(new RequestKeyValue("/book/save","POST"), new BookCaseSaveController());
		
		//공지사항(검색기능)
//		mapping.put(new RequestKeyValue("/notice/list", "GET"), new NoticeListController());
//		mapping.put(new RequestKeyValue("/notice/read", "GET"), new NoticeReadController());
//		mapping.put(new RequestKeyValue("/notice/write", "GET"), new NoticeWriteController());
//		mapping.put(new RequestKeyValue("/notice/save", "POST"),new NoticeWriteSaveController());
//		mapping.put(new RequestKeyValue("/notice/update", "GET"), new NoticeUpdateController());
//		mapping.put(new RequestKeyValue("/notice/update", "POST"), new NoticeUpdateSaveController());
//		mapping.put(new RequestKeyValue("/notice/delete", "GET"), new NoticeDeleteController());
//		mapping.put(new RequestKeyValue("/notice/download", "POST"), new NoticeFileDownloadController());

		// api mapping
		mapping.put(new RequestKeyValue("/api/auth/checkId", "POST"), new ApiCheckIdController() );
		mapping.put(new RequestKeyValue("/api/auth/join", "POST"), new ApiMemberJoinController() );
		mapping.put(new RequestKeyValue("/api/book", "GET"), new ApiGetBookOneController() );
		mapping.put(new RequestKeyValue("/api/pay", "POST"), new ApiPaymentSaveController() );

	}
	//url,method 필드를 저장하는 key 를 전달받아 HashMap에서 value(컨트롤러)를 리턴
	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
}
