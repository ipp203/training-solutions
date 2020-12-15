package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    public void saveTransactions(Path path, List<Transaction> transactions) {

        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {

            for (Transaction transaction : transactions) {

                zos.putNextEntry(new ZipEntry(String.valueOf(transaction.getId()) + ".dat"));
                String str = transaction.getTime().toString() + "\n" +
                        transaction.getAccount() + "\n" +
                        String.valueOf(transaction.getAmount());
                zos.write(str.getBytes());

            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("File can not write", ioe);
        }
    }

}
