public class ApiOperator {
    public static void main(String[] args) {
        int a = 10;
        int b=a++; //a++ 累加的结果，不参与本次运算（使用变量的原始值进行运算）

        System.out.println(a); //11 无论是前后都会对变理的值进行累加。
        System.out.println(b); //10 a++ 累加的结果，不参与本次运算（使用变量的原始值进行运算）

        int c = 10;
        int d =++c; //++c 累加的结果，要参与本次运算（使用累加之后的值进行运算）
        System.out.println(c);//11 无论是前后都会对变理的值进行累加。
        System.out.println(d);//11 ++a 累加的结果，要参与本次运算（使用累加之后的值进行运算）
    }

}
