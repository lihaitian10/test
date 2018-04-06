package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BmiServlet extends HttpServlet{
	
	public void service(
			HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		
		request.setCharacterEncoding("utf-8");
		
		//读取身高和体重
		String height = 
				request.getParameter("height");
		String weight = 
				request.getParameter("weight");
		System.out.println("height:" + height 
				+ " weight:" + weight);
		
		//读取兴趣
		String[] interest = 
				request.getParameterValues("interest");
		System.out.println("interest:" + interest);
		if(interest != null){
			for(int i = 0; i < interest.length; i ++){
				System.out.println(interest[i]);
			}
		}
		//读取姓名
		String name = request.getParameter("name");
		System.out.println("name:" + name);
		
		//这儿暂时不做参数合法性检查。
		//计算bmi指数
		double bmi = 
				Double.parseDouble(weight)/
				Double.parseDouble(height)/
				Double.parseDouble(height);
		System.out.println("bmi:" + bmi);
		//依据bmi指数，判断用户身体状况
		String status = "正常";
		if(bmi < 19){
			status = "过轻";
		}
		if(bmi > 25){
			status = "过重";
		}
		//返回结果给浏览器
		/*
		 * 作用1:设置返回给浏览器的数据的MIME类型(
		 * 告诉浏览器，服务器返回的数据类型和编码)。
		 * 作用2: 设置out.println方法在输出时，使用
		 * 哪种字符集来编码。
		 */
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
		 * out在输出时，默认会使用iso-8859-1来编码。
		 */
		out.println(status);
		out.close();
		
	}
}









