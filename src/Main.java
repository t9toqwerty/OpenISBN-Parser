import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

		InputStream inp = new FileInputStream("/home/rahul/eclipse/BookFarm5k.xlsx");
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheetAt(0);
		int i = 0;
		FileOutputStream out = new FileOutputStream("output.xlxs");
		Workbook wb1 = new HSSFWorkbook();
		Sheet s = wb1.createSheet("Sheet 1");
		while (sheet.getRow(i) != null) {
			Row row1 = sheet.getRow(i);
			Cell cell = row1.getCell(0);

			if (cell != null) {
				System.out.println(cell.getStringCellValue());
				String isbn = cell.getStringCellValue();
				String url = "http://openisbn.com/isbn/" + cell.getStringCellValue() + "/";
				Document doc = Jsoup.connect(url)
						.userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:46.0) Gecko/20100101 Firefox/46.0")
						.timeout(50000).get();
				System.out.println(doc.title());
				Element data_div = doc.select("div.PostContent").first();
				Element image = data_div.getElementsByTag("img").first();
				String book_title = image.attr("title");
				String book_image_url = image.attr("src");
				System.out.println("Book Title :" + book_title);
				System.out.println("Book Image Url :" + book_image_url);
				Main m = new Main();
				// m.parseDetails(data_div.text());
				Book book = new Book(data_div.text());
				Row rowop = sheet.getRow(i);
				rowop.createCell(0).setCellValue(isbn);
				rowop.createCell(1).setCellValue(book_title);
				rowop.createCell(2).setCellValue(book.getAuthor());
				rowop.createCell(3).setCellValue(book.getPublisher());
				rowop.createCell(4).setCellValue(book.getKeywords());
				rowop.createCell(5).setCellValue(book.getPages());
				rowop.createCell(6).setCellValue(book.getPublished());
				rowop.createCell(7).setCellValue(book.getLanguage());
				rowop.createCell(8).setCellValue(book.getCategory());
				rowop.createCell(9).setCellValue(book.getIsbn_10());
				rowop.createCell(10).setCellValue(book.getIsbn_13());
				rowop.createCell(11).setCellValue(book.getBinding());
				rowop.createCell(12).setCellValue(book.getList_price());
				rowop.createCell(13).setCellValue(book_image_url);
			}
			i++;
		}

	}

}
