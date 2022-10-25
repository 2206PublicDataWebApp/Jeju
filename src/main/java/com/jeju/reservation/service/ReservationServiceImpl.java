package com.jeju.reservation.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.store.ReservationStore;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired 
	private ReservationStore aStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public void certifiedPhoneNumber(String userPhoneNumber, int randomNumber) {
		String api_key = "NCS3TEE3BB7UBS3I";
	    String api_secret = "BWNUP67CGPPA7Q96ANWO1PRKYIJBWMJ5";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", userPhoneNumber);    // 수신번호
	    params.put("from", "01032888503");    //발신할 번호
	    params.put("type", "SMS");
	    params.put("text", "[TEST] 인증번호는" + "["+randomNumber+"]" + "입니다."); // 문자 내용 입력
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	        JSONObject obj = (JSONObject) coolsms.send(params);
	        System.out.println(obj.toString());
	      } catch (CoolsmsException e) {
	        System.out.println(e.getMessage());
	        System.out.println(e.getCode());
	      }
	}

	@Override
	public int addReservation(Reservation reservation) {
		int result = aStore.addReserve(session, reservation);
		return result;
	}
	
}
