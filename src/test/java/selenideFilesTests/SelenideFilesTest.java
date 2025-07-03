package selenideFilesTests;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {

//    static {
//        Configuration.fileDownload = FileDownloadMode.PROXY;
//    }

    @Test
    void selenideDownloadTest() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("#raw-url").download();

        try (InputStream is = new FileInputStream(downloadedFile)) {
            byte[] bytes = is.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of the next generation");
        }
    }

    @Test
    void selenideUploadFile() throws IOException {
        open("https://fineuploader.com/demos.html");
        $("input[type='file']").uploadFromClasspath("img/image.png");
        $("div.qq-file-info").shouldHave(text("image.png"));
    }
}