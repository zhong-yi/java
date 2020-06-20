
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
		
		int choose = menu();// ��ʾ�˵�

		while (choose != 5) {
			switch (choose) {
			case 1:
				
				System.out.println("���������:");
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
			// ��Ӧ����ִ�����Ժ����½���˵�����ѡ��
			choose = menu();
		}

		System.out.println("Bye!");
	}
	
    //�˵�
	public static int menu() {
		int choose = 0;

		System.out.println("�������������ϵͳ");
		System.out.println("1.����");
		System.out.println("2.����");
		System.out.println("3.�鿴�ɼ�");
		System.out.println("4.���а�");
		System.out.println("5.�˳�");
		System.out.println("��ѡ��1-5��");

		Scanner scan = new Scanner(System.in);
		choose = scan.nextInt();

		return choose;
	}
/*	
	//����
	public static void Answer( int number, ArrayList<basic> list) throws FileNotFoundException  {
        System.out.println("��������������Ŀ");
        Scanner sc=new Scanner(System.in);
        double j=sc.nextDouble();//���������Ŀ

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
            System.out.println("�ش���ȷ");
            n++;
        }
        else
        {
            System.out.println("���ź���������");

        }
    }
    else
    {
        System.out.println(number1+"+"+number2+"="+"?");
        int sum=sc.nextInt();
        if(sum==(number1+number2))
        {
            System.out.println("�ش���ȷ");
            n++;
        }
        else
        {
            System.out.println("���ź���������");

        }
    }


}
        System.out.println("��ȷ��Ϊ"+(n/j));

    }
*/
    // ����//����
	public static void Answer( int number, ArrayList<basic> list) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		System.out.println("����������:");
		String name = scan.nextLine();

		try {
			File file = new File("E:\\�ҵ��ļ���\\code\\java\\test9\\ranking.txt");
			if (file.exists()) {
				file.delete();
			}
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			// PrintWriter������������Ϊ�˶����������λ�ã����Ҵ������������Ĵ洢���ģ��������������
			// ��ע���ļ�������֮����뼰ʱͨ��close�����رգ������һֱ���ڴ�״̬��ֱ������ֹͣ������ϵͳ������
			double result = 0, myResult = 0;
			double right = 0, wrong = 0;
			String a, b;
			int n = 0;

			for (n = 1; n <= number; n++) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// ���������ʽ/��
				Date today = new Date();
				String todayStr = df.format(today);

				System.out.println("��" + n + "��");

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
				int num = r.nextInt(4);// �÷���������������һ�������intֵ����ֵ����[0,4)�����䣬Ҳ����0��4֮������intֵ������0��������4

				if (operator[num] == "/") {
					if (j == 0) {
						while (j == 0)
							j = (int) (Math.random() * 100);
					}
				} // ���ǳ����Ƿ�Ϊ0������������������û�����壬�����j������Ϊ0
				String str1 = i + operator[num] + j;
				if (operator[num] == "+") {
					result = i + j;
					System.out.println(str1 + "=");
					myResult = scan.nextDouble();
					pw.print(str1 + "= " + result);// ���浽�ļ���ȥ
					pw.print(" �ҵĴ�: " + myResult);
					pw.println(" ����: " + todayStr);
				} else if (operator[num] == "-") {
					result = i - j;
					System.out.println(str1 + "=");
					myResult = scan.nextDouble();
					pw.print(str1 + "= " + result);
					pw.print("  �ҵĴ�: " + myResult);
					pw.println(" ����: " + todayStr);
				} else if (operator[num] == "*") {
					result = i * j;
					System.out.println(str1 + "=");
					myResult = scan.nextDouble();
					pw.print(str1 + "= " + result);
					pw.print(" �ҵĴ�: " + myResult);
					pw.println(" ����: " + todayStr);
				} else if (operator[num] == "/") {
					result = (int) (i1 / j1);
					System.out.println(str1 + "=");
					myResult = scan.nextDouble();
					pw.print(str1 + "= " + result);
					pw.print(" �ҵĴ�: " + myResult);
					pw.println(" ����: " + todayStr);
				}
				if (result == myResult)
					right++;
				else
					wrong++;
			}
			int score = (int) ((right / number) * 100);
			int rightBate = (int) ((right / number) * 100);
			pw.println("����: " + name + " ����: " + score + "  ��ȷ��: " + rightBate + " %");

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

	//��ʾ�ɼ�
	public static void View() throws FileNotFoundException {
		File file = new File("E:\\�ҵ��ļ���\\code\\java\\test9\\ranking.txt");
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
    
	//���а�
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
			System.out.println("����:"+n+ "  "+list.get(m));
		}
	}
}
