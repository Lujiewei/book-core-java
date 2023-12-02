package com.github;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {
        // 当文本光标位于高亮显示的文本处时按 Alt+Enter，
        // 可查看 IntelliJ IDEA 对于如何修正该问题的建议。
        System.out.println("Hello and welcome!");

        // 按 Shift+F10 或点击装订区域中的绿色箭头按钮以运行脚本。
//        for (int i = 1; i <= 5; i++) {
//            // 按 Shift+F9 开始调试代码。我们已为您设置了一个断点，
//            // 但您始终可以通过按 Ctrl+F8 添加更多断点。
//            System.out.println("i = " + i);
//        }

        int[] arr = {20, 43, 12, 65, 12, 23};
        /*for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        String greeting = "hello";
        String s = greeting.substring(0, 3);

        System.out.println(s);
        System.out.println("java".repeat(4));
        System.out.println("java".equals("Java"));
        System.out.println("java".equalsIgnoreCase("Java"));*/
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = 0;
            for(j = i - 1; j >= 0; j--){
                if(arr[j] > temp){
                    arr[j + 1] = arr[j];
                }else{
                    break;
                }
            }
            if(arr[j + 1] != temp){
                arr[j + 1] = temp;
            }
        }
        for(int n : arr){
            System.out.println(n);
        }
    }
}