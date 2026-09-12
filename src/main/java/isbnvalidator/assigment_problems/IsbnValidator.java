package isbnvalidator.assigment_problems;

public class IsbnValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return publisherCode + rest;
    }

    static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: reference must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, 3);

        for (int i = 0; i < publisherCode.length(); i++) {
            if (!Character.isLetter(publisherCode.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = code.substring(3);

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4, 10);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(publisherCode).append("] YEAR: ")
                 .append(year).append(" | CATALOG: ").append(catalog);

        return formatted.toString();
    }

    public static void main(String[] args) {
        String normalized1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalized1));

        String normalized2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(normalized2));
    }
}
