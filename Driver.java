
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String args[]) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		int number = 0;
		ArrayList<basic> list = new ArrayList<basic>();
		
		int choose = menu();// 显示菜单

		while (choose != 5) {
			switch (choose) {
			case 1:
				
				System.out.println("输入出题数:");
				number = scan.nextInt();
				break;
			case 2:
				Answer( number, list);
				break;
			case 3:
				View();
				break;
			case 4:
				ranking(list);
				break;
			default:
				System.out.println("invalid choose");
			}
			// 相应功能执行完以后，重新进入菜单进行选择
			choose = menu();
		}

		System.out.println("Bye!");
	}
	
    //菜单
	public static int menu() {
		int choose = 0;

		System.out.println("简单算术运算测验系统");
		System.out.println("1.出题");
		System.out.println("2.答题");
		System.out.println("3.查看成绩");
		System.out.println("4.排行榜");
		System.out.println("5.退出");
		System.out.println("请选择（1-5）");

		Scanner scan = new Scanner(System.in);
		choose = scan.nextInt();

		return choose;
	}
/*	
	//出题
	public static void Answer( int number, ArrayList<basic> list) throws FileNotFoundException  {
        System.out.println("请输入你出题的数目");
        Scanner sc=new Scanner(System.in);
        double j=sc.nextDouble();//输入题的数目

        double n=0;
        for(int i=1;i<=j;i++)
{   

    int number1=(int)(1+Math.random()*100);
    int number2=(int)(1+Math.random()*100);
    System.out.println(number1+"  "+number2);
    if(number1>=number2)
    {
        System.out.println(number1+"-"+number2+"="+"?");
        int cha=sc.nextInt();
        if(cha==(number1-number2))
        {
            System.out.println("回答正确");
            n++;
        }
        else
        {
            System.out.println("很遗憾，你答错了");

        }
    }
    else
    {
        System.out.println(number1+"+"+number2+"="+"?");
        int sum=sc.nextInt();
        if(sum==(number1+number2))
        {
            System.out.println("回答正确");
            n++;
        }
        else
        {
            System.out.println("很遗憾，你答错了");

        }
    }


}
        System.out.println("正确率为"+(n/j));

    }
*/
    // 出题//答题
	public static void Answer( int number, ArrayList<basic> list) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入姓名:");
		String name = scan.nextLine();

		try {
			File file = new File("E:\\我的文件夹\\code\\java\\test9\\ranking.txt");
			if (file.exists()) {
				file.delete();
			}
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			// PrintWriter（）的作用是为了定义流输出的位置，并且此流可以正常的存储中文，减少乱码输出。
			// 备注：文件流用完之后必须及时通过close方法关闭，否则会一直处于打开状态，直至程序停止，增加系统负担。
			double result = 0, myResult = 0;
			double right = 0, wrong = 0;
			String a, b;
			int n = 0;

			for (n = 1; n <= number; n++) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// 定义输出格式/。
				Date today = new Date();
				String todayStr = df.format(today);

				System.out.println("第" + n + "道");

				int i = (int) (1 + Math.random() * 100);
				int j = (int) (1 + Math.random() * 100);
				if (i <= j) {
					int temp = i;
					i = j;
					j = temp;
				}
				double i1 = i;
				double j1 = j;
				String[] operator = { "+", "-", "*", "/" };
				Random r = new Random();
				int num = r.nextInt(4);// 该方法的作用是生成一个随机的int值，该值介于[0,4)的区间，也就是0到4之间的随机int值，包含0而不包含4

				if (operator[num] == "/") {
					if (j == 0) {
						while (j == 0)
							j = (int) (Math.random() * 100);
					}
				} // 考虑除数是否为0的情况，不过用在这边没有意义，这里的j不可能为0
				String str1 = i + operator[num] + j;
				if (operator[num] == "+") {
					result = i + j;
					System.out.println(str1 + "=");
					myResult = scan.nextDouble();
					pw.print(str1 + "= " + result);// 保存到文件中去
					pw.print(" 我的答案: " + myResult);
					pw.println(" 日期: " + todayStr);
				} else if (operator[num] == "-") {
					result = i - j;
					System.out.println(str1 + "=");
					myResult = scan.nextDouble();
					pw.print(str1 + "= " + result);
					pw.print("  我的答案: " + myResult);
					pw.println(" 日期: " + todayStr);
				} else if (operator[num] == "*") {
					result = i * j;
					System.out.println(str1 + "=");
					myResult = scan.nextDouble();
					pw.print(str1 + "= " + result);
					pw.print(" 我的答案: " + myResult);
					pw.println(" 日期: " + todayStr);
				} else if (operator[num] == "/") {
					result = (int) (i1 / j1);
					System.out.println(str1 + "=");
					myResult = scan.nextDouble();
					pw.print(str1 + "= " + result);
					pw.print(" 我的答案: " + myResult);
					pw.println(" 日期: " + todayStr);
				}
				if (result == myResult)
					right++;
				else
					wrong++;
			}
			int score = (int) ((right / number) * 100);
			int rightBate = (int) ((right / number) * 100);
			pw.println("姓名: " + name + " 分数: " + score + "  正确率: " + rightBate + " %");

			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date today1 = new Date();
			String todayStr1 = df1.format(today1);
			basic baisc1 = new basic(name, score, todayStr1);
			list.add(baisc1);

			pw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//显示成绩
	public static void View() throws FileNotFoundException {
		File file = new File("E:\\我的文件夹\\code\\java\\test9\\ranking.txt");
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String probleam = input.next();
			String n = input.next();
			String m = input.next();
			String x = input.next();
			String y = input.next();
			String z = input.next();
			String answer = input.next();

			System.out.println(probleam + " " + n + " " + m + x + " " + y + " " + z + " " + answer);
		}
		input.close();
	}
    
	//排行榜
	public static void ranking(ArrayList<basic> list) {
		int len = list.size();

		for (int i = 0; i < len; i++) {
			basic basic1 = list.get(i);
			int score = basic1.getScore();
			for (int j = i + 1; j < len; j++) {
				basic basic2 = list.get(j);
				int score1 = basic2.getScore();
				if (score > score1) {
					basic basic3 = list.get(i);
					list.set(i, list.get(j));
					list.set(j, basic3);
				}
			}
		}
	/*public static void ranking(ArrayList<basic> list) {
		int len = list.size();
		int[] a = new int[len];

		for (int i = 0; i < len; i++) {
			basic basic1 = list.get(i);
			int score = basic1.getScore();
			a[i]=score;
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				//basic basic2 = list.get(j);
				//int score1 = basic1.getScore();
				if (a[j] > a[j+1]) {
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					basic3 = list.get(i);
					list.set(i, list.get(j));
					list.set(j, basic3);
				}
			}n
		}*/
		for(int m = 0;m < list.size(); m++) {
			int n = list.size()-m;
			System.out.println("排名:"+n+ "  "+list.get(m));
		}
	}
}
