public class LibrarySystem {
	// 변수 정의
	private LibraryBook[] booklist;
	private static int bookCount = 0;
	private static final int NUM_BOOK = 10;
	// 생성자 정의
	public LibrarySystem() {
		this.booklist = new LibraryBook[NUM_BOOK];
	}
	public void addBook(Book book) {
		booklist[bookCount++] = new LibraryBook(book);
	}
	
	public void removeBook(String title) {
		for ( int i = 0; i < bookCount; i++ ) {

			if ( booklist[i].getTitle().equals(title)) {
				
				for ( int j = i; j < bookCount - 1; j++ ) {
					booklist[j] = booklist[j+1];
				}
        
				booklist[--bookCount] = null;
				System.out.println("라이브러리에서 '" + title + "' 삭제했습니다.");
        
				return; 
			}
		}
		System.out.println("# 오류: '" + title + "' 못 찾았습니다!");
	}
	
	public void borrowBook(String title) {
        // `for` LibrarySystem의 모든 Book {
		for (int i = 0; i < bookCount; i++) {
            // `if` 책 제목이 발견되면 {
			if (booklist[i].getTitle().equals(title)) {
                // `if` 책이 있다면 {
				if (booklist[i].isAvailable()) {
                    // setAvailable을 false로 설정하고 메시지를 출력합니다.
					booklist[i].setAvailable(false);
					System.out.println("라이브러리에 '" + title + "' 추가했습니다.");
				// } `else` 책이 없다면 {
				} else {
					// 메시지를 인쇄하다
					System.out.println("# 오류: '" + title + "' 없습니다.");
					}
				// }
				return; // 책 제거 후 종료 방법
				}
			}
			// }
		// }
		// 찾을 수 없으면 메시지를 인쇄합니다.
		System.out.println("# 오류: '" + title + "' 못 찾았습니다!");
				}
	
	public void returnBook(String title) {
	    // `for` LibrarySystem의 모든 Book {
		for (int i = 0; i < bookCount; i++) {
            // `if` 책 제목이 발견되면 {
			if (booklist[i].getTitle().equals(title)) {
                // `if` 책이 없다면 {
				if (!booklist[i].isAvailable()) {
                    // setAvailable을 true로 설정하고 메시지를 출력합니다.
					booklist[i].setAvailable(true);
					System.out.println("'" + title + "'을 반납했습니다.");
				// } `else` 책이 있다면 {
				} else {
					System.out.println("이미 반납되었습니다.");
				// }
				}
				return; // 책 제거 후 종료 방법
			// }
				}
		// }
			}
		// 찾을 수 없으면 메시지를 인쇄합니다.
		System.out.println("# 오류: '" + title + "' 못 찾았습니다!");
	}
	
	public void displayAllBooks() {
		for (int i = 0; i < bookCount; i++) {
				LibraryBook book = booklist[i];
		        System.out.print(book.getIsbn() + " | ");
		        System.out.print(book.getTitle() + " | ");
		        System.out.print(book.getAuthor() + " | ");
		        System.out.print(book.getYear() + " | ");
		        System.out.println(book.isAvailable() ? "Available" : "Out");
			}
		}
	}
