package com.tdinh.interview.digio;

/**
 * This App reads a log file of http traffic in predefined format and calculate
 * the following stats: (1) Number of unique IP address, (2) The top 3 most
 * visited URL and (3) The top 3 most active IP addresses
 *
 */
public class WebStatApp {

	public static void main(String[] args) {

		if (args.length < 1) {
			System.err.println("Invalid number of argument. Please supply log file. Aborting...");
			return;
		}

		String fileName = args[0];

		WebStatGenerator generator = new WebStatGenerator(fileName);
		System.out.println("Web traffic statistics:");
		System.out.println("Number of Unique IP addresses:" + generator.getNumberOfUniqueIp());
		System.out.println("Top 3 active IPs - (including all IPs with same rank) :");
		for (String ip : generator.getTop3ActiveIps()) {
			System.out.println(ip + " - count = " + generator.getIpFrequency(ip));
		}
		System.out.println("==============");
		System.out.println("Top 3 most visited url - (including all urls with same rank) :");
		for (String url : generator.getTop3MostVisitedUrls()) {
			System.out.println(url + " - count = " + generator.getUrlFrequency(url));
		}
		System.out.println("COMPLETED!!!");
	}
}
