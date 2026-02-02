import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NoAgentAvailableException extends Exception{

    NoAgentAvailableException(){
        super();
        System.out.println("No agent found");
    }
}

class Order{

    int orderId;
    String OrderName;
    double price;
     boolean assigned;

    Order(int orderId,String OrderName,double price){
        this.orderId=orderId;
        this.OrderName=OrderName;
        this.price=price;
        this.assigned=false;
    }
}

class Agent{

    int AgentId;
    String AgentName;
    boolean avaliable;
    
    Agent(int AgentId,String AgentName){
        this.AgentId=AgentId;
        this.AgentName=AgentName;
        this.avaliable=true;
    }
}

public class DeliveryService {
    
    Queue<Order> orders=new LinkedList<>();
    List<Agent> agents=new LinkedList<>();

    void assignOrder() throws NoAgentAvailableException{

        if(orders.isEmpty()){
            System.out.println("No order found");
        }

        Order order=orders.poll();
        boolean assigned=false;

        for(Agent a:agents){
            if(a.avaliable){
                a.avaliable=false;
                order.assigned=true;
                System.out.println("Order " + order.orderId + " assigned to " + a.AgentName);
                assigned = true;
                break;
            }
        }

        if(!assigned){
            orders.add(order);
            throw new NoAgentAvailableException();
        }
    }

    void cancelOrder(int orderId){
        Iterator<Order> it=orders.iterator();
        boolean found=false;
        while (it.hasNext()) {
            Order o = it.next();
            if (o.orderId == orderId) {
                found = true;
                it.remove();
                System.out.println("Order " + orderId + " cancelled.");
                break;
            }
        }
        if (!found) {
            System.out.println("Order " + orderId + " not found or already assigned.");
        }
    }
    void viewAssignedOrders() {
        boolean any = false;
        for (Order o : orders) {
            if (o.assigned) {
                System.out.println("Order " + o.orderId+ ": " + o.OrderName + " (Assigned)");
                any = true;
            }
        }
        if (!any) System.out.println("No assigned orders.");
    }

    public static void main(String[] args) {

        DeliveryService service=new DeliveryService();

        service.agents.add(new Agent(1, "Amit"));
        service.agents.add(new Agent(2, "Arnav"));

        service.orders.add(new Order(1, "Paneer", 100));
        service.orders.add(new Order(2, "Pizza", 120));

        try {
            service.assignOrder();
            service.assignOrder();
            service.assignOrder();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        service.viewAssignedOrders();
        service.cancelOrder(1);
        
    }
}
