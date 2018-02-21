package com.aks.lucene.service;

import java.nio.file.Path;

import com.aks.lucene.exception.LuceneException;

public interface IndexerService {

	void applyIndex(Path indexDirectory, Path sourceDirectory) throws LuceneException;
}
