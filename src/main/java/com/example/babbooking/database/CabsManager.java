package com.example.babbooking.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.babbooking.exception.CabAlreadyExistsException;
import com.example.babbooking.exception.CabNotFoundException;
import com.example.babbooking.model.Cab;
import com.example.babbooking.model.Location;

@Service
public class CabsManager {

	Map<String, Cab> cabs = new HashMap<>();

	public void createCab(@NonNull final Cab newCab) {
		if (cabs.containsKey(newCab.getCabId())) {
			throw new CabAlreadyExistsException();
		}

		cabs.put(newCab.getCabId(), newCab);

	}

	public Cab getCab(@NonNull final String cabId) {
		if (!cabs.containsKey(cabId)) {
			throw new CabNotFoundException();
		}

		return cabs.get(cabId);
	}

	public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {
		if (!cabs.containsKey(cabId)) {
			throw new CabNotFoundException();
		}
		cabs.get(cabId).setLocation(newLocation);
	}

	public void updateCabavalability(@NonNull final String cabId, @NonNull final Boolean newAvailability) {
		if (!cabs.containsKey(cabId)) {
			throw new CabNotFoundException();
		}

		cabs.get(cabId).setIsAvailable(newAvailability);

	}
	
	
	public List<Cab> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance)
	{
		List<Cab> result =  new ArrayList();
		for(Cab cab : cabs.values())
		{
			if(cab.getIsAvailable() && cab.getLocation().distance(fromPoint) <=distance)
			{
				result.add(cab);
			}
		}
		return result;
	}
	

}
