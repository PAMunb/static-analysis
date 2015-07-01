package br.unb.cic.sa.util;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class IOTest {

	@Test
	public void testListFiles() {
		try {
			List<String> files = IO
					.listFiles(
							"/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util",
							new String[] { "java" });
			Assert.assertEquals(5, files.size());

			Assert.assertTrue(files
					.contains("/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util/Constants.java"));
			Assert.assertTrue(files
					.contains("/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util/IO.java"));
			Assert.assertTrue(files
					.contains("/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util/ReadCsv.java"));
			Assert.assertTrue(files
					.contains("/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util/WriteCsv.java"));

		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

	}

//	@Test
//	public void testListFilesWithoutFilters() {
//		try {
//			List<String> files = IO
//					.listFiles(
//							"/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util",
//							new String[] {});
//
//			Assert.assertEquals(5, files.size());
//
//			Assert.assertTrue(files
//					.contains("/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util/Constants.java"));
//			Assert.assertTrue(files
//					.contains("/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util/IO.java"));
//			Assert.assertTrue(files
//					.contains("/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util/ReadCsv.java"));
//			Assert.assertTrue(files
//					.contains("/home/static-analysis/Documentos/static-analysis/src/br/unb/cic/sa/util/WriteCsv.java"));
//
//		} catch (IOException e) {
//			Assert.fail(e.getMessage());
//		}

//	}

}