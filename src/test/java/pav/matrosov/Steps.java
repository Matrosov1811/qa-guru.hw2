package pav.matrosov;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Steps {

    public void step1 () {
        $("#firstName").setValue("Some firstName");
        $("#lastName").setValue("Some lastName");
        $("#userEmail").setValue("example@email.qa");
    }

    public void step2 () {
        $(byText("Female")).click();
        $(byText("Other")).click();
        $(byText("Male")).click();
    }


}
