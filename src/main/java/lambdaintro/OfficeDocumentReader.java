package lambdaintro;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {


    public static final String DOCUMENTUM_EXTENSION = "docx";
    public static final String POWERPOINT_EXTENSION = "pptx";
    public static final String EXCEL_EXTENSION = "xlsx";
//    private static final String REGEXP = ".*\\.(docx|xlsx|pptx)$";

    public List<File> listOfficeDocuments(File path) {
        List<File> result = new ArrayList<>();
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String filename = file.toString();
                String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
                if (DOCUMENTUM_EXTENSION.equals(extension) ||
                        POWERPOINT_EXTENSION.equals(extension) ||
                        EXCEL_EXTENSION.equals(extension)) {
                    result.add(new File(path.toString() + filename));
                }
            }
        }
        result.sort((o1, o2) -> o1.toString().compareTo(o2.toString()));
        return result;
//        List<File> files = Arrays.asList(path.listFiles(f -> f.isFile() && f.getName().toLowerCase().matches(REGEXP)));
//        files.sort(Comparator.comparing(File::getName));
//        return files;
    }
    // docx, pptx és xlsx
}

