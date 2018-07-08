package board.show.controller;

import board.show.model.service.ShowService;

public class ShowPointgrade {

	public int getShowPointgrade(String showId) {
		ShowService ss = new ShowService();
		int point = ss.getPointgrade(showId);
		
		return point;
	}
	

}
