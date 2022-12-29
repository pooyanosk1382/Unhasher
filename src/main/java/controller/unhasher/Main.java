package controller.unhasher;

import java.util.Scanner;

public class Main{
    static Node root = new Node();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            showMenu();
            String c = in.next();
            switch (c) {
                case "1": {
                    System.out.print("enter your data : ");
                    String data = in.next();
                    addHash(data);
                    break;
                }
                case "2": {
                    System.out.print("enter your data : ");
                    String data = in.next();
                    searchHash(data);
                    break;
                }
                case "3":
                    return;
                default:
                    System.out.println("not available");
                    break;
            }
        }
    }

    private static void searchHash(String data) {
        root.trieSearch(root, data, 0);
    }

    private static void addHash(String data) {
        root.trieInsert(root, MD5.createHash(data), 0, data);
        System.out.println("Your hash value is : " + MD5.createHash(data));
        System.out.println("Your data has been added");
    }

    public static void showMenu() {
        System.out.println("=================");
        System.out.println("   1.add hash");
        System.out.println("   2.search hash");
        System.out.println("   3.exit");
        System.out.println("=================");
    }

}
