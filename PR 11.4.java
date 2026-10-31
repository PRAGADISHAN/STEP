import java.util.*;
public class EmployeeIDLookup {
    public static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> map = new HashMap<>();
        for (String[] r : records) map.put(r[0], r[1]);
        return map;
    }
    public static String getDepartment(Map<String, String> lookup, String id) {
        return lookup.getOrDefault(id, "Unknown");
    }
    public static void main(String[] args) {
        String[][] records = { {"E245","Finance"}, {"E110","Engineering"}, {"E390","Marketing"}, {"E101","Engineering"} };
        Map<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, "E390")); // Marketing
        System.out.println(getDepartment(lookup, "E999")); // Unknown
    }
}
