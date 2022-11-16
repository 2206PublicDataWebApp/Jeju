package com.jeju.reservation.service;

import java.util.HashMap;
import java.util.List;

import com.jeju.member.controller.AdminMemberController;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.coupon.domain.Coupon;
import com.jeju.coupon.domain.MyCoupon;
import com.jeju.member.domain.Member;
import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.store.ReservationStore;
import com.jeju.room.domain.Room;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class ReservationServiceImpl implements ReservationService{

	private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired 
	private ReservationStore aStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public void certifiedPhoneNumber(String userPhoneNumber, int randomNumber) {
//		String api_key = "NCS3TEE3BB7UBS3I";
//	    String api_secret = "BWNUP67CGPPA7Q96ANWO1PRKYIJBWMJ5";
		String api_key = "NCSILAUCKWP4QXSQ";
	    String api_secret = "O29BOSR08SXXFTU3ZYSL2JJCU5LOWCTF";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", userPhoneNumber); 
	    params.put("from", "01036674321");
	    params.put("type", "SMS");
	    params.put("text", "[TEST]" + "["+randomNumber+"]"); // ���� ���� �Է�
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	        JSONObject obj = (JSONObject) coolsms.send(params);
	      } catch (CoolsmsException e) {
			logger.info(e.getMessage());
	        logger.info(String.valueOf(e.getCode()));
	      }
	}
	
	@Override
	public void sendReservationCode(String phoneNumber, String reservationCode) {
		String api_key = "NCSILAUCKWP4QXSQ";
	    String api_secret = "O29BOSR08SXXFTU3ZYSL2JJCU5LOWCTF";
	    Message coolsms = new Message(api_key, api_secret);
	    
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", phoneNumber);
	    params.put("from", "01036674321");   
	    params.put("type", "SMS");
	    params.put("text", "예약번호" + "["+reservationCode+"]"); // ���� ���� �Է�
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	        JSONObject obj = (JSONObject) coolsms.send(params);
	      } catch (CoolsmsException e) {
			logger.info(e.getMessage());
			logger.info(String.valueOf(e.getCode()));
	      }
	}

	@Override
	public int addReservation(Reservation reservation) {
		int result = aStore.addReserve(session, reservation);
		return result;
	}

	@Override
	public int addReservationWait(Reservation reservation) {
		int result = aStore.addReserveWati(session, reservation);
		return result;
	}

	@Override
	public Pension selectOneByPension(Integer pensionNo) {
		Pension pList = aStore.selectOneByPension(session, pensionNo);
		return pList;
	}

	@Override
	public Room selectOneByRoom(Integer roomNo) {
		Room room = aStore.selectOneByRoom(session, roomNo);
		return room;
	}

	// 관리자페이지 전체예약조회
	@Override
	public List<Reservation> showAllReservation() {
		List<Reservation> reservationList = aStore.showAllReservation(session);
		return reservationList;
	}


	//결제대기 리스트 불러오기
	@Override
	public List<Reservation> selectWaitList(String memberId) {
		List<Reservation> wList = aStore.selectWaitList(session, memberId);
		return wList;
	}

	//결제대기 추가전 이미지 경로 불러오기
	@Override
	public Pension selectImage(Integer rePensionNo) {
		Pension imageList = aStore.selectImage(session, rePensionNo);
		return imageList;
	}

	@Override
	public List<Reservation> selectReserveList(String memberId) {
		List<Reservation> rList = aStore.selectReserveList(session, memberId);
		return rList;
	}

	@Override
	public Reservation selectOneByWaitList(Integer reservationNo) {
		Reservation rList = aStore.selectOneByWaitList(session, reservationNo);
		return rList;
	}

	//결제대기 수동삭제
	@Override
	public int deleteWaitReserve(Integer reservationNo) {
		int result = aStore.deleteWaitReserve(session, reservationNo);
		return result;
	}

	//결제대기 자동삭제
	@Override
	public int removeWaitReserve(String reservationName) {
		int result = aStore.removeWaitReserve(session, reservationName);
		return result;
	}

	@Override
	public int selectRstatus(String memberId) {
		int result = aStore.selectWaitRstatus(session, memberId);
		return result;
	}

	@Override
	public List<Reservation> expirationReserveList(String memberId) {
		List<Reservation> sList = aStore.expirationList(session, memberId);
		return sList;
	}
	//내 쿠폰정보 가져오기
	@Override
	public List<MyCoupon> selectAllMyCoupon(String memberId) {
		List<MyCoupon> cList = aStore.selectAllMyCoupon(session, memberId);
		return cList;
	}

	@Override
	public Coupon selectAllCouponList(String couponCode) {
		Coupon cList = aStore.selectAllCouponList(session, couponCode);
		return cList;
	}

	@Override
	public Reservation selectNonMemberInfo(Reservation reservation) {
		Reservation reserveInfo = aStore.selectNonMember(session, reservation);
		return reserveInfo;
	}

	@Override
	public int deleteReserve(Reservation reservation) {
		int result = aStore.deleteReserve(session, reservation);
		return result;
	}

	@Override
	public Reservation selectReservationInfo(Integer reservationNo) {
		Reservation reserveInfo = aStore.selectReservationInfo(session, reservationNo);
		return reserveInfo;
	}

	@Override
	public int deleteReservation(Integer reservationNo) {
		int result = aStore.deleteReservation(session, reservationNo);
		return result;
	}

	@Override
	public Reservation selectCouponCode(Integer reservationNo) {
		Reservation couponCode = aStore.selectCouponCode(session, reservationNo);
		return couponCode;
	}

	@Override
	public int upCouponCount(Reservation reservation) {
		int result = aStore.upCouponCount(session, reservation);
		return result;
	}

	@Override
	public int updateStatus(Reservation reservation) {
		int result = aStore.updateStatus(session, reservation);
		return 0;
	}

	@Override
	public Member selectOneByMember(String memberId) {
		Member mOne = aStore.selectOneByMember(session, memberId);
		return mOne;
	}

}
