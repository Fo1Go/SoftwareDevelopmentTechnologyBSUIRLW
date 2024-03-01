package LR3;

public class Encrypter {
    static long convert(long number) {
        long mask = 0b01010101010101010101010101010101;
        return (long)((~number) ^ mask);
    }
};

