package com.aks.lucene.service;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.nio.file.Path;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.aks.lucene.constants.SearchFiles;
import com.aks.lucene.exception.LuceneException;

public class TextFileIndexService implements IndexerService {

	@Override
	public void doIndex(Path indexDirectory, Path sourceDirectory, Analyzer analyzer) throws LuceneException {
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		try (Directory directory = FSDirectory.open(indexDirectory);
				IndexWriter writer = new IndexWriter(directory, iwc)) {
			Document document = new Document();
			File sd = sourceDirectory.toFile();
			File txtFiles[] = sd.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.toLowerCase().endsWith(searchFiles().getExtn());
				}
			});
			for (File file : txtFiles) {
				FileReader fileReader = new FileReader(file);
				document.add(new TextField("contents", fileReader));
				document.add(new StringField("path", file.getPath(), Field.Store.YES));
				document.add(new StringField("filename", file.getName(), Field.Store.YES));
				writer.addDocument(document);
			}
		} catch (Exception e) {
			throw new LuceneException(e);
		}
	}

	@Override
	public SearchFiles searchFiles() {
		return SearchFiles.TXT;
	}

}
