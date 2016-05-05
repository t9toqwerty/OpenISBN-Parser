
public class Book {
	private String author, publisher, keywords, pages, published, language, category, isbn_10, isbn_13, binding,
			list_price, rating;

	public Book(String word) {
		int author_index = 0, Publisher_index = 0, Keywords_index = 0, Pages_index = 0, Published_index = 0,
				Language_index = 0, ISBN_10_index = 0, Category_index = 0, ISBN_13_index = 0, Binding_index = 0,
				List_Price_index = 0, Rating_index = 0;

		try {
			author_index = word.indexOf("Author");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Publisher_index = word.indexOf("Publisher");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Keywords_index = word.indexOf("Keywords");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Pages_index = word.indexOf("Pages");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Published_index = word.indexOf("Published");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Language_index = word.indexOf("Language");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Category_index = word.indexOf("Category");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ISBN_10_index = word.indexOf("ISBN-10");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ISBN_13_index = word.indexOf("ISBN-13");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Binding_index = word.indexOf("Binding");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List_Price_index = word.indexOf("List Price");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Rating_index = word.indexOf("Rating");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Expecting that author can't be null
		if (true) {
			String author = word.substring(author_index + 7, Publisher_index);
			if (author.charAt(author.length() - 1) == ',') {
				StringBuilder str = new StringBuilder(author);
				str.setCharAt(author.length() - 1, ' ');
				author = str.toString();
				author.trim();
			}
			this.author = author;
		}
		String publisher = word.substring(Publisher_index + 9, Keywords_index);
		String keywords = word.substring(Keywords_index + 8, Pages_index);
		String pages = word.substring(Pages_index + 7, Published_index);
		String published = word.substring(Published_index + 9, Language_index);
		String language = word.substring(Language_index + 8, Category_index);
		String category = word.substring(Category_index + 8, ISBN_10_index);
		String isbn10 = word.substring(ISBN_10_index + 7, ISBN_13_index);
		String isbn13 = word.substring(ISBN_13_index + 7, Binding_index);
		String binding = word.substring(Binding_index + 7, List_Price_index);
		String list_price = word.substring(List_Price_index + 10, Rating_index);
		String rating = word.substring(Rating_index + 6, word.length());

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
