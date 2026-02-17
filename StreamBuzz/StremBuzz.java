import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

class CreatorStats{

    String CreatorName;
    double[] WeeklyLikes;

    CreatorStats(String CreatorName,double[] WeeklyLikes){
        this.CreatorName=CreatorName;
        this.WeeklyLikes=WeeklyLikes;
    }
}

class Engagment{
    List<CreatorStats> EngagmentBoard=new ArrayList<>();
    
    public void RegisterCreator(CreatorStats record){
        EngagmentBoard.add(record);
    }

    public Dictionary<String,Integer> GetTopPostCounts(double likeThreshold){
        Dictionary<String,Integer> likes=new Hashtable<>();
        
        for(CreatorStats creatorStats:EngagmentBoard){
            int count=0;
            for(double like:creatorStats.WeeklyLikes){
                if(like>=likeThreshold){
                    count++;
                }
            }
            likes.put(creatorStats.CreatorName, count);
        }
        return likes;
    }

    public double CalculateAverageLikes(){
        int total=0;
        double sum=0;
        for(CreatorStats creatorStats:EngagmentBoard){
            for(double i:creatorStats.WeeklyLikes){
                sum+=i;
                total++;
            }
        }
        return sum/total;
    }
}

public class StremBuzz {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        Engagment engagment=new Engagment();

        System.out.println("Enter the choice to be done");
        System.out.println("Enter the 1 for regster the creator");
        System.out.println("Enter 2 for getting the top post");
        System.out.println("Enter the 3 for geting Overall average weekly likes");
        int ch=sc.nextInt();
        sc.nextLine();

        boolean choose=true;

        while(choose){

            switch (ch) {
                case 1:
                    System.out.println("Enter the CreaterName");
                    String creatorName=sc.nextLine();
    
    
                    System.out.println("Enter the Weekly likes");
                    double[] likes=new double[7];
                    for(int i=0;i<7;i++){
                        System.out.println("Enter the likes of "+(i+1)+"th day");
                        likes[i]=sc.nextDouble();
                    }
                    sc.nextLine();
    
                    engagment.RegisterCreator(new CreatorStats(creatorName, likes));
    
                    System.out.println("Creator registered Succesfully");
                    break;
    
                case 2:
                    System.out.println("Enter the Threshold likes");
                    double Threshold=sc.nextDouble();
                    sc.nextLine();
    
                    System.out.println(engagment.GetTopPostCounts(Threshold));
                    break;
    
                case 3:
                    System.out.println("Overall average weekly likes is :"+engagment.CalculateAverageLikes());
                    break;
    
                
                default:
                    System.out.println("Ypu have enter the wronog choice");
                    break;
            }
            System.out.println("Do you want any other task to be done enter Yes/No");
            String c=sc.nextLine();
        
            choose=c.equalsIgnoreCase("Yes");

            if(choose){
                System.out.println("Enter the choice");
                ch=sc.nextInt();
                sc.nextLine();
            }
        }


        sc.close();
    }
}
