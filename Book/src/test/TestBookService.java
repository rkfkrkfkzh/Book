package test;

import java.util.Scanner;

import service.BookDAO;
import vo.BookVO;

public class TestBookService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id;
		String title;
		String author;
		String publisher;
		int price;

		boolean flag = true;
		int i = 0;

		BookDAO service = new BookDAO();

		while (flag) {
			System.out.println("1.등록 2.명단확인 3.검색 4.수정 5.삭제 6.종료");
			i = sc.nextInt();

			switch (i) {

			case 1:
				System.out.println("제품번호를 입력 :");
				id = sc.next();
				System.out.println("제품명을 입력 :");
				title = sc.next();
				System.out.println("수량을 입력 :");
				author = sc.next();
				System.out.println("제조사 입력 :");
				publisher = sc.next();
				System.out.println("가격을 입력 :");
				price = sc.nextInt();

				service.bookinsert(null);
				break;
			case 2:
				System.out.println(service.bookselectAll());
				break;
			case 3:
				System.out.println("제품번호를 입력 :");
				id = sc.next();
				BookVO p = service.bookselect(id);
				System.out.println(p);
				break;
			case 4:
				System.out.println("제품번호를 입력 :");
				id = sc.next();
				System.out.println("수정할 제품명을 입력 :");
				title = sc.next();
				System.out.println("수정할 수량을 입력 :");
				author = sc.next();
				System.out.println("수정할 제조사 입력 :");
				publisher = sc.next();
				System.out.println("수정할 가격을 입력 :");
				price = sc.nextInt();

				BookVO m2 = new BookVO(id, title, author, publisher, i);
				service.bookupdate(m2);
				break;
			case 5:
				System.out.println("삭제할 id를 입력 :");
				id = sc.next();
				service.bookdelete();
				break;
			case 6:
				flag = false;
				break;
			}

		}

	}

}
