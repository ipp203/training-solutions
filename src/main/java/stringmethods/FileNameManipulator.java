package stringmethods;

public class FileNameManipulator {
    private static final String INVALIDARGUMENT = "Invalid argument!";
    private static final String EMPTYSTRING = "Empty string!";
    private static final String INVALIDFILENAME = "Invalid file name!";

    private boolean isEmptyString(String str) {
        return (str == null || "".equals(str.trim()));
    }

    private int pointPosInFileName(String fileName) {
        return fileName.lastIndexOf('.');
    }

    public char findLastCharacter(String str) {
        if (isEmptyString(str)) {
            throw new IllegalArgumentException(EMPTYSTRING);
        }
        return str.trim().charAt(str.trim().length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (isEmptyString(fileName)) {
            throw new IllegalArgumentException(INVALIDFILENAME);
        }
        String trimmedFileName = fileName.trim();
        int pointPos = pointPosInFileName(trimmedFileName);
        if (pointPos > 0) {
            return trimmedFileName.substring(pointPos);
        } else {
            throw new IllegalArgumentException(INVALIDFILENAME);
        }
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isEmptyString(fileName) || isEmptyString(ext) || pointPosInFileName(fileName) <= 0) {
            throw new IllegalArgumentException(INVALIDARGUMENT);
        }
        String fileExt = findFileExtension(fileName);
        return ext.equals(fileExt.replace(".", ""));
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isEmptyString(searchedFileName) || isEmptyString(actualFileName)) {
            throw new IllegalArgumentException(INVALIDARGUMENT);
        }

        String searchedFileNameLowerCaseExtension;
        String actualFileNameLowerCaseExtension;
        try {
            searchedFileNameLowerCaseExtension = changeExtensionToLowerCase(searchedFileName.trim());
            actualFileNameLowerCaseExtension = changeExtensionToLowerCase(actualFileName.trim());
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(iae.getMessage());
        }
        return searchedFileNameLowerCaseExtension.equals(actualFileNameLowerCaseExtension);

    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmptyString(fileName)) {
            throw new IllegalArgumentException(EMPTYSTRING);
        }
        String trimmedFileName = fileName.trim();
        int pointPos = pointPosInFileName(trimmedFileName);
        if (pointPos > 0) {
            return trimmedFileName.substring(0, pointPos) + trimmedFileName.substring(pointPos).toLowerCase();
        } else {
            throw new IllegalArgumentException(INVALIDARGUMENT);
        }
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmptyString(fileName)) {
            throw new IllegalArgumentException(EMPTYSTRING);
        }
        return fileName.replace(present, target);
    }

}
