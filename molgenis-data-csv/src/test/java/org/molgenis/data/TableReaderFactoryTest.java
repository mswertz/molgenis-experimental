//package org.molgenis.data;
//
//import static org.testng.Assert.assertNotNull;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.util.Arrays;
//import java.util.zip.ZipException;
//
//import org.apache.commons.io.FilenameUtils;
//import org.molgenis.data.ReadonlyRepository;
//import org.molgenis.data.RepositoryCollection;
//import org.molgenis.data.TableCollectionReaderFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class TableReaderFactoryTest
//{
//	private static File ZIP_FILE;
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws URISyntaxException, ZipException, IOException
//	{
//		ZIP_FILE = File.createTempFile("file", ".zip");
//		FileOutputStream fos = new FileOutputStream(ZIP_FILE);
//		try
//		{
//			fos.write(new byte[]
//			{ 0x50, 0x4B, 0x03, 0x04, 0x14, 0x00, 0x00, 0x00, 0x08, 0x00, 0x32, 0x40, 0x28, 0x42, (byte) 0xAC, 0x50,
//					(byte) 0xD0, 0x75, 0x12, 0x00, 0x00, 0x00, 0x14, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x00, 0x30,
//					0x2E, 0x63, 0x73, 0x76, 0x4B, (byte) 0xCE, (byte) 0xCF, 0x31, (byte) 0xD4, 0x01, 0x12, 0x46,
//					(byte) 0xBC, 0x5C, 0x65, (byte) 0x89, 0x40, 0x26, (byte) 0x90, 0x30, 0x02, 0x00, 0x50, 0x4B, 0x03,
//					0x04, 0x14, 0x00, 0x00, 0x00, 0x08, 0x00, 0x39, 0x40, 0x28, 0x42, (byte) 0xB5, 0x61, 0x7A,
//					(byte) 0xEA, 0x12, 0x00, 0x00, 0x00, 0x14, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x00, 0x31, 0x2E,
//					0x63, 0x73, 0x76, 0x4B, (byte) 0xCE, (byte) 0xCF, 0x31, (byte) 0xD6, 0x01, 0x12, 0x26, (byte) 0xBC,
//					0x5C, 0x65, (byte) 0x89, 0x40, 0x26, (byte) 0x90, 0x30, 0x01, 0x00, 0x50, 0x4B, 0x03, 0x04, 0x14,
//					0x00, 0x00, 0x00, 0x08, 0x00, 0x47, 0x40, 0x28, 0x42, 0x60, (byte) 0xBB, (byte) 0xC8, (byte) 0xB0,
//					0x11, 0x00, 0x00, 0x00, 0x13, 0x00, 0x00, 0x00, 0x05, 0x00, 0x00, 0x00, 0x32, 0x2E, 0x74, 0x73,
//					0x76, 0x4B, (byte) 0xCE, (byte) 0xCF, 0x31, (byte) 0xE5, 0x04, 0x12, 0x66, 0x5C, 0x65, (byte) 0x89,
//					0x40, 0x16, (byte) 0x90, 0x30, 0x03, 0x00, 0x50, 0x4B, 0x01, 0x02, 0x3F, 0x00, 0x14, 0x00, 0x00,
//					0x00, 0x08, 0x00, 0x32, 0x40, 0x28, 0x42, (byte) 0xAC, 0x50, (byte) 0xD0, 0x75, 0x12, 0x00, 0x00,
//					0x00, 0x14, 0x00, 0x00, 0x00, 0x05, 0x00, 0x24, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x20,
//					0x20, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x30, 0x2E, 0x63, 0x73, 0x76, 0x0A, 0x00, 0x20, 0x00,
//					0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x18, 0x00, 0x3C, (byte) 0xC6, (byte) 0x84, (byte) 0xFE, 0x6D,
//					(byte) 0xED, (byte) 0xCD, 0x01, 0x7C, 0x51, 0x2B, (byte) 0xD8, 0x6D, (byte) 0xED, (byte) 0xCD,
//					0x01, 0x7C, 0x51, 0x2B, (byte) 0xD8, 0x6D, (byte) 0xED, (byte) 0xCD, 0x01, 0x50, 0x4B, 0x01, 0x02,
//					0x3F, 0x00, 0x14, 0x00, 0x00, 0x00, 0x08, 0x00, 0x39, 0x40, 0x28, 0x42, (byte) 0xB5, 0x61, 0x7A,
//					(byte) 0xEA, 0x12, 0x00, 0x00, 0x00, 0x14, 0x00, 0x00, 0x00, 0x05, 0x00, 0x24, 0x00, 0x00, 0x00,
//					0x00, 0x00, 0x00, 0x00, 0x20, 0x20, 0x00, 0x00, 0x35, 0x00, 0x00, 0x00, 0x31, 0x2E, 0x63, 0x73,
//					0x76, 0x0A, 0x00, 0x20, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x18, 0x00, (byte) 0xD0,
//					(byte) 0xB1, 0x53, 0x07, 0x6E, (byte) 0xED, (byte) 0xCD, 0x01, (byte) 0xF1, (byte) 0xF6,
//					(byte) 0xE0, (byte) 0xE1, 0x6D, (byte) 0xED, (byte) 0xCD, 0x01, (byte) 0xF1, (byte) 0xF6,
//					(byte) 0xE0, (byte) 0xE1, 0x6D, (byte) 0xED, (byte) 0xCD, 0x01, 0x50, 0x4B, 0x01, 0x02, 0x3F, 0x00,
//					0x14, 0x00, 0x00, 0x00, 0x08, 0x00, 0x47, 0x40, 0x28, 0x42, 0x60, (byte) 0xBB, (byte) 0xC8,
//					(byte) 0xB0, 0x11, 0x00, 0x00, 0x00, 0x13, 0x00, 0x00, 0x00, 0x05, 0x00, 0x24, 0x00, 0x00, 0x00,
//					0x00, 0x00, 0x00, 0x00, 0x20, 0x20, 0x00, 0x00, 0x6A, 0x00, 0x00, 0x00, 0x32, 0x2E, 0x74, 0x73,
//					0x76, 0x0A, 0x00, 0x20, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x18, 0x00, 0x58, 0x5C,
//					(byte) 0xB9, 0x15, 0x6E, (byte) 0xED, (byte) 0xCD, 0x01, (byte) 0xA0, 0x04, 0x36, (byte) 0xE3,
//					0x6D, (byte) 0xED, (byte) 0xCD, 0x01, (byte) 0xA0, 0x04, 0x36, (byte) 0xE3, 0x6D, (byte) 0xED,
//					(byte) 0xCD, 0x01, 0x50, 0x4B, 0x05, 0x06, 0x00, 0x00, 0x00, 0x00, 0x03, 0x00, 0x03, 0x00, 0x05,
//					0x01, 0x00, 0x00, (byte) 0x9E, 0x00, 0x00, 0x00, 0x00, 0x00 });
//		}
//		finally
//		{
//			fos.close();
//		}
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws URISyntaxException, ZipException, IOException
//	{
//		ZIP_FILE.delete();
//	}
//
//	@Test
//	public void createFile_csv() throws IOException
//	{
//		File file = File.createTempFile("file", ".csv");
//		try
//		{
//			RepositoryCollection tableReader = TableCollectionReaderFactory.create(file);
//			try
//			{
//				assertNotNull(tableReader.getRepository(FilenameUtils.getBaseName(file.getName())));
//			}
//			finally
//			{
//				tableReader.close();
//			}
//		}
//		finally
//		{
//			file.delete();
//		}
//	}
//
//	@Test
//	public void createFile_txt() throws IOException
//	{
//		File file = File.createTempFile("file", ".txt");
//		try
//		{
//			RepositoryCollection tableReader = TableCollectionReaderFactory.create(file);
//			try
//			{
//				assertNotNull(tableReader.getRepository(FilenameUtils.getBaseName(file.getName())));
//			}
//			finally
//			{
//				tableReader.close();
//			}
//		}
//		finally
//		{
//			file.delete();
//		}
//	}
//
//	@Test
//	public void createFile_tsv() throws IOException
//	{
//		File file = File.createTempFile("file", ".tsv");
//		try
//		{
//			RepositoryCollection tableReader = TableCollectionReaderFactory.create(file);
//			try
//			{
//				assertNotNull(tableReader.getRepository(FilenameUtils.getBaseName(file.getName())));
//			}
//			finally
//			{
//				tableReader.close();
//			}
//		}
//		finally
//		{
//			file.delete();
//		}
//	}
//
//	@Test
//	public void createFile_zip() throws IOException, URISyntaxException
//	{
//		RepositoryCollection<?> tableReader = TableCollectionReaderFactory.create(ZIP_FILE);
//		try
//		{
//			assertNotNull(tableReader.getRepository("0"));
//			assertNotNull(tableReader.getRepository("1"));
//			assertNotNull(tableReader.getRepository("2"));
//		}
//		finally
//		{
//			tableReader.close();
//		}
//	}
//
//	@Test(expectedExceptions = IOException.class)
//	public void createFile_unknownFormat() throws IOException
//	{
//		File file = File.createTempFile("file", ".burp");
//		try
//		{
//			RepositoryCollection tableReader = TableCollectionReaderFactory.create(file);
//			try
//			{
//				assertNotNull(tableReader.getRepository(FilenameUtils.getBaseName(file.getName())));
//			}
//			finally
//			{
//				tableReader.close();
//			}
//		}
//		finally
//		{
//			file.delete();
//		}
//	}
//
//	@Test
//	public void createListFile() throws IOException
//	{
//		File file1 = File.createTempFile("file1", ".csv");
//		File file2 = File.createTempFile("file2", ".tsv");
//		try
//		{
//			RepositoryCollection tableReader = TableCollectionReaderFactory.create(Arrays.asList(file1, file2));
//			try
//			{
//				assertNotNull(tableReader.getRepository(FilenameUtils.getBaseName(file1.getName())));
//				assertNotNull(tableReader.getRepository(FilenameUtils.getBaseName(file2.getName())));
//			}
//			finally
//			{
//				tableReader.close();
//			}
//		}
//		finally
//		{
//			file1.delete();
//			file2.delete();
//		}
//	}
//}
