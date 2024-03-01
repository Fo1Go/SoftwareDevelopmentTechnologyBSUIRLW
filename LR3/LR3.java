package LR3;

// Работа со строками. Чтение исходной строки осуществлять из текстового файла,
// для результирующей строки применить стандартный алгоритм шифрования и записать в файл.
// При выполнении следующих заданий для вывода результатов создавать новую директорию
// и файл средствами класса File.
// 21. В заданном тексте найти сумму всех встречающихся цифр.

public class LR3 {
    public static void main(String[] args) {
        FileManager file = new FileManager("text.txt");
        long sumAllDigits = file.findSumAllDigits();
        System.out.println("Sum all digits in file " + file.getFileName() + "  is equal to " + sumAllDigits);
        file.setFileName("output.txt");
        file.encryptToFile(sumAllDigits);
        sumAllDigits = file.decryptFile();
        System.out.println("Information from file " + file.getFileName() + " is " + sumAllDigits);
    }
}