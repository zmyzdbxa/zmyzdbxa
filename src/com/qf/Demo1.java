package com.qf;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;


public class Demo1 {
    public static void main(String[] args) throws AWTException {
        String sentence = "what are you doing now shao先森";// 定义要发送的话
        Robot robot = new Robot();// 创建Robot对象（机器人）
        robot.delay(3000);// 延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        String[] authors = sentence.split("[,]");// 字符串根据,分割
        for (int j = 0; j < 29; j++) {//循环次数
            for (int i = 0; i < authors.length; i++) {
                String sentencet = authors[i];
                Transferable tText = new StringSelection(sentencet);
                clip.setContents(tText, null);
                // 按下了ctrl+v，完成粘贴功能
                robot.keyPress(KeyEvent.VK_CONTROL);// 按下Control键
                robot.keyPress(KeyEvent.VK_V);// 按下V键
                robot.keyRelease(KeyEvent.VK_CONTROL);// 释放ctrl按键
                robot.delay(10);// 延迟一秒再发送
                robot.keyPress(KeyEvent.VK_ENTER);// 回车
            }
        }
    }
}
