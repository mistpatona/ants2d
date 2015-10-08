package ants2d.mapabstractions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Clock {
	private Map<ChangesWithTime,Integer> clients;
	private static Clock singleton;
	
	public static Clock getClock() {
		if (singleton == null)
		synchronized(Clock.class) {
			if (singleton == null) singleton = new Clock();
		}
		return singleton;
	}
	private Clock() {
		clients = new WeakHashMap<ChangesWithTime,Integer>();
	}
	
	public static void tick() {
		Clock clock = Clock.getClock();
		 for(ChangesWithTime x : new ArrayList<ChangesWithTime>(clock.getClients().keySet())) {
			x.timeStep();
			if (x.isOver()) clock.remove(x);
		}
	}

	private /*WeakHash*/Map<ChangesWithTime,Integer> getClients() {
		return clients;
	}
	public synchronized void remove(ChangesWithTime x) {
		clients.remove(x);
	}
	public synchronized void add(ChangesWithTime x) {
		clients.put(x, 1);
	}
	
	public static int size() {
		return Clock.getClock().getClients().size();
	}

}
