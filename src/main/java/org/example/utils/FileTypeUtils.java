package org.example.utils;

import java.util.Locale;

public class FileTypeUtils {

    public static String getfiletype(String filename){
        filename=filename.toLowerCase(Locale.ROOT);
        String s="unknowfile.png";
        String imgs="jpg;jpeg;png;bmp;gif;webp;ico";
        String codes="js;css;txt;xml;shtml;html;htm;csv;bat";
        String videos="avi;mkv;wmv;mp4;mov;flv;rm;rmvb;swf";
        String music="mp3;wav;rmi;aac;ogg;flac";
        String rar="rar;7z;zip;gzip;dmg;gz;ios;tar;jar";
        String apps="exe;deb;ipa;apk;sis;psd;dat;app";
        String[] type=imgs.split(";");
        //文本
        if(filename.endsWith("txt"))
            return "txt";
        //图片
        for(String a:type){
            if(filename.endsWith(a))
                return "img";
        }
        //代码
        type=codes.split(";");
        for(String a:type){
            if(filename.endsWith(a))
                return "code";
        }
        //视频
        type=videos.split(";");
        for(String a:type){
            if(filename.endsWith(a))
                return "video";
        }
        //音乐
        type=music.split(";");
        for(String a:type){
            if(filename.endsWith(a))
                return "music";
        }
        //压缩文件
        type=rar.split(";");
        for(String a:type){
            if(filename.endsWith(a))
                return "rar";
        }
        //应用文件
        type=apps.split(";");
        for(String a:type){
            if(filename.endsWith(a))
                return "app.png";
        }
        return s;
    }
    public static String getfilesize(long s){
        float size=(float) s;
        if(size>0&&size<1024){
            return size+"B";
        } else if (size>=1024&&size<1024*1024) {
            return String.format("%.2f", size/1024)+"KB";
        }else if (size>=1024*1024&&size<1024*1024*1024)
            return String.format("%.2f", size/1024/1024)+"MB";
        else
            return String.format("%.2f", size/1024/1024/1024)+"GB";
    }
}
