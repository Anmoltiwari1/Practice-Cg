/*Nouns:(Classes)
Student,Session,AttendenceService

Verbs:(methods)
mark,remove,display attendance

DataStructure:Set,Map */

import java.util.*;

class DuplicateAttendanceException extends Exception{
    
    DuplicateAttendanceException(){
        super("Dupicate Attendance Marked");
    }
}

class Student{

    String Studentid;
    String name;
    int age;
    double marks;

    Student(String Studentid,String name,int age,double marks){
        this.Studentid=Studentid;
        this.name=name;
        this.age=age;
        this.marks=marks;
    }
}

class Session{

    String SessionId;
    double SessionDuration;

    Session(String SessionId,double SessionDuration){
        this.SessionId=SessionId;
        this.SessionDuration=SessionDuration;
    }

}



public class AttendenceService {
    
    private Map<String,Set<String>> attendancemap=new HashMap<>();

    void markAttendence(String sessionID,String studentID) throws DuplicateAttendanceException{
        
        attendancemap.putIfAbsent(sessionID,new HashSet<>());

        Set<String> students =attendancemap.get(sessionID);

        if(students.contains(studentID)){
            throw new DuplicateAttendanceException();
        }
        students.add(studentID);
    }

    void removeAttendence(String sessionID,String studentID){
        if(!attendancemap.containsKey(sessionID)){
            System.out.println("Session Not found");
            return;
        }

        attendancemap.get(sessionID).remove(studentID);
    }

    void displayAttendence(String sessionID){
          if (!attendancemap.containsKey(sessionID)) {
            System.out.println("No attendance for session " + sessionID);
            return;
        }

        System.out.println("Attendance for session " + sessionID + ":");
        for (String studentId : attendancemap.get(sessionID)) {
            System.out.println(studentId);
        }
    }

    public static void main(String[] args) throws DuplicateAttendanceException {
        
        AttendenceService service=new AttendenceService();

        try {
            service.markAttendence("S1","ST101");
            service.markAttendence("S2","ST102");
            service.markAttendence("S3","ST103");
        } catch (DuplicateAttendanceException e) {
            System.out.println(e.getMessage());
        }

        service.displayAttendence("S1");
        service.removeAttendence("S1", "ST101");
        service.displayAttendence("S1");
    }
}
