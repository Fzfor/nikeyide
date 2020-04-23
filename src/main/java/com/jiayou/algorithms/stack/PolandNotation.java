package com.jiayou.algorithms.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create by fz on 2020/4/19
 */
public class PolandNotation {
    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)x4)-5 => 1 2 3 + 4 x + 5 -
        //2. 因为直接对str进行操作，不方便，因此，先将"1+((2+3)x4)-5" =》中缀的表达式对应的List
        //即"1+((2+3)x4)-5" => ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
        //3.将得到的中缀表达式对应的List => 后缀表达式对应的List
        //即ArrayList[1,+,(,(,2,+,3,),*,4,),-,5] => [1,2,3,+,4,*,+,5,-]
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的list="+infixExpressionList);

        List<String> parseSrffixExpressionList = parseSrffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的list="+parseSrffixExpressionList);

        System.out.println("expression= "+calculate(parseSrffixExpressionList));


        //先定义给逆波兰表达式
        //(3+4) x 5 -6 => 3 4 + 5 x 6 -
        //说明为了方便，逆波兰表达式的数字和符号使用空格隔开
//        String suffixExpression = "3 4 + 5 * 6 -";
        //4*5-8+60+8/2
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//        //思路
//        //1.先将"3 4 + 5 x 6 -"放到ArrayList中
//        //2.将ArrayList传递给一个方法，遍历ArrayList 配合栈 完成计算
//        List<String> rpnList = getListString(suffixExpression);
//
//        System.out.println("rpnList = " + rpnList);
//
//        int res = calculate(rpnList);
//        System.out.println(res);
    }

    //将得到的中缀表达式对应的List => 后缀表达式对应的List
    //即ArrayList[1,+,(,(,2,+,3,),*,4,),-,5] => [1,2,3,+,4,*,+,5,-]
    public static List<String> parseSrffixExpressionList(List<String> ls) {
        //定义两个容器
        Stack<String> s1 = new Stack<>(); //符号栈
        //说明：因为s2这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们就不用Stack<String>直接使用List<String> s2
        List s2 = new ArrayList<>();

        //遍历ls
        for (String item : ls) {
            //如果是一个数,加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“）”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();  //!!!将 （ 弹出s1，消除小括号
            }else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次与s1中新的栈顶的运算符相比较
                //问题：我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;  //注意因为是存放到list，因此按顺序输出就是对应的后缀表达式对应的list
    }

    //方法：将中缀表达式转成对应的list
    // s = "1+((2+3)x4)-5"
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式对应的内容
        ArrayList<String> ls = new ArrayList<>();
        int i = 0;  //这时是一个指针，用于遍历中缀表达式字符串
        String str; //对多位数的拼接
        char c;    //每遍历到一个字符，就放入到C

        do {
            //如果c是一个非数字，我需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;    //i需要后移
            } else {    //如果是一个数，需要考虑多位数
                str = "";   //先将str置成"" '0'[48] -> '9'[57]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;   //拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }


    private static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] splits = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();

        for (String split : splits) {
            list.add(split);
        }
        return list;
    }

    /**
     * 1． 从左至右扫描， 将 3 和 4 压入堆栈；
     * 2． 遇到+运算符， 因此弹出 4 和 3（4 为栈顶元素， 3 为次顶元素） ， 计算出 3+4 的值， 得 7， 再将 7 入栈；
     * 3． 将 5 入栈；
     * 4． 接下来是× 运算符， 因此弹出 5 和 7， 计算出 7× 5=35， 将 35 入栈；
     * 5． 将 6 入栈；
     * 6． 最后是-运算符， 计算出 35-6 的值， 即 29， 由此得出最终结果
     */

    public static int calculate(List<String> ls) {
        //创建栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //这里使用正则表达式来取出结果
            if (item.matches("\\d+")) {  //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;  //注意顺序
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;   //注意顺序
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push(res + "");
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }

}


//编写一个类Operation，可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DEV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DEV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}