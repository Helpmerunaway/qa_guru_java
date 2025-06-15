package l9.pages_and_hw.components;

import static com.codeborne.selenide.Selenide.$;

public class UploadPicture {
    public void setPicture(String path) {
        $("#uploadPicture").uploadFromClasspath(path);
    }
}
