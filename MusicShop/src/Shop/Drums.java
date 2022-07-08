package Shop;



public class Drums extends Products {

        public void drumsMain() {

                System.out.println("Press 1 for brands");
                System.out.println("Press 2 for colors");
                System.out.println("Press 3 to add to cart");
                System.out.println("Press 4 for cart");
                System.out.println("Press 5 to go back");
        }
}
//public int choice() {
//        while (true) {
//        switch (choice()) {
//
//        case 1:  getBrand();
//        System.out.println("Choose a brand:");
//        System.out.println("Press 1 for Fender");
//        System.out.println("Press 2 for Jackson");
//        System.out.println("Press 3 for Ibanez");
//        System.out.println("Press 4 for ESP");
//        System.out.println("Press 5 to get back");
//
//        case  2:
//        while (true) {
//        int color = Integer.parseInt(getColor());
//
//        System.out.println("Choose a brand:");
//        System.out.println("Press 1 for Green");
//        System.out.println("Press 2 for Black");
//        System.out.println("Press 3 for Yellow");
//        System.out.println("Press 4 for White");
//        System.out.println("Press 5 for Purple");
//        break;
//
//        }
//        case 3:
//        System.out.println("Added to cart");
//        break;
//
//        case 4:
//        System.out.println("Cart Menu:");
//        break;
//
//        case 5:
//        Main main = new Main();
//        main.getClass();
//        break;
//
//default:
//        System.out.println("Error: Press 1 - 5");
//        }
//        }
//        }
//        }