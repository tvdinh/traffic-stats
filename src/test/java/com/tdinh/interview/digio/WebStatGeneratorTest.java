package com.tdinh.interview.digio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * Unit test class for {@link WebStatGenerator}
 * 
 * @author Tuan V. Dinh
 *
 */
public class WebStatGeneratorTest {

	@Test
	public void testDefaultInputLog() {
		WebStatGenerator generator = new WebStatGenerator(
				getClass().getClassLoader().getResource("programming-task-example-data.log").getFile());
		assertEquals(11, generator.getNumberOfUniqueIp());
		List<String> top3Ips = generator.getTop3ActiveIps();
		assertEquals("168.41.191.40", top3Ips.get(0));
		assertEquals("177.71.128.21", top3Ips.get(1));
		assertEquals("50.112.00.11", top3Ips.get(2));
		assertEquals("72.44.32.10", top3Ips.get(3));

		List<String> top3Urls = generator.getTop3MostVisitedUrls();
		assertEquals("/docs/manage-websites/", top3Urls.get(0));
	}

	@Test
	public void testWithDistinctCount() {
		WebStatGenerator generator = new WebStatGenerator(
				getClass().getClassLoader().getResource("test1.log").getFile());
		assertEquals(11, generator.getNumberOfUniqueIp());
		List<String> top3Ips = generator.getTop3ActiveIps();
		assertEquals("168.41.191.40", top3Ips.get(0));
		assertEquals("177.71.128.21", top3Ips.get(1));
		assertEquals("50.112.00.11", top3Ips.get(2));
		assertEquals(3, top3Ips.size());

		List<String> top3Urls = generator.getTop3MostVisitedUrls();
		assertEquals("http://example.net/faq/", top3Urls.get(0));
	}
}
