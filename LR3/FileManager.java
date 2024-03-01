package LR3;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    private String fileName = null;

    public FileManager() {
        this("text.txt");
    }

    public FileManager(String fn) {
        this.setFileName(fn);
    }

    public void encryptToFile(long information) {
        try(FileWriter writer = new FileWriter(this.fileName)) {

            long encryptedInformation = Encrypter.convert(information);

            writer.append(Long.toString(encryptedInformation));
        }
        catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }

    public long decryptFile() {
        StringBuilder encryptedInfo = new StringBuilder();
        try(FileReader reader = new FileReader(this.fileName)) {
            int chr;
            while((chr=reader.read())!=-1){
                encryptedInfo.append((char)chr);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return Encrypter.convert(Long.parseLong(encryptedInfo.toString()));
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fn) {
        this.fileName = "D:\\information\\university\\TDSW\\LR3\\" + fn;
    }

    public int findSumAllDigits() {
        int sumAllDigits = 0;
        try(FileReader reader = new FileReader(this.fileName)) {
            int chr;
            while((chr=reader.read())!=-1){
                if (this.isDigit(chr)) {
                    sumAllDigits += chr - (int)'0';
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return sumAllDigits;
    }
    private boolean isDigit(int chr) {
        return chr >= (int)'0' && chr <= (int)'9';
    }
};
