package main.java;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class UserLogTimeDetails {

	public String getUserInput() {

		Calendar calendar = Calendar.getInstance();

		// Construct current time in hh:mm format
		String currTime = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":"
				+ String.valueOf(calendar.get(Calendar.MINUTE));

		calendar.add(Calendar.MINUTE, -30);

		// Construct half an hour ago time in hh:mm format
		String halfHourBefore = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":"
				+ String.valueOf(calendar.get(Calendar.MINUTE));

		String userInputComment = JOptionPane
				.showInputDialog("What did you do from (" + halfHourBefore + ") to (" + currTime + ") : ");

		return userInputComment;
	}

}
