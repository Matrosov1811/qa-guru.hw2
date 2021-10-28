package pav.matrosov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Some firstName");
        $("#lastName").setValue("Some lastName");
        $("#userEmail").setValue("example@email.qa");
        $(byText("Female")).click();
        $(byText("Other")).click();
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(".react-datepicker__navigation.react-datepicker__navigation--next").click();
        $(".react-datepicker__navigation.react-datepicker__navigation--previous").click();
        $$(".react-datepicker__day").find(text("18")).click();
        $("#subjectsInput").setValue("p").pressEnter();
        $("#subjectsInput").setValue("m").pressEnter();
        $(".css-19bqh2r").click();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        File file = $("#uploadPicture").uploadFile(new File("src/main/resources/qa-guru.PNG"));
        $("#currentAddress").setValue("Some address");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".modal-dialog.modal-lg").shouldHave(text("Thanks for submitting the form"));

        checkTable("Student Name", "Some firstName Some lastName");
        checkTable("Student Email", "example@email.qa");
        checkTable("Gender", "Male");
        checkTable("Mobile", "1234567890");
        checkTable("Date of Birth", "18 November,1995");
        checkTable("Subjects", "Maths");
        checkTable("Hobbies", "Sports, Reading, Music");
        checkTable("Picture", "qa-guru.PNG");
        checkTable("Address", "Some address");
        checkTable("State and City", "NCR Delhi");
    }

        private void checkTable(String label, String text) {
            $(".table-responsive").$(byText(label)).parent().shouldHave(text(text));
        }
    }


