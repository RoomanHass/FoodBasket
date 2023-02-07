import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println ("\nПродуктовая корзина.\n" +
                "Список товаров для покупки:\n");

        String[] prod = {"Пирожок", "Конфеты", "Сок", "Pepsi"};
        int[] price = {45, 20, 100, 150};
        int[] sum = {0, 0, 0, 0};
        int[] count = new int[4];
        int sumProduct = 0;
        int prodNum;
        int prodCount;

        for ( int i = 0 ; i < prod.length ; i++ ) {
            System.out.println ((i + 1) + " " + prod[i] + " " + price[i] + " руб/шт.");
        }

        while (true) {

            System.out.println ("Выберите товар и количество или введите \"end\".");
            String userProd = scan.nextLine ();
            if ( "end".equals (userProd) ) {
                break;
            }
            String[] read = userProd.split (" ");
            String currentProduct = read[0];
            prodNum = Integer.parseInt (currentProduct) - 1;

            if ( prodNum > prod.length ) {
                System.out.println ("Вы ввели неверный номер товара.");
                continue;
            }

            String currentQuantity = read[1];
            prodCount = Integer.parseInt (currentQuantity);
            sum[prodNum] = price[prodNum] * prodCount;
            count[prodNum] = prodCount;
        }
        System.out.println ("Вы приобрели : ");
        for ( int i = 0 ; i < prod.length ; i++ ) {

            if ( count[i] != 0 ) {
                System.out.println (prod[i] +
                        " : цена - " + price[i] + " руб/шт., количество - " +
                        count[i] + " шт., сумма - " + sum[i] + " руб.");
            }
            sumProduct += sum[i];
        }
        System.out.println ("общая цена " + sumProduct + " рублей.");
    }
}
