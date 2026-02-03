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

}

class Session{

}


public class AttendenceService {
    Set<String> StudentIds=new HashSet<>();
    Map<String,Set<String>> attendancemap=new HashMap<>();

    void markAttendence(String sessionID,String studentID) throws DuplicateAttendanceException{

    }

    void removeAttendence(String sessionID,String studentID){

    }

    void displayAttendence(String sessionID){

    }
}
