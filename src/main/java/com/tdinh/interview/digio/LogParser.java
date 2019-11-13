package com.tdinh.interview.digio;

/**
 * This class parses a single line of web traffic log and return a field of interest.
 * The parser assumes a certain format from the log line
 * @author Tuan V. Dinh
 */
public class LogParser {
	
	public String getIpAddress(String logEntry) throws ServiceException {
		try {
			String [] fields = logEntry.split(" ");
			return fields[0];
		} catch (Exception ex) {
			throw new ServiceException("Invalid format");
		}
	}
	
	public String getUrl(String logEntry) throws ServiceException {
		try {
			String [] fields = logEntry.split(" ");
			return fields[6];
		} catch(Exception ex) {
			throw new ServiceException("Invalid format");
		}	
	}
}
