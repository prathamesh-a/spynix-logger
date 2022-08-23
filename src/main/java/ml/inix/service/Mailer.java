package ml.inix.service;

import ml.inix.util.Color;
import ml.inix.util.Log;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Mailer {

    private String SMTP;
    private String email_from;
    private String email_password;
    private String port;
    private boolean SSL;
    private boolean TLS;
    private boolean debug;

    public Mailer(String smtp, String email_from, String email_password, String port,
                  boolean ssl, boolean tls, boolean debug) {

        this.SMTP = smtp;
        this.email_from = email_from;
        this.email_password = email_password;
        this.port = port;
        this.SSL = ssl;
        this.TLS = tls;
        this.debug = debug;
    }

    public void sendSimpleMail(String email_to, String subject, String message) {
        SimpleEmail email = new SimpleEmail();
        try {
            email.setDebug(debug);
            email.setHostName(SMTP);
            email.addTo(email_to);
            email.setFrom(email_from);
            email.setAuthentication(email_from, email_password);
            email.setSubject(subject);
            email.setMsg(message);
            email.setSSL(SSL);
            email.setTLS(TLS);
            email.send();
        } catch (EmailException e) {
            Log.out(Color.RED + e.getMessage());
        }
    }
}
