package com.jeju.reservation.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeju.reservation.store.ReservationStore;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired 
	private ReservationStore aStore;
	@Autowired
	private SqlSession session;
}
