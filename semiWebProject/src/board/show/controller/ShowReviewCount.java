package board.show.controller;

import board.show.model.service.ShowService;

public class ShowReviewCount {
	
	public int getShowReviewCount(String showId) {
		int count = 0;
		
		ShowService ss = new ShowService();
		count = ss.getShowReviewCount(showId);
		
		return count; 
	}

}
