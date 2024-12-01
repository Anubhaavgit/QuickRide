package com.comrade.QuickRide.distance;

import com.comrade.QuickRide.entities.Coordinate;

public class Distance {
	
	public static double distanceCalculator(Coordinate location, Coordinate destination) {
		int x1 = location.getX();
		int x2 = destination.getX();
		int y1 = location.getY();
		int y2 = destination.getY();
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}
