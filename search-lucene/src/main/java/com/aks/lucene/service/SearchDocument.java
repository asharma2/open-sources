package com.aks.lucene.service;

import java.nio.file.Path;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;

import com.aks.lucene.exception.LuceneException;

public interface SearchDocument {

	List<Document> search(Path indexDirectory, Analyzer analyzer, String field, String content) throws LuceneException;
}
