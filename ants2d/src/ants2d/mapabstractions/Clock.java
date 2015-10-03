package ants2d.mapabstractions;

import java.util.WeakHashMap;

public class Clock {
	private WeakHashMap<ChangesWithTime,Integer> clients;
	private static Clock singleton;
	
	public static Clock getClock() {
		if (singleton == null) singleton = new Clock();
		return singleton;
	}
	private Clock() {
		clients = new WeakHashMap<ChangesWithTime,Integer>();
	}
	
	public static void tick() {
		Clock clock = Clock.getClock();
		 for(Object x : clock.getClients().keySet()) {
			((ChangesWithTime)x).timeStep();
			if (((ChangesWithTime)x).isOver()) clock.remove((ChangesWithTime)x);
		}
	}

	private WeakHashMap<ChangesWithTime,Integer> getClients() {
		return clients;
	}
	public void remove(ChangesWithTime x) {
		clients.remove(x);
	}
	public void add(ChangesWithTime x) {
		clients.put(x, 1);
	}

}
