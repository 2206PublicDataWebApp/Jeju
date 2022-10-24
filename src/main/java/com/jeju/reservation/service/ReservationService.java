package com.jeju.reservation.service;

import com.jeju.reservation.domain.Reservation;

public interface ReservationService {

	void certifiedPhoneNumber(String userPhoneNumber, int randomNumber);

	int addReservation(Reservation reservation);

}
