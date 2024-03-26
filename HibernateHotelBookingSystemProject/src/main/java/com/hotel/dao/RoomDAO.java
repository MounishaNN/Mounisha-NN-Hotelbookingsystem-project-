package com.hotel.dao;

import java.util.List;

import com.hotel.entities.Room;

public interface RoomDAO {

	void insert(Room crobj);

	List<Room> Display();

	public Room getbyroomid(int roomid);

}
