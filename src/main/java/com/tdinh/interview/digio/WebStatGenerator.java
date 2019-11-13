package com.tdinh.interview.digio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class generates web traffic stats from a log file.
 * 
 * @author Tuan V. Dinh
 *
 */
public class WebStatGenerator {

	private LogParser logParser;
	private List<String> ipAddresses;
	private List<String> urls;

	// Disable default constructor
	@SuppressWarnings("unused")
	private WebStatGenerator() {
	}

	public WebStatGenerator(String logFile) {
		this(new File(logFile));
	}

	public WebStatGenerator(File file) {
		this.logParser = new LogParser();
		this.ipAddresses = new ArrayList<String>();
		this.urls = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				ipAddresses.add(logParser.getIpAddress(line));
				urls.add(logParser.getUrl(line));
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			throw new ServiceException("Log file " + file.getName() + " not found. Aborting...");
		} catch (IOException e) {
			throw new ServiceException("I/O error procesing " + file.getName() + ".  Aborting...");
		}
	}

	public long getNumberOfUniqueIp() {
		Set<String> unique = getUniqueSet(ipAddresses);
		return unique.size();
	}

	public List<String> getTop3ActiveIps() {
		return getTop3FromList(ipAddresses);
	}

	public List<String> getTop3MostVisitedUrls() {
		return getTop3FromList(urls);
	}

	public long getIpFrequency(String ip) {
		return Collections.frequency(ipAddresses, ip);
	}

	public long getUrlFrequency(String url) {
		return Collections.frequency(urls, url);
	}

	private List<String> getTop3FromList(final List<String> list) {
		List<String> top3 = new ArrayList<String>();
		List<String> uniqueList = getUniqueList(list);
		int[] counts = new int[uniqueList.size()];
		for (int i = 0; i < uniqueList.size(); i++) {
			counts[i] = Collections.frequency(list, uniqueList.get(i));
		}

		int[] sortedCounts = Arrays.copyOf(counts, counts.length);
		Arrays.sort(sortedCounts);

		int topCount = 0;

		for (int j = sortedCounts.length; j > sortedCounts.length - 3; j--) {
			for (int k = 0; k < counts.length; k++) {
				if (counts[k] == sortedCounts[j - 1]) {
					top3.add(uniqueList.get(k));
					topCount++;
				}
			}
			if (topCount >= 3) {
				return top3;
			}
		}

		return top3;
	}

	private Set<String> getUniqueSet(List<String> list) {
		return new HashSet<String>(list);
	}

	private List<String> getUniqueList(List<String> list) {
		return list.stream().distinct().collect(Collectors.toList());
	}

}
