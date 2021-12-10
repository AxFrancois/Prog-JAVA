package model.world;

import java.util.Comparator;

import model.agents.Agent;

public class CoordComparator implements Comparator<Agent> {

	@Override
	public int compare(Agent o1, Agent o2) {
		// TODO Auto-generated method stub
		int ret = o1.getX() - o1.getX();
		if (ret == 0) {
			ret = o1.getY() - o2.getY();
		}
		return ret;
	}

}
