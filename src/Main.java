import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
	public String[] parseDetails(String word) {
		int author_index = word.indexOf("Author");
		int Publisher_index = word.indexOf("Publisher");
		int Keywords_index = word.indexOf("Keywords");
		int Pages_index = word.indexOf("Pages");
		int Published_index = word.indexOf("Published");
		int Language_index = word.indexOf("Language");
		int Category_index = word.indexOf("Category");
		int ISBN_10_index = word.indexOf("ISBN-10");
		int ISBN_13_index = word.indexOf("ISBN-13");
		int Binding_index = word.indexOf("Binding");
		int List_Price_index = word.indexOf("List Price");
		int Rating_index = word.indexOf("Rating");
		String author = word.substring(author_index + 7, Publisher_index);
		System.out.println("Author :" + author);
		String publisher = word.substring(Publisher_index + 9, Keywords_index);
		System.out.println("Publisher :" + publisher);
		String keywords = word.substring(Keywords_index + 8, Pages_index);
		System.out.println("Keywords :" + keywords);
		String pages = word.substring(Pages_index + 7, Published_index);
		System.out.println("Pages :" + pages);
		String published = word.substring(Published_index + 9, Language_index);
		System.out.println("Publisher :" + published);
		String language = word.substring(Language_index + 8, Category_index);
		System.out.println("Language :" + language);
		String category = word.substring(Category_index + 8, ISBN_10_index);
		System.out.println("Category :" + category);
		String isbn10 = word.substring(ISBN_10_index + 7, ISBN_13_index);
		System.out.println("ISBN 10 :" + isbn10);
		String isbn13 = word.substring(ISBN_13_index + 7, Binding_index);
		System.out.println("ISBN 13 :" + isbn13);
		String binding = word.substring(Binding_index + 7, List_Price_index);
		System.out.println("Binding :" + binding);
		String list_price = word.substring(List_Price_index + 10, Rating_index);
		System.out.println("List Price :" + list_price);
		String rating = word.substring(Rating_index + 6, word.length());
		System.out.println("Rating :" + rating);
		return null;

	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		System.out.println("Enter file path including File Name.");
		Scanner s1 = new Scanner(System.in);
		String input_file_name = s1.next();
		if (input_file_name.length() == 0) {
			System.out.println("Input: Wrong file name or File not found. Exiting.....");
			System.exit(1);
		}
		InputStream inp = new FileInputStream(input_file_name);
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
		// int i = 0;
		File file;
		System.out.println(
				"Create an Excel File to store Output data and Enter Outputfile Name.Name must end with extension XLSX.");
		String opfilename = extracted().next();
		if (opfilename.length() == 0) {
			System.out.println("Output: Wrong file name or File not found. Exiting.....");
			System.exit(1);
		}
		System.out.println("Enter Starting Point:");
		Scanner s3 = new Scanner(System.in);
		int i = s3.nextInt() - 1;
		file = new File(opfilename);
		FileInputStream fIP = new FileInputStream(file);
		// Get the workbook instance for XLSX file
		XSSFWorkbook workbook = new XSSFWorkbook(fIP);
		if (file.isFile() && file.exists()) {
			// System.out.println("file open successfully.");
		} else {
			System.out.println("Error opening file.");
		}
		// XSSFSheet s = workbook.createSheet("Sheet01");
		XSSFSheet s = workbook.getSheetAt(0);
		while (sheet.getRow(i) != null) {
			Row row1 = sheet.getRow(i);
			Cell cell = row1.getCell(0);
			if (cell != null) {
				System.out.println(i + 1 + " : Processing " + cell.getStringCellValue());
				String isbn = cell.getStringCellValue();
				String url = "http://openisbn.com/isbn/" + cell.getStringCellValue() + "/";
				// String url = "http://openisbn.com/isbn/" + "0072338849KK" +
				// "/";
				Document doc = null;
				try {
					doc = Jsoup.connect(url)
							.userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:46.0) Gecko/20100101 Firefox/46.0")
							.timeout(100000).get();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
				// System.out.println(doc.title());
				Element data_div = doc.select("div.PostContent").first();
				Element image = data_div.getElementsByTag("img").first();
				String book_title = image.attr("title");
				String book_image_url = image.attr("src");
				// System.out.println("Book Title :" + book_title);
				// System.out.println("Book Image Url :" + book_image_url);
				// m.parseDetails(data_div.text());
				Book book = new Book(data_div.text());
				Row rowop = s.createRow(i);
				rowop.createCell(0).setCellValue(isbn);
				rowop.createCell(1).setCellValue(book_title);
				// System.out.println("Author : " + book.getAuthor());
				rowop.createCell(2).setCellValue(book.getAuthor());
				// System.out.println("Publisher : " + book.getPublisher());
				rowop.createCell(3).setCellValue(book.getPublisher());
				// System.out.println("Keywords : " + book.getKeywords());
				rowop.createCell(4).setCellValue(book.getKeywords());
				// System.out.println("Pages : " + book.getPages());
				rowop.createCell(5).setCellValue(book.getPages());
				// System.out.println("Published : " + book.getPublished());
				rowop.createCell(6).setCellValue(book.getPublished());
				// System.out.println("Language : " + book.getLanguage());
				rowop.createCell(7).setCellValue(book.getLanguage());
				// System.out.println("Category : " + book.getCategory());
				rowop.createCell(8).setCellValue(book.getCategory());
				// System.out.println("ISBN-10 : " + book.getIsbn_10());
				rowop.createCell(9).setCellValue(book.getIsbn_10());
				// System.out.println("ISBN-13 : " + book.getIsbn_13());
				rowop.createCell(10).setCellValue(book.getIsbn_13());
				// System.out.println("Binding : " + book.getBinding());
				rowop.createCell(11).setCellValue(book.getBinding());
				// System.out.println("List Price : " + book.getList_price());
				rowop.createCell(12).setCellValue(book.getList_price());
				rowop.createCell(13).setCellValue(book_image_url);

				FileOutputStream out = new FileOutputStream(opfilename, true);
				workbook.write(out);
				out.close();

				System.out.println(isbn + " is Done.");
			}
			i++;
			// break;
		}

	}

	private static Scanner extracted() {
		return new Scanner(System.in);
	}

}