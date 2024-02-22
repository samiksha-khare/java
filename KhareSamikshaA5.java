import java.util.Scanner;

class Vehicle {
    private String make;
    private String model;
    private int year;
    private String fuelType;
    private double price;

    Vehicle(String make, String model, int year, String fuelType, double price ) {
       this.setMake(make);
       this.setModel(model);
       this.setYear(year);
       this.setFuelType(fuelType);
       this.setPrice(price);
    }
    // Accessor methods
    public String getMake() { return this.make;}
    public String getModel() { return this.model; }
    public int getYear() { return this.year; }
    public String getFuelType() { return this.fuelType; }
    public double getPrice() { return this.price;}
    public void setMake(String make) { this.make = make;}
    public void setModel(String model) { this.model = model;}
    public void setYear(int year) { this.year = year;}
    public void setFuelType(String fuelType) { this.fuelType = fuelType;}
    public void setPrice(double price) { this.price = price;}




    public void printInfo() {
        System.out.println("Vehicle Information:");
        System.out.println("Make: " + this.getMake());
        System.out.println("Model: " + this.getModel());
        System.out.println("Year: " + this.getYear());
        System.out.println("Fuel Type: " + this.getFuelType());
        System.out.println("Price: $" + this.getPrice());
    }

}

class Motorcycle extends Vehicle {
    private int engineDisplacement;
    private boolean isOffRoad;

    public int getEngineDisplacement() {
        return this.engineDisplacement;
    }

    public boolean isOffRoad() {
        return this.isOffRoad;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public void setOffRoad(boolean offRoad) {
        this.isOffRoad = offRoad;
    }

    Motorcycle(String make, String model, int year, String fuelType, double price, int engineDisplacement, boolean isOffRoad) {
        super(make, model, year, fuelType, price);
        this.setEngineDisplacement(engineDisplacement);
        this.setOffRoad(isOffRoad);
    }

    public double calculateTax() {
        double tax = 0;
        if (this.getEngineDisplacement() < 500) {
            tax = 50;
        }
        else {
            tax = 100;
        }
        if (this.isOffRoad()) {
            tax *= (double) 50 / 100;
        }
        return tax;
    }
    public void printInfo() {
        System.out.println("\nMotorcycle Information:");
        super.printInfo();
        System.out.println("Engine Displacement: " + this.engineDisplacement + " cc");
        System.out.println("Is Off Road: " + this.isOffRoad);
    }
}

class Car extends Vehicle {
    private int numDoors;
    private double trunkCapacity;

    public int getNumDoors() {
        return this.numDoors;
    }

    public double getTrunkCapacity() {
        return this.trunkCapacity;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public void setTrunkCapacity(double trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }


    Car(String make, String model, int year, String fuelType, double price, int numDoors, double trunkCapacity) {
        super(make, model, year, fuelType, price);
        this.setNumDoors(numDoors);
        this.setTrunkCapacity(trunkCapacity);
    }

    public double calculateInsurance() {
        int premiumDoor = this.getNumDoors() * 100;
        double premiumTrunk = this.getTrunkCapacity() * 10;
        return premiumDoor + premiumTrunk;
    }

    public void printInfo() {
        System.out.println("\nCar Information:");
        super.printInfo();
        System.out.println("Number of Doors: " + this.getNumDoors());
        System.out.println("Truck Capacity: " + this.getTrunkCapacity() + " cu ft");
    }
}

public class KhareSamikshaA5 {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Motorcycle Details:");
        System.out.print("Make: ");
        String getMake = scan.nextLine();

        System.out.print("Model: ");
        String getModel =  scan.nextLine();

//        System.out.print("Year: ");
//        int getYear = scan.nextInt();
//        scan.nextLine();

        int getYear = 0;
        boolean validYearInput = false;
        while (!validYearInput) {
            try {
                System.out.print("Year: ");
                getYear = scan.nextInt();
                scan.nextLine();
                validYearInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Usage: Please enter a valid year.");
                scan.nextLine();
            }
        }

