package com.lhy.adminj.basic.util.password;

public class PasswordUtil {

    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        System.out.println("★★★★★★★同样的密文，加密后是不一样的：");
        System.out.println("我是qqqqqq,加密后：" + passwordEncoder.encode("qqqqqq"));
        System.out.println("我是qqqqqq,加密后：" + passwordEncoder.encode("qqqqqq"));
        System.out.println("我是qqqqqq,加密后：" + passwordEncoder.encode("qqqqqq"));
        System.out.println("我是qqqqqq,加密后：" + passwordEncoder.encode("qqqqqq"));
        System.out.println();

        System.out.println("===============================密码验证方式：==============================================");
        System.out.println();
        String oldPwd = passwordEncoder.encode("456789");
        System.out.println("oldPwd:" + oldPwd);
        System.out.println("是123456吗？" + passwordEncoder.matches("123456", oldPwd));
        System.out.println("是456789吗？"
                           + passwordEncoder.matches("103609",
                               "$2a$10$l8OLBqq7w7Fi7bPmwDkzDuc9MLAde4TBGFxFGAj5Tw8rhIbCix0f."));

    }

    public static String encode(String pwd) {
        return passwordEncoder.encode(pwd);
    }

    public static boolean equals(String pwd, String encodePwd) {
        return passwordEncoder.matches(pwd, encodePwd);
    }
}
