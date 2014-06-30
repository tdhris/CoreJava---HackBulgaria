import org.apache.commons.mail.*;

public class Suarez {
    public static void main(String[] args) throws EmailException {
        sendEmail();
    }
    
    public static void sendEmail() throws EmailException  {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("./src/azbW3zq_460sa_v1.gif");
        attachment.setDescription(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Suarez-Chiellini biting accident");
        attachment.setName("Suarez");
        
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.addTo("tdhristova@yahoo.com");
        email.setFrom("javaemailtest28@gmail.com");
        email.setAuthentication("javaemailtest28@gmail.com", "Blah$$1234");
        email.setSSLOnConnect(true);
        email.setSubject("Spammamamamamamm & Eggs");
        email.setMsg("Blah hahahhahahah");
        email.attach(attachment);
        email.send();
        
    }
}
