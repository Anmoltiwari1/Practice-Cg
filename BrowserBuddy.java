import java.util.*;

class Tab{
    static int IdCounter=0;
    int tabId=0;
    String tabName;
    Tab next;
    Tab prev;

    Tab(String tabName){
        this.tabName=tabName;
        this.tabId=++IdCounter;
    }
}

public class BrowserBuddy {
    static Stack<Tab> history=new Stack<>();
    static Tab head;
    static Tab current;


    public static void addTab(String tabName){
        Tab node =new Tab(tabName);
        if(head==null){
            head=node;
            current=node;
            return;
        }
        Tab curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=node;
        node.prev=curr;
    }

    public static void forward(Tab curr){
         if(current == null || current.next == null){
        System.out.println("No forward tab available");
        return;
    }

    current = current.next;
    System.out.println("You are now on tab: " + current.tabName);
    }

    public static void back(Tab curr){
           if(current == null || current.prev == null){
        System.out.println("No previous tab available");
        return;
    }

    current = current.prev;
    System.out.println("You are now on tab: " + current.tabName);
    }

    public static void closeTab(Tab curr){
        Tab closed=curr;
        history.push(closed);
        curr=curr.prev;
        curr.next=null;
        System.out.println("The tab closed is :"+closed.tabName);
    }

    public static void printAllTabs(Tab curr){
        Tab c=curr;
        while(c!=null){
            System.out.println(c.tabName+" "+c.tabId);
            c=c.next;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the tabName");

        while(true){
        System.out.println("\n1.Open Tab  2.Back  3.Forward  4.Close Current Tab  5.Show Tabs  6.Exit");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice){
            case 1:
                System.out.print("Enter tab name: ");
                String name = sc.nextLine();
                addTab(name);
                System.out.println("Tab opened and switched to: " + current.tabName);
                break;

            case 2:
                back(current);
                break;

            case 3:
                forward(current);
                break;

            case 4:
                if(current == null){
                    System.out.println("No tab to close");
                    break;
                }
                closeTab(current);
                break;

            case 5:
                printAllTabs(head);
                break;

            case 6:
                System.out.println("Exiting BrowserBuddy");
                return;
        }
    }
}
}
