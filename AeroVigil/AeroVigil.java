import java.util.Scanner;

class InvalidFlightException extends RuntimeException{
    public InvalidFlightException(String message){
        super(message);
    }
}



public class AeroVigil {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the details in format  <FlightNumber>:<FlightName>:<PassengerCount>:<CurrentFuel\r\n" + //
                        "Level>.");
        String flight=sc.nextLine();

        String[] parts=flight.split(":");

        String flightNumber=parts[0];
        String FlightName=parts[1];
        int  passengerCount=Integer.parseInt(parts[2]);
        double currentFuelLevel=Double.parseDouble(parts[3]);

        if(validateFlightNumber(flightNumber) && validateFlightName(FlightName) && validatePassengerCount(passengerCount,FlightName)){
            System.out.println(calculateFuelToFillTank(FlightName, currentFuelLevel));
        }

        sc.close();
    }

    public static boolean validateFlightNumber(String flightNumber){
        String ft=flightNumber.substring(0,2);
        
        String num=flightNumber.substring(3,flightNumber.length());

        int n=Integer.parseInt(num);

        if(ft.equals("FL") && (n>1000 && n<9999))
            return true;

        throw new InvalidFlightException("The flight number "+ flightNumber+ " is invalid");
    }

    public static boolean validateFlightName(String flightName){
        
      
            if(flightName.equalsIgnoreCase("SpiceJet") ||flightName.equalsIgnoreCase("Vistara") ||flightName.equalsIgnoreCase("IndiGo") ||flightName.equalsIgnoreCase("Air Arabia") ){
                return true;
    
            }
            throw new InvalidFlightException("The flight name " + flightName +" is invalid");
        }

    public static boolean validatePassengerCount(int passengerCount,String flightName){
        
        if((flightName.equalsIgnoreCase("SpiceJet") && passengerCount<=396 && passengerCount>0) || (flightName.equalsIgnoreCase("Vistara") && passengerCount<=615 && passengerCount>0) || (flightName.equalsIgnoreCase("IndiGo") && passengerCount<=230 && passengerCount>0) || (flightName.equalsIgnoreCase("Air Arabia") && passengerCount<=130 && passengerCount>0)){
            return true;
        }

        throw new InvalidFlightException("The passenger count "+ passengerCount +" is invalid for" + flightName);
    }

    public static double  calculateFuelToFillTank(String flightName, double currentFuelLevel){

        if(flightName.equalsIgnoreCase("SpiceJet")){
            if(currentFuelLevel>=0 && currentFuelLevel<=200000)
                return 200000 - currentFuelLevel;
        }
        else if(flightName.equalsIgnoreCase("Vistara")){
            if(currentFuelLevel>=0 && currentFuelLevel<=300000)
                return 300000 - currentFuelLevel;
        }
        else if(flightName.equalsIgnoreCase("IndiGo")){
            if(currentFuelLevel>=0 && currentFuelLevel<=250000)
                return 250000 - currentFuelLevel;
        }
        else if(flightName.equalsIgnoreCase("Air Arabia")){
            if(currentFuelLevel>=0 && currentFuelLevel<=150000)
                return 150000 -  currentFuelLevel;
        }

        throw new InvalidFlightException("Invalid fuel level for "+flightName);
    }
}

