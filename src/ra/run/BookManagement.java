package ra.run;

import ra.model.Book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BookManagement {
    static Scanner scanner =new Scanner(System.in);
    static Book[] books = new Book[100];
    static {
        books[0] = new Book("Hoa của quỷ", "Việt Cao Lãng", "1 trong những cuốn sách có doanh số cao hàng đầu", 20000, 60000);
        books[1] = new Book("Sách kinh thánh", "Nam Tài Tử", "Sách trừ tà hàng đầu hiện tay", 40000, 120000);
        books[2] = new Book("Bóng đêm", "Huy Bịp", "Siêu phẩm truyện ma bán chạy nhất", 30000, 90000);
    }
    static int currentIndex = 3;

    public static void main(String[] args) {
        while (true){
            System.out.println("---------MENU---------");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị tất cả sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo id");
            System.out.println("5. Tìm kiếm tên sách hoặc tìm theo mô tả");
            System.out.println("6. Thay đổi thông tin sách theo id");
            System.out.println("7. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addNewbook();
                    break;
                case 2:
                    showAllBooks();
                    break;
                case 3:
                    sortBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    editBook();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void addNewbook() {
        Book book = new Book();
        book.inputData();
        books[currentIndex++] = book;
        System.out.println("------Thêm sách thành công-------");
    }

    private static void showAllBooks() {
        System.out.println("Danh sách tất cả sách : ");
        for (int i = 0; i < currentIndex; i++) {
            books[i].displayData();
            System.out.println();
        }
        System.out.println("-----------------");
    }

    private static void sortBook() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = i + 1; j < currentIndex; j++) {
                if (books[i].getInterest() > books[j].getInterest()) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println("Sách đã được sắp xếp theo lợi nhuận tăng dần:");
        for (int i = 0; i < currentIndex; i++) {
            books[i].displayData();
        }
    }

    private static void deleteBook() {
        System.out.println("Nhập id sách muốn xóa : ");
        int deleteId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (deleteId == books[i].getBookId()){
                for (int j = i; j < currentIndex; j++) {
                    books[j] = books[j + 1];
                }
                System.out.println("--------Xóa sách thành công---------");
                currentIndex--;
                return;
            }
        }
        System.out.println("Không tìm thấy sách có id như trên");
    }

    private static void searchBook() {
        System.out.println("Nhập tên hoặc mô tả về sách : ");
        String searchValue = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm : ");
        boolean check = false;
        for (int i = 0; i < currentIndex; i++) {
            if (books[i].getBookName().contains(searchValue.trim()) || books[i].getDescriptions().contains(searchValue.trim())){
                books[i].displayData();
                System.out.println();
                check = true;
            }
        }
        if (!check){
            System.out.println("Không có thông tin về sách bạn tìm kiếm");
        }
    }

    private static void editBook() {
        System.out.println("Nhập id sách muốn sửa : ");
        int editId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentIndex; i++) {
            if (editId == books[i].getBookId()){
                books[i].inputData();
                System.out.println("-----Cập nhật thông tin sách thành công-----");
                return;
            }
        }
        System.out.println("Không tìm thấy sách có id như trên");
    }
}
