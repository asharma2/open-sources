package com.airtel.assigment.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.airtel.assigment.exception.ApplicationException;
import com.airtel.assigment.exception.ProcessException;
import com.airtel.assigment.model.Record;

public class CommonWordServiceImpl implements CommonWordService {

	int[][] hash = new int[100][100];
	String[] commons = new String[100];

	private RecordConverterService recordConverterService = new RecordConverterService();

	@Override
	public String[] retrieve(File file) throws ApplicationException {
		return retrieve(file.toPath());
	}

	@Override
	public String[] retrieve(Path path) throws ApplicationException {
		if (!path.toFile().exists())
			throw new ApplicationException("File does not exists" + path.toString());
		try {
			/**
			 * Fetch all the files
			 */
			List<File> files = Files.walk(path).filter(Files::isRegularFile).map(Path::toFile)
					.collect(Collectors.toList());
			Record[] records = new Record[files.size()];
			int count = 0;
			for (File f : files) {
				records[count++] = recordConverterService.convert(f.toPath());
			}
			/**
			 * Processor all the files
			 */
			int[] hashValues = hash[0];
			int[] hashCount = hash[1];
			int iCount = 0;
			for (Record record : records) {
				processors().forEach(p -> {
					try {
						p.process(record);
					} catch (ProcessException e) {
						System.err.println(e);
					}
				});

				for (String wrd : record.words()) {
					int hash = wrd.hashCode();
					int idx = findIndex(hashValues, hash);
					if (idx != -1) {
						hashValues[idx] = hash;
						hashCount[idx] = ++hashCount[idx];
						this.commons[idx] = wrd;
					} else {
						hashValues[iCount] = hash;
						hashCount[iCount] = ++hashCount[iCount];
						iCount += 1;
					}
				}
			}
			return this.commons;
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
	}

	private int findIndex(int[] hashValues, int hash) {
		for (int i = 0; i < hashValues.length; i++) {
			if (hash == hashValues[i]) {
				return i;
			}
		}
		return -1;
	}

	public List<Processor<Record>> processors() {
		List<Processor<Record>> processors = new LinkedList<>();
		processors.add(new LowerCaseProcessor());
		processors.add(new SpecialCharacterProcessor());
		processors.add(new StopProcessor());
		return processors;
	}

}
