package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Common web widgets")
class WidgetsTest extends BaseTest {

    @ParameterizedTest(name = "Select {0}")
    @ValueSource(strings = {"Option 1", "Option 2"})
    void dropdownSelect(String option) {
        DropdownPage page = new DropdownPage(driver).open();
        page.select(option);

        assertEquals(option, page.getSelected(),
                "Dropdown phải hiển thị lựa chọn vừa chọn");
    }

    @Test
    void checkboxToggle() {
        CheckboxesPage page = new CheckboxesPage(driver).open();
        page.check(0);
        page.uncheck(1);

        assertAll(
                () -> assertTrue(page.isChecked(0),
                        "Checkbox đầu phải được chọn"),
                () -> assertFalse(page.isChecked(1),
                        "Checkbox thứ hai phải được bỏ chọn")
        );
    }

    @Test
    void jsAlerts() {
        JsAlertsPage page = new JsAlertsPage(driver).open();

        page.acceptAlert();
        assertEquals("You successfully clicked an alert",
                page.getResult(), "Kết quả sau khi chấp nhận alert");

        page.dismissConfirm();
        assertEquals("You clicked: Cancel",
                page.getResult(), "Kết quả sau khi hủy confirm");

        page.answerPrompt("SWT301");
        assertEquals("You entered: SWT301",
                page.getResult(), "Kết quả phải chứa nội dung đã nhập");
    }

    @ParameterizedTest(name = "Dynamic loading example {0}")
    @ValueSource(ints = {1, 2})
    void dynamicLoading(int example) {
        String text = new DynamicLoadingPage(driver)
                .open(example)
                .startAndGetResult();

        assertEquals("Hello World!", text,
                "Nội dung phải xuất hiện sau khi tải xong");
    }
}