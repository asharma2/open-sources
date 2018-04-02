package com.aks.lucene.search;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;

import com.aks.lucene.service.DocumentSearchService;
import com.aks.lucene.service.IndexService;
import com.aks.lucene.service.SearchService;
import com.aks.lucene.service.FileIndexService;

public class SearchLifecycle {

	public static void main(String[] args) throws Exception {
		String workspace = "/home/atul/hdd/repo/open-sources/search-lucene";
		Path indexDirectory = Paths.get("/tmp/lucene/1.0");
		Path sourceDirectory = Paths
				.get(workspace + File.separator + "src" + File.separator + "main" + File.separator + "resources");

		IndexService indexService = new FileIndexService();
		Analyzer analyzer = new StandardAnalyzer();
		indexService.doIndex(indexDirectory, sourceDirectory, analyzer, false);

		SearchService ss = new DocumentSearchService();
		List<Document> documents = ss.search(indexDirectory, analyzer, "contents", "English");
		for (Document document : documents) {
			String filename = document.get("filename");
			System.out.println("Filename: " + filename);
		}
	}
}
