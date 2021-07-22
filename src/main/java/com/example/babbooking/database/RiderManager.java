package com.example.babbooking.database;

import java.util.HashMap;
import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.babbooking.exception.RiderAlreadyExistsException;
import com.example.babbooking.exception.RiderNotFoundException;
import com.example.babbooking.model.Rider;

@Service
public class RiderManager {

	Map<String, Rider> riders = new HashMap();

	public void createRider(@NonNull final Rider newRider) {
		if (riders.containsKey(newRider.getRiderId())) {
			throw new RiderAlreadyExistsException();
		}

		riders.put(newRider.getRiderId(), newRider);
	}

public Rider getRider(@NonNull final String riderId)
{
	if(!riders.containsKey(riderId))
	{
		throw new RiderNotFoundException();
	}
	
	return riders.get(riderId);
}
}
