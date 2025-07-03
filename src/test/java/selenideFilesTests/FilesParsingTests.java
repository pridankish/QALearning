package selenideFilesTests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingTests {

    ClassLoader cl = FilesParsingTests.class.getClassLoader();

    @Test
    void pdfParseTest() throws IOException {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadedPdf = $("a[href='junit-user-guide-5.9.1.pdf']").download();
        PDF content = new PDF(downloadedPdf);
        assertThat(content.author).contains("Sam Brannen");
    }

    @Test
    void xlsParseTest() throws Exception {
        try (InputStream resourceAsStream = cl.getResourceAsStream("sample-xlsx-file.xlsx")) {
            XLS content = new XLS(resourceAsStream);
            assertThat(content.excel.getSheetAt(0 ).getRow(1).getCell(1).getStringCellValue()).contains("Dulce");
        }
    }
}