        System.out.print("Fuel Type: ");
        String getFuelType = scan.nextLine();

//        System.out.print("Price: ");
//        double getPrice = scan.nextDouble();

        double getPrice = 0;
        boolean validPriceInput = false;
        while (!validPriceInput) {
            try {
                System.out.print("Price: ");
                getPrice = scan.nextDouble();
                validPriceInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Usage: Please enter a valid price.");
                scan.nextLine();
            }
        }

//        System.out.print("Engine Displacement: ");
//        int getEngineDisplacement = scan.nextInt();
        int getEngineDisplacement = 0;
        boolean validEngineDisplacementInput = false;
        while (!validEngineDisplacementInput) {
            try {
                System.out.print("Engine Displacement: ");
                getEngineDisplacement = scan.nextInt();
                validEngineDisplacementInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Usage: Please enter a valid engine displacement.");
                scan.nextLine();
            }
        }


//        System.out.print("Is Off Road (true/false): ");
//        boolean getIsOffRoad = scan.nextBoolean();
//        scan.nextLine();

        boolean getIsOffRoad = false;
        boolean validIsOffRoadInput = false;
        while (!validIsOffRoadInput) {
            try {
                System.out.print("Is Off Road (true/false): ");
                getIsOffRoad = scan.nextBoolean();
                validIsOffRoadInput = true;
                scan.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Usage: Please enter a valid is off road (true/false).");
                scan.nextLine();
            }
        }

        System.out.println("\nEnter Car Details:");

        System.out.print("Make: ");
        String getMake1 = scan.nextLine();

        System.out.print("Model: ");
        String getModel1 =  scan.nextLine();

//        System.out.print("Year: ");
//        int getYear1 = scan.nextInt();
//        scan.nextLine();

        int getYear1 = 0;
        boolean validYear1Input = false;
        while (!validYear1Input) {
            try {
                System.out.print("Year: ");
                getYear1 = scan.nextInt();
                scan.nextLine();
                validYear1Input = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Usage: Please enter a valid year.");
                scan.nextLine();
            }
        }

        System.out.print("Fuel Type: ");
        String getFuelType1 = scan.nextLine();

//        System.out.print("Price: ");
//        double getPrice1 = scan.nextDouble();

        double getPrice1 = 0;
        boolean validPrice1Input = false;
        while (!validPrice1Input) {
            try {
                System.out.print("Price: ");
                getPrice1 = scan.nextDouble();
                validPrice1Input = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Usage: Please enter a valid price.");
                scan.nextLine();
            }
        }

//        System.out.print("Number of Doors: ");
//        int getNumDoors = scan.nextInt();

        int getNumDoors = 0;
        boolean validNumDoorsInput = false;
        while (!validNumDoorsInput) {
            try {
                System.out.print("Number of Doors: ");
                getNumDoors = scan.nextInt();
                validNumDoorsInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Usage: Please enter a valid number of doors.");
                scan.nextLine();
            }
        }

//        System.out.print("Trunk Capacity (cu ft): ");
//        double getTrunkCapacity = scan.nextDouble();
        double getTrunkCapacity = 0;
        boolean validTrunkCapacityInput = false;
        while (!validTrunkCapacityInput) {
            try {
                System.out.print("Trunk Capacity (cu ft): ");
                getTrunkCapacity = scan.nextDouble();
                validTrunkCapacityInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Usage: Please enter a valid trunk capacity.");
                scan.nextLine();
            }
        }


        Motorcycle motorcycle = new Motorcycle(getMake, getModel, getYear, getFuelType, getPrice, getEngineDisplacement, getIsOffRoad);
        Car car = new Car(getMake1, getModel1, getYear1, getFuelType1, getPrice1, getNumDoors, getTrunkCapacity);

        motorcycle.printInfo();
        System.out.println("Tax: $" + motorcycle.calculateTax());

        car.printInfo();
        System.out.println("Insurance Premium: $" + car.calculateInsurance());

        System.out.print("\nProgram Completed");

    }
}
