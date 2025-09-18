package org.books.infra.adapter.email;

import org.books.domain.model.Livro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    @Value("${mail.destinatario}")
    private String destinatario;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Livro livro) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destinatario);
        message.setSubject("Livro " + livro.getTitulo() + ", foi cadastrado");
        message.setText("O livro " + livro.getTitulo() + "escrito por "
                + livro.getAutor() + " no ano " + livro.getAno() + " foi cadastrado com sucesso!");
        mailSender.send(message);
    }
}
