import java.util.Scanner;

public class FlipKey {
public static void main(String[] args) {
    
    String res="";
    
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the word");
    String str=sc.nextLine();

    res=CleanseAndInvert(str);
    
    if(res=="Invalid Input"){
        System.out.println(res);
    }else{
        System.out.println("The generated key is - "+res);
    }
    sc.close();
}
    public static String CleanseAndInvert(String input){
        
        String remove="";
        String rev="",res="";
        int l=input.length();

        if(l<6 || input==null || input.contains(" "))
            return "Invalid Input";

        String regex="^[A-Za-z]+$";
        if(input.matches(regex)){
            String lower=input.toLowerCase();
            
            for(int i=0;i<lower.length();i++){
                if(!((int)lower.charAt(i)%2==0)){
                    remove+=lower.charAt(i);
                }
            }
            rev=new StringBuilder(remove).reverse().toString();

            for(int i=0;i<rev.length();i++){
                if(i%2==0){
                    res+=Character.toUpperCase(rev.charAt(i));
                }else{
                    res+=rev.charAt(i);
                }
            }
        }else{
            return "Invalid Input";
        }
        return res;
    }    
}