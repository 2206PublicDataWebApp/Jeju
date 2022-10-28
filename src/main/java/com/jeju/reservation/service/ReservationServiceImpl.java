package com.jeju.reservation.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.reservation.store.ReservationStore;
import com.jeju.room.domain.Room;

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
	    params.put("to", userPhoneNumber);    // ������ȭ��ȣ
	    params.put("from", "01032888503");    // �߽���ȭ��ȣ. �׽�Ʈ�ÿ��� �߽�,���� �Ѵ� ���� ��ȣ�� �ϸ� ��
	    params.put("type", "SMS");
	    params.put("text", "[TEST] ������ȣ��" + "["+randomNumber+"]" + "�Դϴ�."); // ���� ���� �Է�
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
	
}
