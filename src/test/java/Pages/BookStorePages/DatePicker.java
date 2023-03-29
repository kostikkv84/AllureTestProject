package Pages.BookStorePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DatePicker {
    private SelenideElement selectDate = $("#datePickerMonthYearInput");
    private SelenideElement selectDateAndTime = $("#datePickerMonthYearInput");
    private SelenideElement selectMonth = $(".react-datepicker__month-select");
    private SelenideElement selectMonth2 = $x("//div[@class=\"react-datepicker__header__dropdown react-datepicker__header__dropdown--scroll\"]");
    private SelenideElement selectYear = $(".react-datepicker__year-select");
    private SelenideElement selectYear2 = $(".react-datepicker__year-read-view");
    private SelenideElement selectMarch = $x("//option[@value=\"2\"]");
    private SelenideElement selectMarch2 = $x("//span[contains(text(),\"March\")]");

    private SelenideElement select2015 = $x("//option[@value=\"2015\"]");
    private SelenideElement upArrow = $(".react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-upcoming");

    private SelenideElement select2030 = $x("//span[contains(text(),\"2030\")]");
    private SelenideElement select15March2015 = $x("//div[@class=\"react-datepicker__week\"]//div[contains(text(),\"15\")]");

    String dateNow = selectDateAndTime.getAttribute("value");

    public void selectDate () {
        selectDate.shouldBe(visible).click();
        selectMonth.shouldBe(visible).click();
        selectMarch.shouldBe(visible).click();
        selectYear.shouldBe(visible).click();
        select2015.shouldBe(visible).click();
        select15March2015.click();
// проверка результата
        String result = selectDate.getAttribute("value");
        System.out.println(result);
        Assert.assertEquals("03/15/2015",result);
    }

    public void setSelectDateTwo () {
        selectDateAndTime.shouldBe(visible).click();
        sleep(2000);
        selectMonth2.shouldBe(visible).click();

        sleep(2000);
        selectMarch2.shouldBe(visible).click();
        sleep(2000);
        selectYear2.shouldBe(visible).click();
      for (int i = 0; i<5;i++){
          upArrow.click();
        }
        select2030.shouldBe(visible).click();

        sleep(3000);

    }

}
