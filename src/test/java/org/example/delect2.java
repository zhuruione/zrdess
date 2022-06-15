package org.example;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class delect2 {
    public delect2() {
    }

    public static void main(String[] var0) throws IOException {
        Date var1 = new Date();
        File var2 = new File("G:\\data\\root\\ss\\涩图");
        File[] var3 = var2.listFiles();
        new ArrayList();
        List var4 = Arrays.asList(var3);
        LinkedList var5 = new LinkedList(var4);
        int var6 = 0;
        boolean var7 = true;

        label48:
        for(ListIterator var8 = var5.listIterator(); var8.hasNext(); var8.remove()) {
            File var9 = (File)var8.next();
            String var10 = var9.getName();
            ListIterator var11 = var5.listIterator();

            while(true) {
                File var12;
                String var13;
                do {
                    do {
                        if (!var11.hasNext()) {
                            continue label48;
                        }

                        var12 = (File)var11.next();
                        var13 = var12.getName();
                    } while(var9.length() != var12.length());
                } while(var10.equals(var13));

                byte[] var14 = new byte[100];
                byte[] var15 = new byte[100];
                FileInputStream var16 = new FileInputStream(var9);
                var16.read(var14);
                var16.close();
                var16 = new FileInputStream(var12);
                var16.read(var15);
                var16.close();
                int var17 = 0;

                for(int var18 = 0; var18 < 100; ++var18) {
                    if (var14[var18] == var15[var18]) {
                        ++var17;
                    }
                }

                if (var17 == 100) {
                    System.out.println(var10 + "=============" + var13);
                    System.out.println(var9.toString() + "将要被删除");
                    boolean var19 = var9.delete();
                    if (var19) {
                        System.out.println(var9.getName() + "已经被删除");
                        ++var6;
                    } else {
                        System.out.println(var9.getName() + "删除失败");
                    }
                }
            }
        }

        System.out.println("已经删除了" + var6 + "个文件,耗时" + ((new Date()).getTime() - var1.getTime()));
    }
}
