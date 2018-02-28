package com.example.micro.sumbiting.submitingemail.utils;

import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Slf4j
public class EmailUtils {
    private static final String from = "noreply.alexander.alekseev091@gmail.com";
    private static final String me = "alexander.alekseev091@gmail.com";
    private static final String pass = "1qaz2wsx3edc4rfv";
    private static final String host = "smtp.gmail.com";//or IP address
    private static final String port = "587";//or IP address
    private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public static void send(String to, Date date) throws MessagingException {
        //Get the session object
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(from);
        msg.setRecipients(Message.RecipientType.TO, to);
        msg.setSubject("Приглашение!");
        msg.setSentDate(new Date());
        msg.setText("Привет, Тань!\n Если ты получила это сообщение, то ты приняла моё приглашение и мы идём гулять " + format.format(date)
                + ",\n а ещё это означает, что мой маленький микросервис успешно работает) ");
        Transport.send(msg);


        MimeMessage msgforme = new MimeMessage(session);
        msgforme.setFrom(from);
        msgforme.setRecipients(Message.RecipientType.TO, me);
        msgforme.setSubject("Приглашение отправлено!");
        msgforme.setSentDate(new Date());
        msgforme.setText("Мужик всё работает! дата: " + format.format(date));
        Transport.send(msgforme);

        System.out.println("message sent successfully....");

    }
}
