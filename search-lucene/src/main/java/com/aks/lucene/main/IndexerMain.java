package com.aks.lucene.main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import com.aks.lucene.exception.LuceneException;

public class IndexerMain {

	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			throw new LuceneException("Please run command with index directory and source directory");
		}

		String iDirectory = args[0];
		String sDirectory = args[1];

		Path indexDirectory = new File(iDirectory).toPath();
		Path sourceDirectory = new File(sDirectory).toPath();

		if (!sourceDirectory.toFile().exists()) {
			throw new LuceneException("Source directory does not exists");
		}

		if (!indexDirectory.toFile().exists()) {
			Files.createDirectories(indexDirectory);
		}

	}
}
