public class LibraryIsbnValidator {
    public static String normalizeCode(String raw) {
        String t = raw.trim();
        if (t.length() < 3) return t.toUpperCase();
        return t.substring(0, 3).toUpperCase() + t.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length()!= 13) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) return "Invalid: body must be digits";
        }
        String pub = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pub).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);
        return sb.toString();
    }

    public static void main(String[] args) {
        String c1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(c1)); // [PEN] YEAR: 2026 | CATALOG: 004251
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }
}