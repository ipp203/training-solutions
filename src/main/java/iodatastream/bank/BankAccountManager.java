package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount bankAccount, Path path) {
        File file = new File(bankAccount.getAccountNumber() + ".dat");
        Path filePath = path.resolve(file.toPath());
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(filePath)))) {
            dos.writeUTF(bankAccount.getAccountNumber());
            dos.writeUTF(bankAccount.getOwner());
            dos.writeDouble(bankAccount.getBalance());
        } catch (IOException e) {
            throw new IllegalArgumentException("File can not write!", e);
        }

    }

    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(is))) {

            String accoutnNumber = dis.readUTF();
            String owner = dis.readUTF();
            double balance = dis.readDouble();
            return new BankAccount(accoutnNumber, owner, balance);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File can not read!", ioe);
        }


    }
}