/**
 * NoraUi is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 * 
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.noraui.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstSimpleBot {

    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FirstSimpleBot.class);

    public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        WebDriver driver = new ChromeDriver(capabilities);
        for (int i = 0; i < 6; i++) {
            driver.get("http://www.google.com/ncr");
            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys("BreizhCamp 2018");
            element.submit();
            logger.info(driver.getTitle());
            WebElement r = driver.findElement(By.xpath("//*[@id='resultStats']"));
            logger.info(r.getText());
        }
        driver.quit();
    }

}