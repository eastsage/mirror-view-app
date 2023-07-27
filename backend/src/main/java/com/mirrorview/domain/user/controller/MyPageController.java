package com.mirrorview.domain.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirrorview.domain.essay.dto.EssayCreateDto;
import com.mirrorview.domain.essay.dto.EssayDetailDto;
import com.mirrorview.domain.essay.dto.EssayDto;
import com.mirrorview.domain.essay.service.EssayDetailService;
import com.mirrorview.domain.essay.service.EssayService;
import com.mirrorview.domain.feedback.dto.FeedbackDto;
import com.mirrorview.domain.feedback.service.FeedbackService;
import com.mirrorview.domain.user.service.MemberProfileService;
import com.mirrorview.global.auth.jwt.CustomMemberDetails;
import com.mirrorview.global.response.BaseResponse;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
@Api(tags = "마이페이지")
public class MyPageController {

	private final MemberProfileService memberProfileService;
	private final FeedbackService feedbackService;
	private final EssayService essayService;
	private final EssayDetailService essayDetailService;

	@PatchMapping("/image")
	public ResponseEntity<?> updateImage(String userId, String photo) {
		memberProfileService.updatePhoto(userId, photo);
		return BaseResponse.ok(HttpStatus.OK, "프로필 사진 수정 완료");
	}

	@PatchMapping("/nickname")
	public ResponseEntity<?> updateNickname(String userId, String nickname) {
		try {
			memberProfileService.updateNickname(userId, nickname);
		} catch (IllegalArgumentException e) {
			return BaseResponse.fail(e.getMessage(), 400);
		}
		return BaseResponse.ok(HttpStatus.OK, "닉네임 변경 완료");
	}

	@GetMapping("/feedbacks/{roomId}")
	public ResponseEntity<?> showFeedbacks(@PathVariable("roomId") Long roomId) {
		List<FeedbackDto> list = feedbackService.findFeedbackByRoomId(roomId);
		return BaseResponse.okWithData(HttpStatus.OK, "방별 피드백 불러오기 성공", list);
	}

	@DeleteMapping("/feedbacks/feedback/{feedbackId}")
	public ResponseEntity<?> deleteFeedbacks(@PathVariable("feedbackId") Long feedbackId) {
		try {
			feedbackService.deleteFeedbackByFeedbackId(feedbackId);
			return BaseResponse.ok(HttpStatus.OK, "피드백 삭제 성공");
		} catch (Exception e) {  // 추후 예외처리 수정
			return BaseResponse.fail("피드백 삭제 실패", 400);
		}

	}

	@GetMapping("/feedbacks/feedback/{feedbackId}")
	public ResponseEntity<?> detailFeedback(@PathVariable("feedbackId") Long feedbackId) {
		FeedbackDto data = feedbackService.findFeedbackByFeedbackId(feedbackId);
		return BaseResponse.okWithData(HttpStatus.OK, "피드백 단건 조회 성공", data);
	}

	@GetMapping("/feedbacks")
	public ResponseEntity<?> listFeedbacks(String userId) {
		String test = "test"; // 나중에 지울것
		List<FeedbackDto> list = feedbackService.findFeedbackByUserId(test);
		return BaseResponse.okWithData(HttpStatus.OK, "피드백 불러오기 성공", list);
	}

	@PutMapping("/essays") // 자소서안의 문항들 수정/삭제
	public ResponseEntity<?> updateEssays() {
		return null;
	}

	@PostMapping("/essays") // 자소서 추가 완료
	public ResponseEntity<?> createEssays(@RequestBody EssayCreateDto essays, @AuthenticationPrincipal
		CustomMemberDetails member) {
		try {
			essayService.insertEssayAndEssayDetails(essays, member.getUsername());
			return BaseResponse.ok(HttpStatus.OK, "자소서 저장 성공!");
		} catch (Exception e) {
			e.printStackTrace();
			return BaseResponse.fail("자소서 저장 실패!", 400);
		}
	}

	@GetMapping("/essays") // 전체 자소서 목록 불러오기
	public ResponseEntity<?> showEssays(String userId) {
		String test = "test"; // 나중에 지울것
		List<EssayDto> list = essayService.findEssayByUserId(test);
		return BaseResponse.okWithData(HttpStatus.OK, "에세이 목록 불러오기 성공", list);
	}

	@GetMapping("/essays/{essay-id}")  // 자소서 상세 보기
	public ResponseEntity<?> detailEssays(@PathVariable("essay-id") Long essayId) {
		List<EssayDetailDto> list = essayDetailService.findEssayByEssayId(essayId);
		return BaseResponse.okWithData(HttpStatus.OK, "에세이 불러오기 성공", list);
	}

	@DeleteMapping("/essays/{essay-id}") // 자소서 삭제
	public ResponseEntity<?> deleteEssays() {
		return null;
	}
}
