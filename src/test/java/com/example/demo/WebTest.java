package com.example.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebTest {

    @Test
    void MainPage() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\mir-u\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        assertEquals("Главная страница", driver.getTitle());
        driver.quit();
    }

    @Test
    void HeaderTest() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\mir-u\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("http://localhost:8080/");

        WebElement objectsButton = driver.findElement(By.id("objectsListLink"));
        objectsButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals("Объекты", driver.getTitle());

        WebElement rootButton = driver.findElement(By.id("rootLink"));
        rootButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals("Главная страница", driver.getTitle());

        WebElement usersButton = driver.findElement(By.id("usersListLink"));
        usersButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals("Сообщество", driver.getTitle());

        rootButton = driver.findElement(By.id("rootLink"));
        rootButton.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals("Главная страница", driver.getTitle());

        driver.quit();
    }

    @Test
    void addReaction() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\mir-u\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/picture?pictureId=5");
        assertEquals("Информация о фотографии", driver.getTitle());

        WebElement addReaction = driver.findElement(By.id("submitButtonAdd"));
        addReaction.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals("Добавить реакцию", driver.getTitle());

        driver.findElement(By.id("nickname")).sendKeys("d_artagnan");
        driver.findElement(By.id("password")).sendKeys("SRdMtp");
        WebElement like_react = driver.findElement(By.id("reaction1"));
        like_react.click();
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

        assertEquals("Информация о фотографии", driver.getTitle());
        WebElement pictureInfo = driver.findElement(By.id("pictureInfo"));
        List<WebElement> cells = pictureInfo.findElements(By.tagName("p"));

        assertEquals("Автор: milady", cells.get(0).getText());
        assertEquals("\uD83D\uDE0D: 2", cells.get(3).getText());

        driver.quit();
    }

    @Test
    void addPicture() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\mir-u\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/object?objectId=4");
        assertEquals("Информация об объекте", driver.getTitle());

        WebElement addPicture = driver.findElement(By.id("submitButtonAdd"));
        addPicture.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        assertEquals("Добавить фотографию", driver.getTitle());

        driver.findElement(By.id("nickname")).sendKeys("d_artagnan");
        driver.findElement(By.id("password")).sendKeys("SRdMtp");
        driver.findElement(By.id("telescope2")).click();
        driver.findElement(By.id("imageUpload")).sendKeys("C:\\Users\\mir-u\\Downloads\\Moon.jpg");
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

        assertEquals("Информация об объекте", driver.getTitle());

        WebElement pictureInfo = driver.findElement(By.id("objectInfo"));
        List<WebElement> cells = pictureInfo.findElements(By.tagName("p"));
        assertEquals("Название: Луна", cells.get(0).getText());

        WebElement objectPictures = driver.findElement(By.id("objectPictures"));
        List<WebElement> pics = objectPictures.findElements(By.tagName("a"));
        boolean newPic = false;
        for (WebElement pic : pics) {
            WebElement picInfo = pic.findElement(By.tagName("img"));
            if (picInfo.getAttribute("src").equals("http://localhost:8080/images/Moon.jpg")) {
                newPic = true;
            }
        }
        assertEquals(true, newPic);
        driver.quit();
    }

    @Test
    void getUserInfo() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\mir-u\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/picture?pictureId=4");
        assertEquals("Информация о фотографии", driver.getTitle());

        WebElement pictureInfo = driver.findElement(By.id("pictureInfo"));
        List<WebElement> cells = pictureInfo.findElements(By.tagName("p"));

        assertEquals("Автор: d_artagnan", cells.get(0).getText());
        cells.get(0).findElement(By.id("userLink")).click();
        assertEquals("Информация о пользователе", driver.getTitle());

        WebElement userInfo = driver.findElement(By.id("userInfo"));
        cells = userInfo.findElements(By.tagName("p"));
        assertEquals("Имя: Charles", cells.get(0).getText());
        assertEquals("Фамилия: Batz", cells.get(1).getText());
        assertEquals("Местоимения: он/его", cells.get(2).getText());

        WebElement userPictures = driver.findElement(By.id("userPictures"));
        List<WebElement> pics = userPictures.findElements(By.tagName("a"));
        boolean newPic = false;
        Integer picCount = 0;
        for (WebElement pic : pics) {
            picCount = picCount + 1;
            WebElement picInfo = pic.findElement(By.tagName("img"));
            if (picInfo.getAttribute("src").equals("http://localhost:8080/images/Moon.jpg")) {
                newPic = true;
            }
        }
        assertEquals(2, picCount);
        assertEquals(true, newPic);

        driver.findElement(By.id("usersListLink")).click();
        assertEquals("Сообщество", driver.getTitle());

        WebElement usersTable = driver.findElement(By.id("usersTable"));

        List<WebElement> usersInTable = usersTable.findElements(By.tagName("tr"));
        WebElement d_artagnanUser = null;
        for (WebElement userInTable : usersInTable) {
            List<WebElement> cols = userInTable.findElements(By.tagName("td"));
            if (cols.size() == 0) {
                continue;
            }

            WebElement firstCol = cols.get(0);
            if (firstCol.findElement(By.tagName("span")).getText().equals("d_artagnan")) {
                d_artagnanUser = firstCol.findElement(By.id("userLink"));
            }
        }
        d_artagnanUser.click();
        assertEquals("Информация о пользователе", driver.getTitle());

        userInfo = driver.findElement(By.id("userInfo"));
        cells = userInfo.findElements(By.tagName("p"));
        assertEquals("Имя: Charles", cells.get(0).getText());
        assertEquals("Фамилия: Batz", cells.get(1).getText());
        assertEquals("Местоимения: он/его", cells.get(2).getText());

        userPictures = driver.findElement(By.id("userPictures"));
        pics = userPictures.findElements(By.tagName("a"));
        newPic = false;
        picCount = 0;
        for (WebElement pic : pics) {
            picCount = picCount + 1;
            WebElement picInfo = pic.findElement(By.tagName("img"));
            if (picInfo.getAttribute("src").equals("http://localhost:8080/images/Moon.jpg")) {
                newPic = true;
            }
        }
        assertEquals(2, picCount);
        assertEquals(true, newPic);

        driver.quit();
    }

    @Test
    void SearchClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\mir-u\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/objects");
        assertEquals("Объекты", driver.getTitle());

        WebElement objectsTable = driver.findElement(By.id("objectsTable"));

        List<WebElement> objectsInTable = objectsTable.findElements(By.tagName("tr"));
        WebElement starObject = null;
        for (WebElement objectInTable : objectsInTable) {
            List<WebElement> cols = objectInTable.findElements(By.tagName("td"));
            if (cols.size() == 0 || cols.size() == 1) {
                continue;
            }

            WebElement classCol = cols.get(1);
            if (classCol.findElement(By.tagName("span")).getText().equals("звезда")) {
                starObject = classCol.findElement(By.id("objectClassLink"));
                break;
            }
        }
        starObject.click();
        assertEquals("Объекты класса", driver.getTitle());
        WebElement objectsClassTable = driver.findElement(By.id("objectsClassTable"));

        List<WebElement> objectsClassInTable = objectsClassTable.findElements(By.tagName("tr"));
        boolean isSun = false;
        int starCount = 0;
        for (WebElement objectClassInTable : objectsClassInTable) {
            List<WebElement> cols = objectClassInTable.findElements(By.tagName("td"));
            if (cols.size() == 0) {
                continue;
            }
            starCount = starCount + 1;
            WebElement classCol = cols.get(0);
            if (classCol.findElement(By.tagName("span")).getText().equals("Солнце")) {
                isSun = true;
            }
        }
        assertEquals(true, isSun);
        assertEquals(3, starCount);


        driver.quit();
    }

    @Test
    void Search() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\mir-u\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/objects");
        assertEquals("Объекты", driver.getTitle());

        driver.findElement(By.id("searchText")).sendKeys("звёздное скопление");
        driver.findElement(By.id("searchSubmitButton")).click();
        WebElement objectsTable = driver.findElement(By.id("objectsTable"));

        List<WebElement> objectsInTable = objectsTable.findElements(By.tagName("tr"));
        boolean searchTarget = false;
        int searchCount = 0;
        for (WebElement objectInTable : objectsInTable) {
            List<WebElement> cols = objectInTable.findElements(By.tagName("td"));
            if (cols.size() == 0) {
                continue;
            }
            searchCount = searchCount + 1;
            WebElement classCol = cols.get(0);
            if (classCol.findElement(By.tagName("span")).getText().equals("M41/Скопление малый улей")) {
                searchTarget = true;
            }
        }
        assertEquals(1, searchCount);
        assertEquals(true, searchTarget);
        driver.findElement(By.id("resetSubmitButton")).click();

        driver.findElement(By.id("searchText")).sendKeys("Меркурий");
        driver.findElement(By.id("searchSubmitButton")).click();
        objectsTable = driver.findElement(By.id("objectsTable"));

        objectsInTable = objectsTable.findElements(By.tagName("tr"));
        searchTarget = false;
        searchCount = 0;
        for (WebElement objectInTable : objectsInTable) {
            List<WebElement> cols = objectInTable.findElements(By.tagName("td"));
            if (cols.size() == 0) {
                continue;
            }
            searchCount = searchCount + 1;
            WebElement classCol = cols.get(0);
            if (classCol.findElement(By.tagName("span")).getText().equals("Меркурий")) {
                searchTarget = true;
            }
        }
        assertEquals(1, searchCount);
        assertEquals(true, searchTarget);
        driver.findElement(By.id("resetSubmitButton")).click();

        driver.findElement(By.id("searchText")).sendKeys("Андерсон");
        driver.findElement(By.id("searchSubmitButton")).click();
        objectsTable = driver.findElement(By.id("objectsTable"));

        objectsInTable = objectsTable.findElements(By.tagName("tr"));
        searchTarget = false;
        searchCount = 0;
        for (WebElement objectInTable : objectsInTable) {
            List<WebElement> cols = objectInTable.findElements(By.tagName("td"));
            if (cols.size() == 0) {
                continue;
            }
            searchCount = searchCount + 1;
            WebElement classCol = cols.get(0);
            if (classCol.findElement(By.tagName("span")).getText().equals("GK Персея")) {
                searchTarget = true;
            }
        }
        assertEquals(2, searchCount);
        assertEquals(true, searchTarget);
        driver.findElement(By.id("resetSubmitButton")).click();

        driver.findElement(By.id("searchText")).sendKeys("комета");
        driver.findElement(By.id("searchSubmitButton")).click();
        objectsTable = driver.findElement(By.id("objectsTable"));

        objectsInTable = objectsTable.findElements(By.tagName("tr"));
        searchTarget = false;
        searchCount = 0;
        for (WebElement objectInTable : objectsInTable) {
            List<WebElement> cols = objectInTable.findElements(By.tagName("td"));
            if (cols.size() == 0) {
                continue;
            }
            searchCount = searchCount + 1;
            WebElement classCol = cols.get(0);
            if (classCol.findElement(By.tagName("span")).getText().equals("205P/Джакобини")) {
                searchTarget = true;
            }
        }
        assertEquals(3, searchCount);
        assertEquals(true, searchTarget);
        driver.findElement(By.id("resetSubmitButton")).click();

        driver.quit();
    }
}