import java.util.regex.Pattern;

public class Book {
	private String author = "", publisher = "", keywords = "", pages = "", published = "", language = "", category = "",
			isbn_10 = "", isbn_13 = "", binding = "", list_price = "", rating = "";

	/*
	 * public Book(String word) { int author_index = 0, Publisher_index = 0,
	 * Keywords_index = 0, Pages_index = 0, Published_index = 0, Language_index
	 * = 0, ISBN_10_index = 0, Category_index = 0, ISBN_13_index = 0,
	 * Binding_index = 0, List_Price_index = 0, Rating_index = 0;
	 * 
	 * try { author_index = word.indexOf("Author"); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } try {
	 * Publisher_index = word.indexOf("Publisher"); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } try {
	 * Keywords_index = word.indexOf("Keywords"); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } try { Pages_index
	 * = word.indexOf("Pages"); } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } try { Published_index =
	 * word.indexOf("Published"); } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } try { Language_index =
	 * word.indexOf("Language"); } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } try { Category_index =
	 * word.indexOf("Category"); } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } try { ISBN_10_index =
	 * word.indexOf("ISBN-10"); } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } try { ISBN_13_index =
	 * word.indexOf("ISBN-13"); } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } try { Binding_index =
	 * word.indexOf("Binding"); } catch (Exception e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } try { List_Price_index = word.indexOf(
	 * "List Price"); } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } try { Rating_index = word.indexOf("Rating"); }
	 * catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } // Expecting that author can't be null if (true) {
	 * String author = word.substring(author_index + 7, Publisher_index); if
	 * (author.charAt(author.length() - 1) == ',') { StringBuilder str = new
	 * StringBuilder(author); str.setCharAt(author.length() - 1, ' '); author =
	 * str.toString(); author.trim(); } this.author = author; } if
	 * (Published_index != 0) { String publisher; try { publisher =
	 * word.substring(Publisher_index + 9, Keywords_index); } catch (Exception
	 * e) { publisher = word.substring(Publisher_index + 9, word.length() - 1);
	 * // TODO Auto-generated catch block e.printStackTrace(); } this.publisher
	 * = publisher; } if (Keywords_index != 0) { String keywords; try { keywords
	 * = word.substring(Keywords_index + 8, Pages_index); } catch (Exception e)
	 * { keywords = word.substring(Keywords_index + 8, word.length() - 1); //
	 * TODO Auto-generated catch block e.printStackTrace(); } this.keywords =
	 * keywords; } if (Pages_index != 0) { String pages; try { pages =
	 * word.substring(Pages_index + 7, Published_index); } catch (Exception e) {
	 * pages = word.substring(Pages_index + 7, word.length() - 1); // TODO
	 * Auto-generated catch block e.printStackTrace(); } this.pages = pages;
	 * 
	 * } if (Published_index != 0) { String published; try { published =
	 * word.substring(Published_index + 9, Language_index); } catch (Exception
	 * e) { published = word.substring(Published_index + 9, word.length() - 1);
	 * // TODO Auto-generated catch block e.printStackTrace(); } this.published
	 * = published; } if (Language_index != 0) { String language; try { language
	 * = word.substring(Language_index + 8, Category_index); } catch (Exception
	 * e) { language = word.substring(Language_index + 8, word.length() - 1); //
	 * TODO Auto-generated catch block e.printStackTrace(); } this.language =
	 * language; } if (Category_index != 0) { String category; try { category =
	 * word.substring(Category_index + 8, ISBN_10_index); } catch (Exception e)
	 * { category = word.substring(Category_index + 8, word.length() - 1); //
	 * TODO Auto-generated catch block e.printStackTrace(); } this.category =
	 * category; } if (ISBN_10_index != 0) { String isbn10; try { isbn10 =
	 * word.substring(ISBN_10_index + 7, ISBN_13_index); } catch (Exception e) {
	 * isbn10 = word.substring(ISBN_10_index + 7, word.length() - 1); // TODO
	 * Auto-generated catch block e.printStackTrace(); } this.isbn_10 = isbn10;
	 * } if (ISBN_13_index != 0) { String isbn13; try { isbn13 =
	 * word.substring(ISBN_13_index + 7, Binding_index); } catch (Exception e) {
	 * isbn13 = word.substring(ISBN_13_index + 7, word.length() - 1); // TODO
	 * Auto-generated catch block e.printStackTrace(); } this.isbn_13 = isbn13;
	 * } if (Binding_index != 0) { String binding; try { binding =
	 * word.substring(Binding_index + 7, List_Price_index); } catch (Exception
	 * e) { binding = word.substring(Binding_index + 7, word.length() - 1); //
	 * TODO Auto-generated catch block e.printStackTrace(); } this.binding =
	 * binding; } if (List_Price_index != 0) { String list_price; try {
	 * list_price = word.substring(List_Price_index + 10, Rating_index); } catch
	 * (Exception e) { list_price = word.substring(List_Price_index + 10,
	 * word.length() - 1); // TODO Auto-generated catch block
	 * e.printStackTrace(); } this.list_price = list_price; } if (Rating_index
	 * != 0) { String rating = word.substring(Rating_index + 6, word.length() -
	 * 1); this.rating = rating; }
	 * 
	 * }
	 */
	public Book(String book) {
		String booki = "";
		booki = book.replace("Publisher", "|Publisher").replace("Keywords", "|Keywords").replace("Pages", "|Pages")
				.replace("Published", "|Published").replace("Language", "|Language").replace("Category", "|Category")
				.replace("ISBN-10", "|ISBN-10").replace("ISBN-13", "|ISBN-13").replace("Binding", "|Binding")
				.replace("List Price", "|List Price").replace("Rating", "|Rating").replace("Author", "|Author");

//		System.out.println(booki);
		String[] splitted = booki.split(Pattern.quote("|"));
		// System.out.println("Length :" + splitted.length);
		for (int i = 0; i < splitted.length; i++) {
			String[] temp = null;
			try {
				temp = splitted[i].split(Pattern.quote(": "));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("Length :" + temp.length);
			// System.out.println("First :" + temp[0]);
			// System.out.println("Second :" + temp[1]);
			if (temp[0].equals("Author") || temp[0].equals("Authors")) {
				try {
					this.author = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("Publisher")) {
				try {
					this.publisher = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("Pages")) {
				try {
					this.pages = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("Keywords")) {
				try {
					this.keywords = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("Published")) {
				try {
					this.published = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("Language")) {
				try {
					this.language = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("Category")) {
				try {
					this.category = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("ISBN-10")) {
				try {
					this.isbn_10 = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("ISBN-13")) {
				try {
					this.isbn_13 = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("List Price")) {
				try {
					this.list_price = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("Rating")) {
				try {
					this.rating = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (temp[0].equals("Binding")) {
				try {
					this.binding = temp[1];
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getKeywords() {
		return keywords;
	}

	public String getPages() {
		return pages;
	}

	public String getPublished() {
		return published;
	}

	public String getLanguage() {
		return language;
	}

	public String getCategory() {
		return category;
	}

	public String getIsbn_10() {
		return isbn_10;
	}

	public String getIsbn_13() {
		return isbn_13;
	}

	public String getBinding() {
		return binding;
	}

	public String getList_price() {
		return list_price;
	}

	public String getRating() {
		return rating;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setIsbn_10(String isbn_10) {
		this.isbn_10 = isbn_10;
	}

	public void setIsbn_13(String isbn_13) {
		this.isbn_13 = isbn_13;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public void setList_price(String list_price) {
		this.list_price = list_price;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
