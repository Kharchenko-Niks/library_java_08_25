package client;

import app.controller.BookController;
import app.controller.ReaderController;

import java.util.Scanner;

public class Client {
    private static BookController bookController;
    private static ReaderController readerController;
    private static Scanner scanner;

    public static void main(String[] args) {

        try {
            bookController = new BookController();
            readerController = new ReaderController();
            scanner = new Scanner(System.in);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        while (true){
            System.out.println("Выберите желаемую операцию");
            System.out.println("1 - Операция с книгами");
            System.out.println("2 - Операция с читателями");
            System.out.println("3 - выход");

            String input = scanner.nextLine();

            switch (input){
                case "1":
                    bookOperations();
                    break;
                case "2":
                    readerOperations();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
    }

    //ОПЕРАЦИИ С ЧИТАТЕЛЯМИ
    private static void readerOperations() {
            while (true){
                try {
                    System.out.println("Выберите операцию с читателями:");
                    System.out.println("1 - сохранить читателя");
                    System.out.println("2 - получить всех читателей");
                    System.out.println("3 - получить читателя по ID");
                    System.out.println("4 - удалить читателя по ID");
                    System.out.println("5 - назад");

                    String input = scanner.nextLine();
                    String id;
                    String name;

                    switch (input){
                        case "1":
                            System.out.println("Введите имя читателя:");
                            name = scanner.nextLine();
                            System.out.println(readerController.save(name));
                            break;
                        case "2":
                            readerController.getAll().forEach(System.out::println);
                            break;
                        case "3":
                            System.out.println("Введите ID:");
                            id = scanner.nextLine();
                            System.out.println(readerController.getById(id));
                            break;
                        case "4":
                            System.out.println("Введите ID читателя:");
                            id = scanner.nextLine();
                            readerController.deleteById(id);
                            break;
                        case "5":
                            return;
                        default:
                            System.out.println("Некорректный ввод!");

                    }
                }catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
    }

    //ОПЕРАЦИИ С КНИГАМИ
    private static void bookOperations() {
        while (true){
            try {
                System.out.println("Выберите операцию с книгами:");
                System.out.println("1 - сохранить книгу");
                System.out.println("2 - получить все книги");
                System.out.println("3 - получить книгу по ID");
                System.out.println("4 - удалить книгу по ID");
                System.out.println("5 - удалить книгу по названию");
                System.out.println("6 - восстановить книгу по ID");
                System.out.println("7 - количество книг");
                System.out.println("8 - назад");

                String input = scanner.nextLine();
                String id;
                String title;
                String author;

                switch (input){
                    case "1":
                        System.out.println("Введите название книги:");
                        title = scanner.nextLine();
                        System.out.println("Введите автора:");
                        author = scanner.nextLine();
                        System.out.println(bookController.save(title, author));
                        break;

                    case "2":
                        bookController.getALL().forEach(System.out::println);
                        break;

                    case "3":
                        System.out.println("Введите ID:");
                        id = scanner.nextLine();
                        System.out.println(bookController.getById(id));
                        break;

                    case "4":
                        System.out.println("Введите ID:");
                        id = scanner.nextLine();
                        bookController.deleteById(id);
                        break;

                    case "5":
                        System.out.println("Введите название:");
                        title = scanner.nextLine();
                        bookController.deleteByTitles(title);
                        break;

                    case "6":
                        System.out.println("Введите ID:");
                        id = scanner.nextLine();
                        bookController.restoreById(id);
                        break;

                    case "7":
                        System.out.println("Количество книг: "+ bookController.getBooksCount());
                        break;
                    case "8":
                        return;
                    default:
                        System.out.println("Некорректный ввод!");
                }

            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
}
