package com.Belbim2.test;

import com.Belbim2.driver.Driver;
import com.Belbim2.methods.Methods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.Belbim2.driver.Driver.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testBelbim3 extends Driver{
    Methods methods;

    @Test
    public void gecersiz_birth_date_mesaji() {
        methods = new Methods();

        // İlk sayfada bazı işlemler yap
        methods.click(By.cssSelector(".Header_header__toggler__AuGOB"));
        methods.click(By.xpath("//a[.='Kişiselleştirme']"));

        // Yeni sekme aç ve o sekmeye git
        String currentWindowHandle = driver.getWindowHandle(); // Mevcut pencereyi sakla
        ((JavascriptExecutor) driver).executeScript("window.open('https://kisisellestirme.istanbulkart.istanbul/', '_blank');"); // Yeni sekme aç
        methods.waitBySeconds(2); // Sekmenin açılmasını bekle

        // İkinci sekmeye geçiş yap
        methods.sekmeDegistir("Yeni URL Sayfa Başlığı"); // Geçmek istediğiniz sekmenin başlığını yazın


        methods.click(By.xpath("//*[@id=\"personalization\"]/form/div[1]/div/div/input"));
        methods.sendKeys(By.xpath("//*[@id=\"personalization\"]/form/div[1]/div/div/input"),"7**********");
        methods.click(By.xpath("//*[@id=\"personalization\"]/form/div[2]/div/div/input"));
        methods.sendKeys(By.xpath("//*[@id=\"personalization\"]/form/div[2]/div/div/input"),"ebrar");
        methods.click(By.xpath("//*[@id=\"personalization\"]/form/div[3]/div/div/input"));
        methods.sendKeys(By.xpath("//*[@id=\"personalization\"]/form/div[3]/div/div/input"),"yiğit");
        methods.click(By.xpath("//*[@id=\"personalization\"]/form/div[4]/div/input"));
        methods.sendKeys(By.xpath("//*[@id=\"personalization\"]/form/div[4]/div/input"),"20******");
        methods.click(By.xpath("//*[@id=\"personalization\"]/form/div[5]/div/div/input"));
        methods.waitBySeconds(2);

        // Uyarı mesajının metnini alın
        String alertMessageText = methods.getMessageText(By.xpath("//*[@id=\"personalization\"]/form/div[5]/h4"));

        // Beklenen mesaj ile karşılaştırın
        String expectedMessage = "Lütfen geçerli bir doğum tarihi girin.";
        assertEquals(expectedMessage, alertMessageText, "Uyarı mesajı beklenen metni içermiyor.");

    }
}
