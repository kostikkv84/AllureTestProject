

import Pages.BookStorePages.BooksStorePage;
import Pages.BookStorePages.LoginInBookStorePage;
import Pages.BookStorePages.MainPage;
import com.codeborne.selenide.Selenide;
import interactions.Droppable;
import interactions.Resizable;
import interactions.Sortable;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class TestCreate extends BaseTest{
    private final static String BASE_URL = "https://demoqa.com/";

    @Test
    @DisplayName("Check report allure")
    public void baseCheckTestProject() {
        int i = 1;
        Assert.assertEquals(1,i);
    }

    /**
     * Проверка Хедера
     */
    @Test
    public void checkMainPageHeader(){
        MainPage mainPage = new MainPage(BASE_URL);
        Assert.assertEquals("Selenium Online Training",mainPage.checkMainPageHeader());
    }

    /**
     * Проверка отображения необходимости верифицировать captcha при регистрации
     */
    @Test
    public void checkCaptchaError() {
        Assert.assertTrue(new MainPage(BASE_URL).
                goToBookStore().
                loginInToBookStore().
                newUser().
                register(BASE_FIRST_NAME, BASE_LAST_NAME, BASE_USER_NAME, BASE_PASSWORD).
                getErrorCaptcha().
                contains("Please verify reCaptcha to register!"));
    }

    /**
     * Успешное логирование - Test
     */
    @Test
    public void loginBookStore () {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.goToBookStore();
        BooksStorePage booksStorePage = new BooksStorePage();
        booksStorePage.loginInToBookStore();
        LoginInBookStorePage loginInBookStorePage = new LoginInBookStorePage();
        loginInBookStorePage.login(BASE_USER_NAME,BASE_PASSWORD);

        Assert.assertEquals("Log out", loginInBookStorePage.getLogOutButton());

   /*     Assert.assertTrue(new MainPage(BASE_URL)
                .goToBookStore()
                .loginInToBookStore()
                .login(BASE_USER_NAME,BASE_PASSWORD)
                .getLogOutButton()
                .contains("Log out"));  */
    }

    /**
     * Проверка, что список сортируется. Сравниваем список до сортировки со списком после сортировки.
     */
    @Test
    public void sortListElementsTest(){
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.goToInteraction();
        Sortable sortable = new Sortable();
        sortable.openSortable(); // открыли меню список;
        List<String> list1 = sortable.getCollectionList();// получаем список изначальный
        sortable.sortList();
         delay(1000);
        // сортируем список
        List<String> list2 = sortable.getCollectionList(); // получаем новый список
        Assert.assertNotEquals(list1,list2);           // сравниваем списки (не должны быть равны)

    }

  // Доделать сортировку грид, где нет привязки к элементам.
  //  @Test
    public void sortGridElementsTest () {
        MainPage mainPage = new MainPage(BASE_URL);
            mainPage.goToInteraction();
        Sortable sortablePage = new Sortable();
            sortablePage.openSortable();
            sortablePage.openGridTab();
        List<String> grid1 = sortablePage.getCollectionGrid();
            delay(5000);
            sortablePage.sortGrid();
            delay(5000);
        List<String> grid2 = sortablePage.getCollectionGrid();
        Assert.assertNotEquals(grid1,grid2);
        }

    /**
     * Тест - resize div - изменение окна дива.
     */
    @Test
    public void resizeElem () {
        Resizable resizable = new Resizable();
        String style1 = resizable.getStyle();
        System.out.println(style1);
        resizable.resize1();
        String style2 = resizable.getStyle();
        System.out.println(style2);
        Assert.assertNotEquals("Размер дива не изменился",style1,style2);
    }

    /**
     * Тест - Перетаскивание элемента
     */
    @Test
    public void dropElemTest(){
        Droppable droppable = new Droppable();
        String style1 = droppable.getAttributeDropElem();
        System.out.println(droppable.getAttributeDropElem());
        droppable.dragNDropElem();
        String style2 = droppable.getAttributeDropElem();
        System.out.println(droppable.getAttributeDropElem());
        Assert.assertNotEquals("Что-то пошло не так ) ",style1,style2);
    }

    /**
     * Accordian - открытие текста 1 по клику на заголовок
     */
    @Test
    public void accordian1ClickTest(){
        new MainPage(BASE_URL).goToWidgets().
                goToAccordianPage().cardHeaderClick().getAccordionContentTest("Контент1");
        sleep(2000);
    }
    /**
     * Accordian - открытие текста 2 по клику на заголовок
     */
    @Test
    public void accordian2ClickTest(){
        new MainPage(BASE_URL).goToWidgets().
                goToAccordianPage().cardHeaderClick().getAccordionContentTest("Контент2");
        sleep(2000);
    }
    /**
     * Accordian - открытие текста 3 по клику на заголовок
     */
    @Test
    public void accordian3ClickTest(){
        new MainPage(BASE_URL).goToWidgets().
                goToAccordianPage().cardHeaderClick().getAccordionContentTest("Контент3");
        sleep(2000);
    }

    /**
     * Выбор даты из календаря- Тест
     */
    @Test
    public void selectDateTest () {
        new MainPage(BASE_URL).goToWidgets().goToDatePicker().selectDate();
    }

    /**
     * Доделать проверку ввода даты и времени
     */
    @Test
    @Ignore
    public void selectDateAndTime () {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.goToWidgets().goToDatePicker().setSelectDateTwo();
    }

    /**
     * Тест прогресс бара
     */
    @Test
    public void progressBarTest() {
        new MainPage(BASE_URL).goToWidgets().goToProgressBar().start();
    }

    /**
     * Всплывающее сообщение при наведении на кнопку, тест
     */
    @Test
    public void ToolTipButtonHoverTest(){
        new MainPage(BASE_URL).goToWidgets().goToToolTipPage().buttonHover();
    }
    /**
     * Всплывающее сообщение при наведении на инпут, тест
     */
    @Test
    public void ToolTipInputHoverTest(){
        new MainPage(BASE_URL).goToWidgets().goToToolTipPage().inputHover();
    }

    @Test
    @Ignore
    public void SelectMenuTest(){
        new MainPage(BASE_URL).goToWidgets().goToSelectMenu().selectValue();
    }


}



