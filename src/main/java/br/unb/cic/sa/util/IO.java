package br.unb.cic.sa.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple class for handling IO
 * 
 * @author rbonifacio
 */
public class IO {
	
	public static String[] readLines(String filePath) throws IOException {
		return readLines(new File(filePath));
	}
	
	public static String[] readLines(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);

		List<String> lines = new ArrayList<String>();
		
		 String line = null;
		 // if no more lines the readLine() returns null
		 while ((line = br.readLine()) != null) {
		      lines.add(line);
		 }
		 br.close();
		 return lines.toArray(new String[lines.size()]);
	}

	/**
	 * Recursively, list all files in a given path that terminates with one of the 
	 * target extensions.
	 * 
	 * @param path the start point of the search
	 * @param extension used as a filter criteria.
	 * @return a list of files
	 * 
	 * @throws IOException if something goes wrong. 
	 */
	public static List<String> listFiles(String path, String[] extension) throws IOException {
		File f = new File(path.trim());
		List<String> files = new ArrayList<String>();
		
		if(f.isDirectory()) {
			for(String subFileName : f.list()) {
				File subFile = new File(f.getAbsolutePath() + File.separator + subFileName);
				if(!subFile.exists()) {
					continue;
				}
				if(subFile.isDirectory()) {
					files.addAll(listFiles(subFile.getAbsolutePath(), extension));
				}
				else {
					if(extension != null && extension.length > 0) {
						for(String e : extension) {
							if(subFileName.toLowerCase().endsWith("." + e.toLowerCase())) {
								files.add(subFile.getAbsolutePath());
								break;
							}
						}
					}
					else {
						files.add(subFile.getAbsolutePath());
					}
				}
			}
		}
		return files;		
	}
}
