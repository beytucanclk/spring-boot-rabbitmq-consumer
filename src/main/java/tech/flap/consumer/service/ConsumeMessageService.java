package tech.flap.consumer.service;

import tech.flap.consumer.model.CreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeMessageService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final MailService mailService;

    public ConsumeMessageService(MailService mailService) {
        this.mailService = mailService;
    }

    public void consumeMessage(byte[] messageBody) {
        try {
            CreatedEvent event = objectMapper.readValue(messageBody, CreatedEvent.class);
            mailService.sendSimpleMessage(event.getMail(), "Kayıt oluşturuldu.", "MErhaba ");
            log.info("Mail gönderildi.");

        } catch (Exception e) {
            log.error("Error deserializing message", e);
        }
    }
}
