package org.example.notificationService;

public class EmailService implements NotificationService {
    @Override
    public void sendMsg(String msg){
        System.out.println("Sending email to " + msg);
    }
}
