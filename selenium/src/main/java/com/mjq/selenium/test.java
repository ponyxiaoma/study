package com.mjq.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by majingqiang on 2018/12/4.
 */
public class test {

    public static void main(String[] args) {
        //指定浏览器驱动路径
        System.setProperty("webdriver.chrome.driver", "D:\\plugins\\chromedriver\\chromedriver.exe");

        //初始化浏览器名为driver
        WebDriver driver = new ChromeDriver();

        //窗口最大化
        driver.manage().window().maximize();

        //使用get()方法，打开pms网址
        driver.get("https://pay.ruishan666.com/login");

        //判断网页标题是是否是"百度一下，你就知道"


        try {
            driver.findElement(By.xpath("//form[@class='el-form login-form']//input[@placeholder='请输入用户名']")).sendKeys("test1");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//form[@class='el-form login-form']//input[@placeholder='请输入登录密码']")).sendKeys("123456");
            Thread.sleep(2000);
            WebElement webElement = driver.findElement(By.xpath("//form//button"));
            webElement.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='el-dialog__wrapper phone-check']//input[@placeholder='请输入验证码']")).sendKeys("8888");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='el-dialog__wrapper phone-check']//button[@class='el-button el-button--primary el-button--mini']")).click();
            Thread.sleep(2000);
            if ("交易订单".equals(driver.getTitle())) {
                System.out.println("ok");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        //关闭并退出浏览器
        driver.quit();
    }
}
