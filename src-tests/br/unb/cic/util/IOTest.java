package br.unb.cic.util;

import java.io.IOException;
import java.util.List;

<<<<<<< HEAD
import org.junit.Assert;
=======
import junit.framework.Assert;

>>>>>>> 795140d39878b41b6399d5c6ab3c3c3ab9fcf937
import org.junit.Test;

import br.unb.cic.sa.util.IO;

public class IOTest {

	@Test
	public void testListFiles(){
		try {
			List<String> files = IO.listFiles("src/br/unb/cic/sa/util", new String[]{"java"});
			Assert.assertEquals(5, files.size());
//			
//			Assert.assertTrue(files.contains("src/br/unb/cic/sa/util/Constants.java"));
//			Assert.assertTrue(files.contains("src/br/unb/cic/sa/util/IO.java"));
//			Assert.assertTrue(files.contains("src/br/unb/cic/sa/util/ReadCsv.java"));
//			Assert.assertTrue(files.contains("src/br/unb/cic/sa/util/WriteCsv.java"));
//			
			List<String> files = IO.listFiles("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util", new String[]{"java"});
			Assert.assertEquals(4, files.size());
			
			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/Constants.java"));
			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/IO.java"));
			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/ReadCsv.java"));
			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/WriteCsv.java"));
			
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	@Test
	public void testListFilesWithoutFilters() {
		try {
			List<String> files = IO.listFiles("src/br/unb/cic/sa/util", new String[]{});
			
			Assert.assertEquals(5, files.size());
			
//			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/Constants.java"));
//			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/IO.java"));
//			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/ReadCsv.java"));
//			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/WriteCsv.java"));
//			
			List<String> files = IO.listFiles("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util", new String[]{});
			
			Assert.assertEquals(4, files.size());
			
			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/Constants.java"));
			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/IO.java"));
			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/ReadCsv.java"));
			Assert.assertTrue(files.contains("/home/thiago/git/static-analysis/src/br/unb/cic/sa/util/WriteCsv.java"));
			
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	
}
