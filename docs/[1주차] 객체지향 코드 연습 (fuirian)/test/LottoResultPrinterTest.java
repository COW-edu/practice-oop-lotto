package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class LottoResultPrinterTest {

    @DisplayName("로또 결과 출력 테스트")
    @Test
    public void testLottoResultPrinter() {
        // given
        List<String> results = new ArrayList<>();
        results.add("1등: 5개 일치");
        results.add("2등: 4개 일치, 보너스 볼 일치");
        results.add("3등: 4개 일치");
        results.add("4등: 3개 일치");
        results.add("5등: 2개 일치");

        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter();

        // when
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        lottoResultPrinter.printResults(results);

        // then
        String printedOutput = outputStream.toString().trim();
        String[] lines = printedOutput.split(System.lineSeparator());
        assertEquals(5, lines.length);

        assertTrue(lines[0].contains("1등: 5개 일치"));
        assertTrue(lines[1].contains("2등: 4개 일치, 보너스 볼 일치"));
        assertTrue(lines[2].contains("3등: 4개 일치"));
        assertTrue(lines[3].contains("4등: 3개 일치"));
        assertTrue(lines[4].contains("5등: 2개 일치"));
    }
}

class LottoResultPrinter {
    public void printResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }
}

