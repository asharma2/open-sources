package com.aks.lucene.service;

import java.nio.file.Path;

import org.apache.lucene.analysis.Analyzer;

import com.aks.lucene.constants.SearchFiles;
import com.aks.lucene.exception.LuceneException;

public interface IndexerService {

	void doIndex(Path indexDirectory, Path sourceDirectory, Analyzer analyzer) throws LuceneException;

	SearchFiles searchFiles();
}
