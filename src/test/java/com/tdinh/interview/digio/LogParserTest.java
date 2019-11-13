package com.tdinh.interview.digio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test class for {@link LogParser}
 * 
 * @author Tuan V. Dinh
 *
 */
public class LogParserTest {

	private LogParser logParse = new LogParser();

	@Test
	public void testGetIpValidLog() {
		String logEntry = "177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] \"GET /intranet-analytics/ HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (X11; U; Linux x86_64; fr-FR) AppleWebKit/534.7 (KHTML, like Gecko) Epiphany/2.30.6 Safari/534.7\"";
		assertEquals("177.71.128.21", logParse.getIpAddress(logEntry));
	}

	@Test
	public void testGetUrlValid() {
		String logEntry = "177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] \"GET /intranet-analytics/ HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (X11; U; Linux x86_64; fr-FR) AppleWebKit/534.7 (KHTML, like Gecko) Epiphany/2.30.6 Safari/534.7\"";
		assertEquals("/intranet-analytics/", logParse.getUrl(logEntry));
	}
	
	@Test(expected=ServiceException.class)
	public void testGetUrlInvalid() {
		String logEntry = "177.71.128.21 - - [10/Jul/2018:22:21:28 +0200]";
		logParse.getUrl(logEntry);
	}
	
	@Test(expected=ServiceException.class)
	public void testGetIpInvalid() {
		String logEntry = null;
		logParse.getIpAddress(logEntry);
	}


}
