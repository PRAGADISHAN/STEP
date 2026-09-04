public class BankReferenceValidator {
    public static String normalizeReference(String raw) {
        String t = raw.trim();
        if (t.length() < 3) return t.toUpperCase();
        return t.substring(0, 3).toUpperCase() + t.substring(3);
    }

    public static String validateAndFormat(String ref) {
        if (ref.length()!= 14) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(ref.charAt(i))) return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(ref.charAt(i))) return "Invalid: body must be digits";
        }
        String bank = ref.substring(0, 3);
        String dd = ref.substring(3, 5);
        String mm = ref.substring(5, 7);
        String yy = ref.substring(7, 9);
        String seq = ref.substring(9);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bank).append("] DATE: ").append(dd).append("/").append(mm).append("/").append(yy).append(" | SEQ: ").append(seq);
        return sb.toString();
    }

    public static void main(String[] args) {
        String r1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(r1)); // [HDF] DATE: 03/02/26 | SEQ: 00042
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }
}