package ra.model;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus = true;
    private static int count = 1;
    Scanner scanner = new Scanner(System.in);

    public DecimalFormat format = new DecimalFormat("###,###,###");
    public Book(){
        this.bookId = Book.count++;
    }
    public Book(String bookName, String author, String descriptions, double importPrice, double exportPrice){
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
        this.bookId = Book.count++;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public void inputData(){
        System.out.println("--------Thêm mới sách----------");

        while (true){
            System.out.println("Nhập tên sách : ");
            String name = scanner.nextLine();
            if (name.trim().length() > 1){
                this.bookName = name;
                break;
            }
            System.out.println("Không được để trống");
        }
        while (true){
            System.out.println("Nhập tên tác giả : ");
            String authorName = scanner.nextLine();
            if (authorName.trim().length() > 1){
                this.author = authorName;
                break;
            }
            System.out.println("Không được để trống");
        }
        while (true){
            System.out.println("Nhập mô tả : ");
            String des = scanner.nextLine();
            if (des.trim().length() > 9){
                this.descriptions = des;
                break;
            }
            System.out.println("Mô tả ít nhất 10 kí tự");
        }
        while (true){
            System.out.println("Giá nhập : ");
            this.importPrice = Double.parseDouble(scanner.nextLine());
            if (this.importPrice > 0){
                break;
            }
        }
        while (true){
            System.out.println("Giá xuất : ");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
            if (this.exportPrice / this.importPrice > 1.2){
                break;
            }
        }

        this.interest = (float) (this.exportPrice - this.importPrice);

    }
    public boolean getBookStatus(){
        return this.bookStatus;
    }
    public void displayData() {
        System.out.println(
                          "Id: " + this.bookId + "; \n"
                        + "Tên sách: " + this.bookName + "; \n"
                        + "Tên tác giả: " + this.author + "; \n"
                        + "Mô tả: " + this.descriptions + "; \n"
                        + "Giá mua: " + format.format(this.importPrice) + "; \n"
                        + "Giá bán: " + format.format(this.exportPrice) + "; \n"
                        + "Lợi nhuận: " + format.format(this.interest) + "; \n"
                        + "Trạng thái: " + (this.bookStatus ? "Bán." : "Không bán.")
        );
    }
}
