package com.example.springboottest1;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Date;

public class Test11 {
	public static void main(String[] args) {
		String str=null;
		//$使用
		str=String.format("格式参数$的使用：%2$s,%1$d", 99,"abc");
		System.out.println(str);
		//+使用
		System.out.printf("显示正负数的符号：%+d与%d%n", 99,-99);
		//补O使用
		System.out.printf("最牛的编号是：%03d%n", 7);
		//空格使用
		System.out.printf("Tab键的效果是：% 8d%n", 7);
		//.使用
		System.out.printf("整数分组的效果是：%,d%n", 9989997);
		//空格和小数点后面个数
		System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);


		//日期字符串格式化
		Date date=new Date();
		//c的使用
		System.out.printf("全部日期和时间信息：%tc%n",date);
		//f的使用
		System.out.printf("年-月-日格式：%tF%n",date);
		//d的使用
		System.out.printf("月/日/年格式：%tD%n",date);
		//r的使用
		System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
		//t的使用
		System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
		//R的使用
		System.out.printf("HH:MM格式（24时制）：%tR%n",date);


		System.out.println("////////////////////////////////////////////////");
		int planet = 7;
		String event = "a disturbance in the Force";
		String result = MessageFormat.format("At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
				planet, new Date(), event);
		System.out.println(result);
        //输出：At 20:39:15 on 2015-12-11, there was a disturbance in the Force on planet 7


		System.out.println("********************************************************");
		/**在这个例子中，MessageFormat和ChoiceFormat被结合使用
		 * MessageFormat类中有3个方法值的我们关注
		 * 1.setFormatByArgumentIndex(int argumentIndex, Format newFormat)//
		 * 2.setFormats(Format[] newFormats)
		 * 3.setFormat(int formatElementIndex, Format newFormat)
		 * 在这个例子当中，在MessageFormat的模式字符串的FormatElement（即{}中的内容）中
		 * 索引为0的地方将使用ChoiceFormat的格式去格式化。
		 * 如果在set的Format中仍具有FormatElement，则会递归调用MessageFormat的format方法。
		 */
		MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0}.");
		double[] filelimits = { 0, 1, 2 };
		String[] filepart = { "no files", "one file", "{0,number} files" };
		ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
		form.setFormatByArgumentIndex(0, fileform);
		int fileCount = 1273;
		String diskName = "MyDisk";
		Object[] testArgs = { new Long(fileCount), diskName };
		System.out.println(form.format(testArgs));
 		//输出：The disk "MyDisk" contains 1,273 files.


		String result1 = String.format("小明今年%d岁,他住在%s,他的月工资有%.2f", 25,"北京市",6633.435);
		System.out.println(result1);//输出:小明今年25岁,他住在北京市,他的月工资有6633.44
        /*****************************************************/
		double num = 123.4567899;
		String result2 = String.format("%e", num);
		System.out.println(result2);//输出：1.234568e+02

	}
}
