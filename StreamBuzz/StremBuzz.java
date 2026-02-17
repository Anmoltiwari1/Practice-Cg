import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

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
        Engagment engagment=new Engagment();

        CreatorStats creatorStats1=new CreatorStats("Amit", new double[]{2,3,4,5,6});
        CreatorStats creatorStats2=new CreatorStats("Faujdar", new double[]{2,4,5,6,7});
        CreatorStats creatorStats3=new CreatorStats("Arnav", new double[]{2,3,4,5,6,9});
        CreatorStats creatorStats4=new CreatorStats("Parv", new double[]{2,3,4,5,6,12});

        engagment.RegisterCreator(creatorStats1);
        engagment.RegisterCreator(creatorStats2);
        engagment.RegisterCreator(creatorStats3);
        engagment.RegisterCreator(creatorStats4);

        System.out.println(engagment.GetTopPostCounts(3));
        System.out.print("Average like is: ");
        System.out.println(engagment.CalculateAverageLikes());
    }
}
