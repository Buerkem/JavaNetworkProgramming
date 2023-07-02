package Streams;//This code demonstrates writing to output
//generateCharactersArray writes an array of characters to System.out
//generateSeven writes only seven to System.out
//generateCharacters writes only characters to System.out

import java.io.IOException;
import java.io.OutputStream;

public class CharacterGenerator {
    public static void generateCharactersArray(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine + 2];
// the +2 is for the carriage return and linefeed
        while (true) { /* infinite loop */
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte) ((i - firstPrintableCharacter)
                        % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            line[72] = (byte) '\r'; // carriage return
            line[73] = (byte) '\n'; // line feed
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter;
        }
    }
    public static void generateSeven(OutputStream out) throws IOException{
        int seven_ascii = 55;
        for (int i=0; i<10; i++){
            out.write(seven_ascii);
        }
        out.write('\r'); // carriage return
        out.write('\n'); // linefeed
    }
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;

        while (true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                out.write(((i - firstPrintableCharacter) % numberOfPrintableCharacters) + firstPrintableCharacter);
            }

            out.write('\r'); // carriage return
            out.write('\n'); // linefeed

            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
        }
    }

    public static void main(String[] args) {
        try {
            generateCharactersArray(System.out);
            //generateCharacters(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}