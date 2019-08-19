package com.mjq.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @Description:
 * @Author: majingqiang
 * @Date: 2019-04-25 16:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


    @Test
    public void unZip() {
        String targetDir = "/Users/xiaowei/Downloads/testzip/22240/";
        HttpURLConnection conn = null;
        String strUrl = "https://wyatest.oss-cn-hangzhou.aliyuncs.com/xls/wya_cert.zip";
        String zipPath = "";
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            String file = conn.getURL().getFile();
            String fileName = file.substring(file.lastIndexOf('/') + 1);
            InputStream is = conn.getInputStream();
            File zip = new File(targetDir);
            if (!zip.exists()) {
                zip.mkdirs();
            }
            zipPath = targetDir + fileName;
            OutputStream out = new FileOutputStream(zipPath);
            byte[] buf = new byte[2048];
            int len;
            while ((len = is.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            is.close();
            out.close();
        } catch (Exception e) {

        }


        File zipFile = new File(zipPath);
        ZipFile zip = null;
        try {
            zip = new ZipFile(zipFile, Charset.forName("gbk"));//防止中文目录，乱码
            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zip.getInputStream(entry);
                //指定解压后的文件夹+当前zip文件的名称
                String outPath = (targetDir + zipEntryName).replace("/", File.separator);
                //判断路径是否存在,不存在则创建文件路径
                File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
                if (!file.exists()) {
                    file.mkdirs();
                }
                //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if (new File(outPath).isDirectory()) {
                    continue;
                }
                //保存文件路径信息（可利用md5.zip名称的唯一性，来判断是否已经解压）
                System.err.println("当前zip解压之后的路径为：" + outPath);
                OutputStream out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[2048];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
            }
            //必须关闭，要不然这个zip文件一直被占用着，要删删不掉，改名也不可以，移动也不行，整多了，系统还崩了。
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void decode() {
        String key = "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";

        byte[] cert = Base64.getDecoder().decode(key);
        String c = new String(cert);
    }

    @Test
    public void testCert() {
        File file = new File("/Users/xiaowei/Downloads/1333182201_20190605_cert/apiclient_cert.p12");
        try {
            InputStream is = new FileInputStream(file);
            byte[] cert = new byte[(int) file.length()];
            is.read(cert);
            String c = new String(cert);
            String en = Base64.getEncoder().encodeToString(cert);
            //byte[] de = Base64.getDecoder().decode(en);
            System.out.println(en);
        } catch (Exception e) {

        }

    }

    @Test
    public void testOptional() {
        BigDecimal b = BigDecimal.ZERO;
        System.out.println(b);

    }


    @Test
    public void updateTxt() {
        File file = new File("/Users/xiaowei/Downloads/[阅次元下载www.abooky.com]娱乐春秋.txt");
        File newFile = new File("/Users/xiaowei/book/bbb.txt");

        try {
            //FileWriter fw = new FileWriter(newFile);
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "utf-8")));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GB18030"));
            String line = "";
            while ((line = br.readLine()) != null) {
                out.write(line+"\n");
                System.out.println(line);
            }
            br.close();
            out.close();

        } catch (Exception e) {

        }

    }

}
