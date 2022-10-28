package com.jeju.reservation.service;

import java.util.List;

import com.jeju.pension.domain.Pension;
import com.jeju.reservation.domain.Reservation;
import com.jeju.room.domain.Room;

public interface ReservationService {

	void certifiedPhoneNumber(String userPhoneNumber, int randomNumber);

	int addReservation(Reservation reservation);

	Pension selectOneByPension(Integer pensionNo);

	Room selectOneByRoom(Integer roomNo);

}
