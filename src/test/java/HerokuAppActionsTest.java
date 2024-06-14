import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class HerokuAppActionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }


    SelenideElement elemB = $("#column-b");
    SelenideElement elemA = $("#column-a");

    @Test
    void changeBlocksTest() {
        open("");
        actions().clickAndHold(elemB).moveToElement(elemA).release().perform();
        $(elemB).shouldHave(text("A"));
        $(elemA).shouldHave(text("B"));
    }

    @Test
    void dragAndDropTest () {
        open("");
        $(elemB).dragAndDrop(to(elemA));
        // elemB.dragAndDropTo(elemA); можно так?
        $(elemB).shouldHave(text("A"));
        $(elemA).shouldHave(text("B"));

    }

}
