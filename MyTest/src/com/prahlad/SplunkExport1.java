package com.prahlad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.compress.utils.IOUtils;

import com.splunk.Event;
import com.splunk.JobExportArgs;
import com.splunk.MultiResultsReaderXml;
import com.splunk.SearchResults;
import com.splunk.Service;
import com.splunk.ServiceArgs;

public class SplunkExport1 {

	private static String query = "search index=\"msanniboyina_*\" sourcetype=\"ciphercloud_dlp\" | fields _raw _time | head 10 ";
	private static String folderName = "D:/spooldir/splunk/090318";

	public static void main(String[] args) throws IOException {
		Service service = connect();
		long start = System.currentTimeMillis();
		getExportResults(service);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: " + (end - start) + " mill seconds");
	}

	private static void getExportResults(Service service) throws IOException {
		// Set up a real-time export with a 30-second window
		JobExportArgs jobArgs = new JobExportArgs();
		jobArgs.setSearchMode(JobExportArgs.SearchMode.NORMAL);
		jobArgs.put("earliest_time", "2018-03-01T12:00:00.000");
		jobArgs.put("latest_time", "2018-03-08T12:00:00.000");
		jobArgs.setOutputMode(JobExportArgs.OutputMode.XML);

		int i = 0;
		String fileName = getFileName(folderName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		try (InputStream exportStream = service.export(query, jobArgs);) {
			// Create the job
			MultiResultsReaderXml multiResultsReader = new MultiResultsReaderXml(exportStream);
			int counterSet = 0;
			for (SearchResults searchResults : multiResultsReader) {
				System.out.println("Result set " + counterSet++ + " ********");
				int counterEvent = 0; // count the number of events in each set
				for (Event event1 : searchResults) {
					System.out.println("Event " + counterEvent++ + " --------");
						System.out.print("_time" + event1.get("_time"));
						System.out.println("_raw"+event1.get("_raw"));
				}
			}
			multiResultsReader.close();
		} finally {
			bw.flush();
			IOUtils.closeQuietly(bw);
		}
	}

	private static Service connect() {
		// Preparing splunk arguments
		ServiceArgs args = new ServiceArgs();
		args.setUsername("msanniboyina_user");
		args.setPassword("CipherCloud@123");
		args.setApp("CC4OBS_msanniboyina");
		args.setHost("localhost");
		args.setPort(8089);

		// Splunk connection
		Service service = Service.connect(args);
		return service;
	}

	/**
	 * @param folderName
	 * @return
	 */
	private static String getFileName(String folderName) {
		UUID uniqueId = UUID.randomUUID();
		String fileName = folderName.concat(File.separator).concat(uniqueId.toString()).concat(".log");
		return fileName;
	}

}
