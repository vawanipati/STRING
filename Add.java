@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendEmail(String to, String subject, Map<String, Object> model) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try {
            helper.setTo(to);
            helper.setSubject(subject);

            String htmlContent = templateEngine.process("email-template", new Context(Locale.ENGLISH, model));

            helper.setText(htmlContent, true);

            emailSender.send(message);
        } catch (MessagingException e) {
            // Handle exceptions here
        }
    }
}
