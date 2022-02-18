package ru.zanko.mailsender;

import ru.zanko.mailsender.service.EmailSender;
import ru.zanko.mailsender.service.PDFConverter;

public class Main {

    public static void main(String[] args) {
        PDFConverter.convertToPdf();
        EmailSender.emailSender();
    }
}
