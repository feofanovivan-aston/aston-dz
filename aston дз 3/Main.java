public class Main {
    public static void main(String[] args) {
        System.out.println("PATTERN STRATEGY");
        testStrategy();
        
        System.out.println("\n PATTERN CHAIN OF RESPONSIBILITY");
        testChainOfResponsibility();
        
        System.out.println("\n PATTERN BUILDER");
        testBuilder();
        
        System.out.println("\n PATTERN PROXY");
        testProxy();
        
        System.out.println("\n PATTERN DECORATOR");
        testDecorator();
        
        System.out.println("\n PATTERN ADAPTER");
        testAdapter();
    }
    
    private static void testStrategy() {
        ShoppingCart cart = new ShoppingCart();
        
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart.checkout(100);
        
        cart.setPaymentStrategy(new BankTransferPayment("UA123456789"));
        cart.checkout(200);
        
        cart.setPaymentStrategy(null);
        cart.checkout(50);
    }
    
    private static void testChainOfResponsibility() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger fileLogger = new FileLogger(Logger.DEBUG);
        Logger consoleLogger = new ConsoleLogger(Logger.INFO);
        
        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        
        errorLogger.logMessage(Logger.INFO, "This is an information.");
        errorLogger.logMessage(Logger.DEBUG, "This is a debug level information.");
        errorLogger.logMessage(Logger.ERROR, "This is an error information.");
    }
    
    private static void testBuilder() {
        Computer gamingComputer = new Computer.ComputerBuilder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("RTX 4080")
            .build();
            
        Computer officeComputer = new Computer.ComputerBuilder()
            .setCPU("Intel i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();
            
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
    
    private static void testProxy() {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        
        image1.display();
        image1.display();
        image2.display();
    }
    
    private static void testDecorator() {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: " + simpleCoffee.getCost() + ", Description: " + simpleCoffee.getDescription());
        
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: " + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription());
        
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: " + sugarMilkCoffee.getCost() + ", Description: " + sugarMilkCoffee.getDescription());
    }
    
    private static void testAdapter() {
        MediaPlayer player = new MediaAdapter("mp4");
        player.play("mp4", "movie.mp4");
        
        player = new MediaAdapter("vlc");
        player.play("vlc", "movie.vlc");
    }
}