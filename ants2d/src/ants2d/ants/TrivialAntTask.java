package ants2d.ants;

import ants2d.geometry.Offset;

public interface TrivialAntTask {
	TrivialAntTask nextTask();
	Offset newDirection();
}
