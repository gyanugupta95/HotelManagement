package com.example.HotelManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.DTO.RoomDTO;
import com.example.HotelManagement.entity.Customer;
import com.example.HotelManagement.entity.Room;
import com.example.HotelManagement.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	public Room saveRoom(RoomDTO dto) {

		Room room = new Room();
		room.setRoomNumber(dto.getRoomNumber());
		room.setRoomType(dto.getRoomType());
		room.setPricePerNight(dto.getPricePerNight());
		room.setRoomStatus(dto.getRoomStatus());

		return roomRepository.save(room);
	}

	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	
	public Room getByIdRooms(Long roomId) {
		return roomRepository.findById(roomId).orElse(null);
	}
}
