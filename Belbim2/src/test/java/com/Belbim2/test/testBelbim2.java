package com.Belbim2.test;

import com.Belbim2.driver.Driver;
import com.Belbim2.methods.Methods;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class testBelbim2 extends Driver {
    Methods methods;

    @Test
    public void kayitli_kart_uyari_mesaji() {
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
        methods.sendKeys(By.xpath("//*[@id=\"personalization\"]/form/div[4]/div/input"),"20122000");
        methods.click(By.xpath("//*[@id=\"personalization\"]/form/div[5]/div/div/input"));
        methods.sendKeys(By.xpath("//*[@id=\"personalization\"]/form/div[5]/div/div/input"),"ebraryigit02@gmail.com");
        methods.click(By.xpath("//*[@id=\"personalization\"]/form/div[6]/div[1]/div/input"));
        methods.sendKeys(By.xpath("//*[@id=\"personalization\"]/form/div[6]/div[1]/div/input"),"63706003********");
        methods.click(By.xpath("//*[@id=\"personalization\"]/form/div[7]/div[1]/div/input"));
        methods.sendKeys(By.xpath("//*[@id=\"personalization\"]/form/div[7]/div[1]/div/input"),"544*******");
        methods.waitBySeconds(2);

        methods.clickCheckbox(By.xpath("//*[@id=\"personalization\"]/form/div[9]/div[1]/div/span/span/input"));
        methods.click(By.xpath("//*[@id=\"personalization\"]/div/div/div[3]/div/div"));
        methods.click(By.xpath("//*[@id=\"personalization\"]/div/div/div[2]/div/button/span[1]"));
        methods.waitBySeconds(2);

        methods.clickCheckbox(By.xpath("//*[@id=\"personalization\"]/form/div[9]/div[2]/div/span/span/input"));
        methods.click(By.xpath("//*[@id=\"personalization\"]/div/div/div[3]/div/div"));
        methods.click(By.xpath("//*[@id=\"personalization\"]/div/div/div[2]/div/button[1]"));

        methods.clickCheckbox(By.xpath("//*[@id=\"personalization\"]/form/div[9]/div[3]/div/span/span/input"));
        methods.click(By.xpath("//*[@id=\"personalization\"]/div/div/div[2]/div/button[1]"));

        methods.clickCheckbox(By.xpath("//*[@id=\"personalization\"]/form/div[9]/div[4]/div/span/span/input"));
        methods.click(By.xpath("//*[@id=\"personalization\"]/div/div/div[2]/div/button[1]/span[1]"));

        methods.clickCheckbox(By.xpath("//*[@id=\"personalization\"]/form/div[9]/div[5]/div/span/span/input"));
        methods.click(By.xpath("//*[@id=\"personalization\"]/div/div/div[2]/div/button[1]"));

        // reCAPTCHA'yı tamamlamanız için bekleme süresi ekleyin
        methods.waitBySeconds(10); // reCAPTCHA'yı manuel olarak tamamlamak için 10 saniye bekleyin

        methods.click(By.xpath("//span[@class='MuiButton-label']"));
        methods.waitBySeconds(5);

        // Uyarı mesajının metnini alın
        String alertMessageText = methods.getMessageText(By.xpath("//*[@id=\"Alert\"]/div/span/div"));

        // Beklenen mesaj ile karşılaştırın
        String expectedMessage = "Girdiğiniz kart başka bir kullanıcı üzerine kayıtlıdır.";
        assertEquals(expectedMessage, alertMessageText, "Uyarı mesajı beklenen metni içermiyor.");

    }
}

