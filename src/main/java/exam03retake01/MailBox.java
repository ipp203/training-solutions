package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }

    public void addMail(Mail mail) {
        if (mail != null) {
            mails.add(mail);
        }
    }

    public List<Mail> findByCriteria(String criteria) {
        if (criteria == null || criteria.isBlank()) {
            throw new IllegalArgumentException("Criteria is null or empty");
        }
        List<Mail> result;
        if (criteria.contains(":")) {
            result = findByFromOrTo(criteria);
        } else {
            result = findBySubjectOrMessage(criteria);
        }


        return result;
    }

    private List<Mail> findBySubjectOrMessage(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getMessage().contains(criteria) || mail.getSubject().contains(criteria)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> findByFromOrTo(String criteria) {
        List<Mail> result = new ArrayList<>();
        if (criteria.contains("from")) {
            findByFrom(criteria, result);
        }
        if (criteria.contains("to")) {
            findByTo(criteria, result);
        }
        return result;
    }

    private void findByFrom(String criteria, List<Mail> result) {
        String from = criteria.substring(criteria.indexOf(":") + 1);
        for (Mail mail : mails) {
            if (mail.getFrom().contains(from)) {
                result.add(mail);
            }
        }
    }

    private void findByTo(String criteria, List<Mail> result) {
        String to = criteria.substring(criteria.indexOf(":") + 1);
        for (Mail mail : mails) {
            for (Contact contact : mail.getTo())
                if (contact.contains(to)) {
                    result.add(mail);
                }
        }
    }

}
