import java.util.Scanner;

public class String_calc {
    public static void main(String[] args) throws Exception {

        Reader.read();
        Operations.ops();
    }
    static class Reader {
        static String a, b, z;
        static void read() throws Exception {
            System.out.println("Input:");
            Scanner scan = new Scanner(System.in);

            if (scan.hasNextInt()) {
                throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка");
            }
            String str = scan.nextLine().trim();

            if (str.contains("-")) {

                String[] valArray = str.split(" - ");
                a = valArray[0];
                b = valArray[1];
                z = "-";
                if (!a.startsWith("\"") || !a.endsWith("\"") || !b.startsWith("\"") || !b.endsWith("\"") || a.length() > 12 || b.length() > 12) {
                    throw new Exception("Ошибка ввода данных");}}

            if(str.contains("+")) {
                String[] valArray = str.split(" ");
                a = valArray[0];
                b = valArray[2];
                z = valArray[1].trim();
                if (!a.startsWith("\"") || !a.endsWith("\"") || !b.startsWith("\"") || !b.endsWith("\"") || a.length() > 12 || b.length() > 12) {
                    throw new Exception("Ошибка ввода данных");}}

                if(str.contains("*")) {
                    String[] valArray = str.split(" ");
                    a = valArray[0];
                    b = valArray[2];
                    z = valArray[1].trim();
                if (!a.startsWith("\"") || !a.endsWith("\"") || b.startsWith("\"") || b.endsWith("\"") || a.length() > 12 || b.length() > 12) {
                throw new Exception("Ошибка ввода данных");}}

                if(str.contains("/")) {
                String[] valArray = str.split(" ");
                a = valArray[0];
                b = valArray[2];
                z = valArray[1].trim();
                if (!a.startsWith("\"") || !a.endsWith("\"") || b.startsWith("\"") || b.endsWith("\"") || a.length() > 12 || b.length() > 12) {
                    throw new Exception("Ошибка ввода данных");}}
        }

    }
    static class Operations extends Reader {
        static String c;
        static void ops() throws Exception {
                switch (z) {
                    case "+": c = a.replaceAll("\"", "") + b.replaceAll("\"", ""); break;
                    case "*":
                        if (b.matches("^[0-9]+$") && Integer.parseInt(b) >10) {
                            throw new Exception("Ошибка ввода данных");}
                        int x = Integer.parseInt(b);
                        c = a.replaceAll("\"","").repeat(x); break;
                    case "/":
                        if (b.matches("^[0-9]+$") && Integer.parseInt(b) >10) {
                            throw new Exception("Ошибка ввода данных"); }
                        int y = a.replaceAll("\"","").length() / Integer.parseInt(b);
                        c = a.replaceAll("\"","").substring(0, y); break;
                    case "-":
                        c = a.replaceAll("\"","").replace(b.replaceAll("\"",""), "").trim(); break;
                }
                System.out.println("Output:");
                if (c.length()>40) {
                    System.out.println('"' + c.substring(0,40) + "..."+'"');
                } else {
                    System.out.println('"' + c + '"');
                }
            }
        }
    }
