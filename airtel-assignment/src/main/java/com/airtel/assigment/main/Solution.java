package com.airtel.assigment.main;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

import com.airtel.assigment.service.CommonWordService;
import com.airtel.assigment.service.CommonWordServiceImpl;
import com.airtel.assigment.utils.AssignmentUtils;

public class Solution {

	private final static Logger logger = Logger.getLogger(Solution.class);

	public static void main(String[] args) throws Exception {
		logger.info("Going to process the find common words started");
		String path = "/home/atul/airtel";
		Path fPath = Paths.get(path);
		CommonWordService cws = new CommonWordServiceImpl();
		String commons[] = cws.retrieve(fPath);
		for (String common : commons) {
			if (AssignmentUtils.isNotEmpty(common)) {
				System.out.println(common);
			}
		}
		logger.info("Going to process the find common words completed");
	}
}
