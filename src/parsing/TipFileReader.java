package parsing;

import model.Shift;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TipFileReader {

    public static <Doc> Doc parseFile(Readable r, TipBuilder<Doc> builder) {

        Objects.requireNonNull(r, "Must have non-null readable source");
        Objects.requireNonNull(builder, "Must provide a non-null AnimationBuilder");
        Scanner s = new Scanner(r);
        // Split at whitespace, and ignore # comment lines
        s.useDelimiter(Pattern.compile("(\\p{Space}+|#.*)+"));

        while (s.hasNext()) {
            String word = s.next();
            switch (word) {
                case "Tipper":
                    readTipper(s, builder);
                    break;
                case "Job":
                    readJob(s, builder);
                    break;
                case "Shift":
                    readShift(s, builder);
                    break;
                default:
                    throw new IllegalStateException("Unexpected keyword: " + word + s.nextLine());

            }
        }
        return builder.build();
    }

    private static <Doc> void readTipper(Scanner s, TipBuilder<Doc> builder) {
        String tipperName;
        if (s.hasNext()) {
            tipperName = s.next();
        } else {
            throw new IllegalMonitorStateException("Tipper: Expected a name, but no name available");
        }
        builder.declareTippers(tipperName);
    }

    private static <Doc> void readJob(Scanner s, TipBuilder<Doc> builder) {
        String jobName;
        double wage;
        if (s.hasNext()) {
            jobName = s.next();
        } else {
            throw new IllegalMonitorStateException("Job: Expected a name, but no name available");
        }
        if (s.hasNext()) {
            wage = s.nextDouble();
        } else {
            throw new IllegalMonitorStateException("Job: Expected a wage, but no wage available");
        }

        builder.declareJobs(jobName, wage);
    }

    private static <Doc> void readShift(Scanner s, TipBuilder<Doc> builder) {
        ArrayList<Object> values = new ArrayList<>();
        String[] fieldNames = new String[]{"Date", "Name", "Length", "Tip", "Job", "Weather", "timeOfDay"};
        String ShiftName;
        if (s.hasNext()) {
            ShiftName = s.next();
        } else {
            throw new IllegalStateException("Shift: Expected a shift name, but no name available");
        }
        for (int i = 0; i < 6; i++) {
            values.add(i, getNext(s, "Shift", fieldNames[i]));
        }
    }

    private static String getNext(Scanner s, String label, String fieldName) {
        if (s.hasNext()) {
            return s.next();
        }
        else if (label.equals("Shift")) {
            return "blank";
        } else {
            throw new IllegalStateException(
                    String.format("%s: expected integer for %s, but no more input available",
                            label, fieldName));
        }
    }
}

