package laba4.engine;

public class Engine {
    private int power;
    private int number;
    private int volume;
    private int fuelConsumption;
    private String typeOfFuel;
    private int numberOfCylinders;
    public Engine(int power, int number, int volume, int fuelConsumption, String typeOfFuel, int numberOfCylinders) {
        this.power = power;
        this.number = number;
        this.volume = volume;
        this.fuelConsumption = fuelConsumption;
        this.typeOfFuel = typeOfFuel;
        this.numberOfCylinders = numberOfCylinders;
    }
    public int getPower(){
        return power;
    }
    public int getNumber(){
        return number;
    }
    public int getVolume(){
        return volume;
    }
    public int getFuelConsumption(){
        return fuelConsumption;
    }
    public String getTypeOfFuel(){
        return typeOfFuel;
    }
    public int getNumberOfCylinders(){
        return numberOfCylinders;
    }
    public void info(){
        System.out.println("Power: " + power);
        System.out.println("Number: " + number);
        System.out.println("Volume: " + volume);
        System.out.println("Fuel consumption: " + fuelConsumption);
        System.out.println("Type of fuel: " + typeOfFuel);
        System.out.println("Number of Cylinders: " + numberOfCylinders);
    }
}
