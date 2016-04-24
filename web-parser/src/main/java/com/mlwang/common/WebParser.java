package com.mlwang.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.xmlcommons.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebParser {
    private static Logger logger = LoggerFactory.getLogger(WebParser.class); 
    public static void oldFun() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
        String str;
        //创建一个webclient
        WebClient webClient = new WebClient();
        //htmlunit 对css和javascript的支持不好，所以请关闭之
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        //获取页面
        HtmlPage page = webClient.getPage("http://shenbai.iteye.com/blog/1985844");
        //获取页面的TITLE
/*        str = page.getTitleText();
        System.out.println(str);*/
        //获取页面的XML代码
        str = page.asXml();
        System.out.println(str);

        //获取页面的文本
/*        str = page.asText();
        System.out.println(str);
        outputFile("html01.txt",str);*/
        //关闭webclient
        webClient.closeAllWindows();
    }
    
    public static void outputFile(String fileName,String content){
        String path = "D:/123fly/data/"+fileName;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(path));
            fos.write(content.getBytes()); 
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static String getWebHtml(String url){
        String rst = null;
        WebClient webClient = null;
        try {
            //创建一个webclient
            webClient = new WebClient();
            //htmlunit 对css和javascript的支持不好，所以请关闭之
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);
            //获取页面
            HtmlPage page = webClient.getPage(url);
            //获取页面的XML代码
            rst = page.asXml();
        } catch (FailingHttpStatusCodeException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(webClient != null){
                //关闭webclient
                webClient.close();
            }
        }
        return rst;
    }
    
    public static void getWebHtml(String words,String filenName){
        String sword;
        try {
            sword = java.net.URLEncoder.encode(words, "utf-8");
            String url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd="+sword+"&rsv_pq=8a964d61002267f9&rsv_t=d45erc7tBNke%2FgUBAoDuqkcrskDWvyXHAlpRSPiRqcGiRD9LhSccCEI3hec&rsv_enter=1&rsv_sug3=5&rsv_sug1=2&rsv_sug7=100";
            logger.info("开始获取html");
            String html = getWebHtml(url);
            logger.info("获取html完成");
            outputFile(words+".html",html);
            logger.info("输出完成");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    public static HtmlPage getWebPage(String url){
        HtmlPage page = null;
        WebClient webClient = null;
        try {
            //创建一个webclient
            webClient = new WebClient();
            //htmlunit 对css和javascript的支持不好，所以请关闭之
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);
            //获取页面
            page = webClient.getPage(url);
        } catch (FailingHttpStatusCodeException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(webClient != null){
                //关闭webclient
                webClient.close();
            }
        }
        return page;
    }
    
    public static void testParse(){
        String url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=10018800_hao_pg&wd=%E6%89%8B%E8%A1%A8&oq=%E5%BC%A0%E5%BE%B7%E6%B1%9F&rsv_pq=f8a5a01b00248895&rsv_t=d39dstB7yh4vp4nHHSCvWknl3a46tTaF81oPzXHuBs7%2FusaRsddiaKvcVg4%2FBp7nPeapIRAe&rsv_enter=1&rsv_sug3=11&rsv_sug1=10&rsv_sug7=100&rsv_sug2=0&inputT=2429&rsv_sug4=2429";
        HtmlPage page = getWebPage(url);
        HtmlElement  h1 = page.getHtmlElementById("10");
        System.out.println("h1="+h1.asXml());
        System.out.println("h1--------------------------------------");
/*        
        HtmlElement  h2 = page.getBody();
        System.out.println("h2="+h2.asXml());
        System.out.println("h2--------------------------------------");
        
        HtmlElement  h3 = page.getDocumentElement();
        System.out.println("h3="+h3.asXml());
        System.out.println("h3--------------------------------------");
        
        DomElement  h4 = page.getElementById("10");
        System.out.println("h4="+h4.asXml());
        System.out.println("h4--------------------------------------");*/
        
        
/*        List<HtmlElement> list = htmlBody.getElementsByAttribute("div", "class", "result c-container");
        for(HtmlElement item : list){
            System.out.println("--------------------------------");
            System.out.println(item.asXml());
        }*/
    }
    
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        //getWebHtml("明天","明天");
        //testParse();
        oldFun();
    }

}
