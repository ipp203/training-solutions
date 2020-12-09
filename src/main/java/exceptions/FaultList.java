package exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FaultList {

    public enum ProcessingResult {
        NO_ERROR(0),
        COMMENT(1),
        WORD_COUNT_ERROR(2),
        VALUE_ERROR(4),
        DATE_ERROR(8),
        VALUE_AND_DATE_ERROR(12);

        private int code;

        ProcessingResult(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("Parameter is null");
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {

            ProcessingResult processingResult = lineProcess(lines.get(i));

            if (processingResult.getCode() > 1) {
                result.add(getFirstData(lines.get(i)) + "," + processingResult.getCode());
            }
        }
        return result;
    }

    private ProcessingResult lineProcess(String line) {
        String[] str = line.split(",");
        if (str.length != 3) {
            return ProcessingResult.WORD_COUNT_ERROR;
        }

        if (checkFirstData(str[0]) == ProcessingResult.COMMENT) {
            return ProcessingResult.COMMENT;
        }

        ProcessingResult result1 = checkSecondData(str[1]);
        ProcessingResult result2 = checkThirdData(str[2]);
        if (result1 == ProcessingResult.VALUE_ERROR && result2 == ProcessingResult.DATE_ERROR) {
            return ProcessingResult.VALUE_AND_DATE_ERROR;
        }
        if (result1 == ProcessingResult.VALUE_ERROR) {
            return result1;
        }
        if (result2 == ProcessingResult.DATE_ERROR) {
            return result2;
        }
        return ProcessingResult.NO_ERROR;
    }

    private String getFirstData(String str) {
        return str.split(",")[0];
    }

    private ProcessingResult checkFirstData(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return ProcessingResult.COMMENT;
        }
        return ProcessingResult.NO_ERROR;
    }

    private ProcessingResult checkSecondData(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return ProcessingResult.VALUE_ERROR;
        }
        return ProcessingResult.NO_ERROR;
    }

    private ProcessingResult checkThirdData(String str) {
        try {
            LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy.MM.d."));
        } catch (DateTimeParseException nfe) {
            return ProcessingResult.DATE_ERROR;
        }
        return ProcessingResult.NO_ERROR;
    }


}
