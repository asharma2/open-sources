package com.aks.lucene.service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import com.aks.lucene.exception.LuceneException;

public class DocumentSearchService implements SearchService {

	@Override
	public List<Document> search(Path indexDirectory, Analyzer analyzer, String field, String content)
			throws LuceneException {
		try {
			Query query = new QueryParser(field, analyzer).parse(content);
			IndexReader indexReader = DirectoryReader.open(FSDirectory.open(indexDirectory));
			IndexSearcher searcher = new IndexSearcher(indexReader);
			TopDocs topDocs = searcher.search(query, 10);
			List<Document> documents = new ArrayList<>();
			for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
				documents.add(searcher.doc(scoreDoc.doc));
			}
			return documents;
		} catch (Exception e) {
			throw new LuceneException(e);
		}
	}

}
