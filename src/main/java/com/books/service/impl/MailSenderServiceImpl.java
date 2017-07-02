package com.books.service.impl;

import com.books.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailSenderServiceImpl implements MailSenderService {
    private final String EMAIL_FROM = "koko1990rokoko@gmail.com";
    private final String EMAIL_PASSWORD = "kokokokokoko";

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendMail(String thema, String mailBody, String email) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress(EMAIL_FROM));
            helper.setTo(email);
            helper.setSubject(thema);
            FileSystemResource resource = new FileSystemResource("D:\\Завантажені файли\\s.png");
            helper.addAttachment("s.png", resource);
            helper.setText("<head>\n" +
                    "  <title></title>\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                    "<style type=\"text/css\">\n" +
                    "  #outlook a { padding: 0; }\n" +
                    "  .ReadMsgBody { width: 100%; }\n" +
                    "  .ExternalClass { width: 100%; }\n" +
                    "  .ExternalClass * { line-height:100%; }\n" +
                    "  body { margin: 0; padding: 0; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\n" +
                    "  table, td { border-collapse:collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; }\n" +
                    "  img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; }\n" +
                    "  p { display: block; margin: 13px 0; }\n" +
                    "</style>\n" +
                    "<!--[if !mso]><!-->\n" +
                    "<style type=\"text/css\">\n" +
                    "  @media only screen and (max-width:480px) {\n" +
                    "    @-ms-viewport { width:320px; }\n" +
                    "    @viewport { width:320px; }\n" +
                    "  }\n" +
                    "</style>\n" +
                    "<!--<![endif]-->\n" +
                    "<!--[if mso]>\n" +
                    "<xml>\n" +
                    "  <o:OfficeDocumentSettings>\n" +
                    "    <o:AllowPNG/>\n" +
                    "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                    "  </o:OfficeDocumentSettings>\n" +
                    "</xml>\n" +
                    "<![endif]-->\n" +
                    "<style type=\"text/css\">\n" +
                    "  @media only screen and (min-width:480px) {\n" +
                    "    .mj-column-per-100, * [aria-labelledby=\"mj-column-per-100\"] { width:100%!important; }\n" +
                    ".mj-column-per-80, * [aria-labelledby=\"mj-column-per-80\"] { width:80%!important; }\n" +
                    ".mj-column-per-30, * [aria-labelledby=\"mj-column-per-30\"] { width:30%!important; }\n" +
                    ".mj-column-per-70, * [aria-labelledby=\"mj-column-per-70\"] { width:70%!important; }\n" +
                    "  }\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body style=\"background: #E3E5E7;\">\n" +
                    "  <div style=\"background-color:#E3E5E7;\"><!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\n" +
                    "        <tr>\n" +
                    "          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\n" +
                    "      <![endif]--><div style=\"margin:0 auto;max-width:600px;background:white;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\"><!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:10px 25px;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"width:80px;\"><a href=\"about:blank\" target=\"_blank\"><img alt=\"auth0\" title=\"\" height=\"auto\" src=\"https://s27.postimg.org/ca1957db7/huntr_logo.png\" style=\"border:none;border-radius:;display:block;outline:none;text-decoration:none;width:100%;height:auto;\" width=\"80\"></a></td></tr></tbody></table></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]--></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]-->\n" +
                    "      <!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\n" +
                    "        <tr>\n" +
                    "          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\n" +
                    "      <![endif]--><div style=\"margin:0 auto;max-width:600px;background:#222228;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:#222228;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\"><!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:480px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-80\" class=\"mj-column-per-80\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:10px 25px;padding-top:30px;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;border-spacing:0px;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"width:80px;\"><img alt=\"Zero To Launch\" title=\"\" height=\"auto\" src=\"https://cdn.auth0.com/website/emails/product/top-verify.png\" style=\"border:none;border-radius:;display:block;outline:none;text-decoration:none;width:100%;height:auto;\" width=\"80\"></td></tr></tbody></table></td></tr><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 20px 0px 20px;\" align=\"center\"><div style=\"cursor:auto;color:white;font-family:'Avenir Next', Avenir, sans-serif;font-size:32px;line-height:60ps;\">\n" +
                    "            Verify Your Account\n" +
                    "          </div></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]--></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]-->\n" +
                    "      <!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\n" +
                    "        <tr>\n" +
                    "          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\n" +
                    "      <![endif]--><div style=\"margin:0 auto;max-width:600px;background:white;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;font-size:0px;padding:40px 25px 0px;\"><!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 0px 25px;\" align=\"left\"><div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:18px;font-weight:500;line-height:30px;\">\n" +
                    "            Your account information\n" +
                    "          </div></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td><td style=\"vertical-align:top;width:180px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-30\" class=\"mj-column-per-30\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 0px 10px;\" align=\"left\"><div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\n" +
                    "            <strong style=\"font-weight: 500; white-space: nowrap;\">Account</strong>\n" +
                    "          </div></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td><td style=\"vertical-align:top;width:420px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-70\" class=\"mj-column-per-70\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 0px 10px;\" align=\"left\"><div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\n" +
                    "            hello@SmilesDavis.yeah\n" +
                    "          </div></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td><td style=\"vertical-align:top;width:180px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-30\" class=\"mj-column-per-30\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 0px 10px;\" align=\"left\"><div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\n" +
                    "            <strong style=\"font-weight: 500; white-space: nowrap;\">Verify Link</strong>\n" +
                    "          </div></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td><td style=\"vertical-align:top;width:420px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-70\" class=\"mj-column-per-70\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 0px 25px;\" align=\"left\"><div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\n" +
                    "            <a href=" + mailBody + " style=\"color:#0a84ae; text-decoration:none\" target=\"_blank\">" + mailBody + "</a>\n" +
                    "          </div></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +

                    "      <![endif]--></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]-->\n" +
                    "      <!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\n" +
                    "        <tr>\n" +
                    "          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\n" +
                    "      <![endif]--><div style=\"margin:0 auto;max-width:600px;background:white;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;font-size:0px;padding:0px 30px;\"><!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:undefined;width:600px;\">\n" +
                    "      <![endif]--><p style=\"font-size:1px;margin:0 auto;border-top:1px solid #E3E5E7;width:100%;\"></p><!--[if mso | IE]><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:1px;margin:0 auto;border-top:1px solid #E3E5E7;width:100%;\" width=\"600\"><tr><td style=\"height:0;line-height:0;\"> </td></tr></table><![endif]--><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]--></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]-->\n" +
                    "      <!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\n" +
                    "        <tr>\n" +
                    "          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\n" +
                    "      <![endif]--><div style=\"margin:0 auto;max-width:600px;background:white;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\"><!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:10px 25px;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" border=\"0\"><tbody><tr><td style=\"border-radius:3px;color:white;cursor:auto;\" align=\"center\" valign=\"middle\" bgcolor=\"#EB5424\"><a href=\"#\" style=\"display:inline-block;text-decoration:none;background:#EB5424;border-radius:3px;color:white;font-family:'Avenir Next', Avenir, sans-serif;font-size:14px;font-weight:500;line-height:35px;padding:10px 25px;margin:0px;\" target=\"_blank\">\n" +
                    "            VERIFY YOUR ACCOUNT\n" +
                    "          </a></td></tr></tbody></table></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]--></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]-->\n" +
                    "      <!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\n" +
                    "        <tr>\n" +
                    "          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\n" +
                    "      <![endif]--><div style=\"margin:0 auto;max-width:600px;background:white;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:white;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\"><!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 25px 15px;\" align=\"left\"><div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:16px;line-height:30px;\">\n" +
                    "            If you are having any issues with your account, please don't hesitate to contact us by replying to this mail.\n" +
                    "            <br>Thanks!\n" +
                    "          </div></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]--></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]-->\n" +
                    "      <!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\n" +
                    "        <tr>\n" +
                    "          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\n" +
                    "      <![endif]--><div style=\"margin:0 auto;max-width:600px;background:#F5F7F9;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:#F5F7F9;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;font-size:0px;padding:20px 0px;\"><!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"vertical-align:top;width:600px;\">\n" +
                    "      <![endif]--><div aria-labelledby=\"mj-column-per-100\" class=\"mj-column-per-100\" style=\"vertical-align:top;display:inline-block;font-size:13px;text-align:left;width:100%;\"><table cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-break:break-word;font-size:0px;padding:0px 20px;\" align=\"center\"><div style=\"cursor:auto;color:#222228;font-family:'Avenir Next', Avenir, sans-serif;font-size:13px;line-height:20px;\">\n" +
                    "            You’re receiving this email because you have an account in Huntr.\n" +
                    "            If you are not sure why you’re receiving this, please contact us.\n" +
                    "          </div></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]--></td></tr></tbody></table></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]-->\n" +
                    "      <!--[if mso | IE]>\n" +
                    "      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">\n" +
                    "        <tr>\n" +
                    "          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">\n" +
                    "      <![endif]--><div></div><!--[if mso | IE]>\n" +
                    "      </td></tr></table>\n" +
                    "      <![endif]--></div>\n" +
                    "<img src=\"https://mandrillapp.com/track/open.php?u=9812467&amp;id=bca57efeee894396adad890ad5feefe1\" height=\"1\" width=\"1\">\n" +
                    "\n" +
                    "\n" +
                    "</body>", true);
            synchronized (this) {
                mailSender.send(message);
            }
        } catch (MessagingException mex) {
            mex.printStackTrace();
            System.out.println("You have some problems with connection!");
        }
    }
}

