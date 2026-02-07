import java.util.Scanner;

class ParcelStage{
    String stageName;
    ParcelStage next;

    ParcelStage(String stageName){
        this.stageName=stageName;
        next=null;
    }
}


public class ParcelTracker {
    ParcelStage head;

    public void addStage(String stage){
       ParcelStage stage1=new ParcelStage(stage);
       
       if(head==null){
        head=stage1;
        return;
       }

       ParcelStage curr=head;
       while(curr.next!=null){
        curr=curr.next;
       }

       curr.next=stage1;
    }

    public void addCheckpoint(String prev,String newStage){
        ParcelStage p=new ParcelStage(newStage);
        ParcelStage curr=head;

        while(curr!=null && !curr.stageName.equals(prev)){
            curr=curr.next;
        }

        if(curr==null){
        System.out.println("Stage not found");
        return;
        }


        p.next=curr.next;
        curr.next=p;
    }

    public void trackParcel(){

        if(head==null){
            System.out.println("Parcel lost!");
            return;
        }

        ParcelStage curr=head;

        while(curr!=null){
            System.out.print(curr.stageName);

            if(curr.next!=null){
                System.out.print(" -->");
            }

            curr=curr.next;
        }
        System.out.println();
    }

    public void markLost(){
        head=null;
        System.out.println("Your parcel is being lost");
    }

    public boolean isDelivered(){
        if(head == null)
            return false;

        ParcelStage curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }

        return curr.stageName.equals("Delivered");
    }

    public static void main(String[] args) {
     
        Scanner sc=new Scanner(System.in);
        ParcelTracker parcel=new ParcelTracker();
        int choice;
        do{
            System.out.println("\n---- Parcel Tracker Menu ----");
            System.out.println("1. Add Stage");
            System.out.println("2. Add Intermediate Checkpoint");
            System.out.println("3. Track Parcel");
            System.out.println("4. Check Delivery Status");
            System.out.println("5. Mark Parcel Lost");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the stage name");
                    String stage=sc.nextLine();
                    parcel.addStage(stage);
                    break;

                case 2:
                    System.out.println("Enter the previous Stage");
                    String prev=sc.nextLine();
                    System.out.println("Enter the new Checkpoint");
                    String newStage=sc.nextLine();

                    parcel.addCheckpoint(prev,newStage);
                    break;

                case 3:
                    parcel.trackParcel();
                    break;

                case 4:
                    if(parcel.isDelivered())
                        System.out.println("Parcel Delivered");
                    else
                        System.out.println("Parcel Not delivered");

                    break;

                case 5:
                    parcel.markLost();
                    break;

                case 6:
                    System.out.println("Exiting ....");
                    break;

                default:
                    System.out.println("Wrong choice");

            }

        }while(choice!=6);

        sc.close();
        
    }
}
