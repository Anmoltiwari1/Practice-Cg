import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Vessel{
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    Vessel(String vesselId,String vesselName,double averageSpeed,String vesselType){
        this.vesselId=vesselId;
        this.vesselName=vesselName;
        this.averageSpeed=averageSpeed;
        this.vesselType=vesselType;
    }

    public void setVesselId(String vesselId){
        this.vesselId=vesselId;
    }

    public String getVesselId(){
        return vesselId;
    }

    public void setvesselName(String vesselName){
        this.vesselName=vesselName;
    }

    public String getvesselName(){
        return vesselName;
    }

    public void setaverageSpeed(double averageSpeed){
        this.averageSpeed=averageSpeed;
    }

    public double getaverageSpeed(){
        return averageSpeed;
    }

    public void setvesselType(String vesselType){
        this.vesselType=vesselType;
    }

    public String getvesselType(){
        return vesselType;
    }

    @Override
    public String toString(){
        return "VesselId: "+vesselId+"| VesselName : "+vesselName+"| AverageSpeed: "+averageSpeed+"| vesselType: "+vesselType;
    }
}

class VesselUtil{

    
    private List<Vessel> vesselList;

    VesselUtil(){
        vesselList=new ArrayList<>();
    }


    public void setvesselList(List<Vessel> vesselList){
        this.vesselList=vesselList;
    }

    public List<Vessel> getvesselList(){
        return vesselList;
    }


    public void addVesselPerfomance(Vessel v){
        vesselList.add(v);
    }

    public Vessel getVesselById(String vesselId){

        for(Vessel v:vesselList){
            if(v.getVesselId().equalsIgnoreCase(vesselId)){
                return v;
            }
        }
        return null;
    }

    public List<Vessel> getHighPerformaneVessel(){
        List<Vessel> res=new ArrayList<>();

        double max=Double.MIN_VALUE;

        for(Vessel v:vesselList){
            if(v.getaverageSpeed()>max){
                max=v.getaverageSpeed();
            }
        }

        for(Vessel v:vesselList){
            if(v.getaverageSpeed()==max){
                res.add(v);
            }
        }

        return res;
    }
}



public class Main {
    public static void main(String[] args) {
        
        VesselUtil util=new VesselUtil();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vessels");
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            System.out.println("Enter the vessel credentials of "+(i+1)+"th vessel in format format vesselId:vesselName:averageSpeed:vesselType");

            String cred=sc.nextLine();

            String[] data=cred.split(":");

            if(data.length!=4){
                System.out.println("Input format");
                i--;
                continue;
            }

            String VesselId=data[0];
            String vesselName=data[1];
            double avgSpeed=Double.parseDouble(data[2]);
            String vesselType=data[3];

            Vessel v=new Vessel(VesselId, vesselName, avgSpeed,vesselType);
            util.addVesselPerfomance(v);
        }



        System.out.println("Enter the vesselId to be searched:");
        String id=sc.nextLine();

        System.out.println(util.getVesselById(id));

        System.out.println("Vessels have highest average speed are:");
        for(Vessel v:util.getHighPerformaneVessel()){
            System.out.println(v);
        }

        sc.close();
    
    }
}
