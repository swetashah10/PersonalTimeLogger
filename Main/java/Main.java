package main.java;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		UserLogTimeDetails userLogTimeDetails = new UserLogTimeDetails();

		// Add a timer every 30 minutes
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("Logging user time: ");
				if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 9
						&& Calendar.getInstance().get(Calendar.HOUR_OF_DAY) <= 24) {
					String userInput = userLogTimeDetails.getUserInput();

					if (null != userInput) {
						System.out.println(userInput);
						try {
							Quickstart.WriteExample(userInput);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {

						while (userInput == null) {
							System.out.println("Please enter the input again!");
							userInput = userLogTimeDetails.getUserInput();

							try {
								Quickstart.WriteExample(userInput);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				} else {
					System.out.println("Logic to terminate and shutdown...");
					// throw exception
					scheduledExecutorService.shutdown();
				}
			}
		}, 2, 5, TimeUnit.SECONDS);

		if (scheduledFuture.isDone()) {
			System.out.println("Our scheduler is now done! Closing all processes...");
			scheduledExecutorService.shutdown();
		}
		// Create a frame which can take input in form of text.

		// Upload this input in the time slot in excel sheet and save.

	}
}
