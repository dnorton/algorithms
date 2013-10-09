/**
 * Created with IntelliJ IDEA.
 */
public class TestStringFormat {

    /* http://docs.oracle.com/javase/1.5.0/docs/api/java/util/Formatter.html
     * Template:
     * %[argument_index$][flags][width][.precision]conversion
     *
     */

    public static void main(String[] args) {
//        Long value = 1000l;
        String value = "1000";
        String formattedString = String.format("%1$#10d", value);
        System.out.println(formattedString);
    }
}
