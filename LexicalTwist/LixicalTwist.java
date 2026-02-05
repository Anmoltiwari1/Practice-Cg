import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class LixicalTwist {
  public static void main(String[] args) {
    
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter the first word");
   String first=sc.nextLine();
   
   System.out.println("Enter the Second Word");
   String second=sc.nextLine();
  

   HashSet<Character> res=new LinkedHashSet<>(); 

   if(checkRev(first, second)){
        System.out.println(firstCase(first, second));
   }else{
    res=secondCase(first, second);

    for(char i:res){
        System.out.print(i);
    }
   }

  }
  
  public static boolean checkRev(String first,String second){

   String rev="";
   for(int i=first.length()-1;i>=0;i--){
    rev+=first.charAt(i);
   }

    if(rev.equalsIgnoreCase(second))
        return true;


    return false;
  }

  public static String firstCase(String first,String second){

    String res="",rev="";
    for(int i=first.length()-1;i>=0;i--){
    rev+=first.charAt(i);
   }

    rev=rev.toLowerCase();

    for(int i=0;i<rev.length();i++){
        if(rev.charAt(i)=='a' ||rev.charAt(i)=='e' ||rev.charAt(i)=='i' ||rev.charAt(i)=='o' ||rev.charAt(i)=='u'){
            res+='@';
        }else{
            res+=rev.charAt(i);
        }
    }

    return res;
}

  public static HashSet<Character> secondCase(String first,String second){

    HashSet<Character> res=new LinkedHashSet<>();

    String comb="",combUpper="";
    int vowel=0,consonant=0;

    comb=first.concat(second);
    combUpper=comb.toUpperCase();

    for(int i=0;i<combUpper.length();i++){
        if(combUpper.charAt(i)=='A' ||combUpper.charAt(i)=='E' ||combUpper.charAt(i)=='I' ||combUpper.charAt(i)=='O' ||combUpper.charAt(i)=='U'){
            vowel++;
        }else{
            consonant++;
        }
    }


    if(vowel>consonant){
        for(int i=0;i<combUpper.length();i++){
            if(combUpper.charAt(i)=='A' && combUpper.charAt(i)=='E' && combUpper.charAt(i)=='I' && combUpper.charAt(i)=='O' &&combUpper.charAt(i)=='U'){
                res.add(combUpper.charAt(i));
                if(res.size()==2)   
                    return res;
            }
        }
    }else if(consonant>vowel){
        for(int i=0;i<combUpper.length();i++){
          if(combUpper.charAt(i)!='A' && combUpper.charAt(i)!='E' &&combUpper.charAt(i)!='I' &&combUpper.charAt(i)!='O' &&combUpper.charAt(i)!='U'){
                res.add(combUpper.charAt(i));
                if(res.size()==2)   
                    return res;
            }
        }
    }else{
        System.out.println("Vowel and Consonants are equal");
    }

    return res;
  }
}
