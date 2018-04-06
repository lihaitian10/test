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
		
		//��ȡ���ߺ�����
		String height = 
				request.getParameter("height");
		String weight = 
				request.getParameter("weight");
		System.out.println("height:" + height 
				+ " weight:" + weight);
		
		//��ȡ��Ȥ
		String[] interest = 
				request.getParameterValues("interest");
		System.out.println("interest:" + interest);
		if(interest != null){
			for(int i = 0; i < interest.length; i ++){
				System.out.println(interest[i]);
			}
		}
		//��ȡ����
		String name = request.getParameter("name");
		System.out.println("name:" + name);
		
		//�����ʱ���������Ϸ��Լ�顣
		//����bmiָ��
		double bmi = 
				Double.parseDouble(weight)/
				Double.parseDouble(height)/
				Double.parseDouble(height);
		System.out.println("bmi:" + bmi);
		//����bmiָ�����ж��û�����״��
		String status = "����";
		if(bmi < 19){
			status = "����";
		}
		if(bmi > 25){
			status = "����";
		}
		//���ؽ���������
		/*
		 * ����1:���÷��ظ�����������ݵ�MIME����(
		 * ��������������������ص��������ͺͱ���)��
		 * ����2: ����out.println���������ʱ��ʹ��
		 * �����ַ��������롣
		 */
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
		 * out�����ʱ��Ĭ�ϻ�ʹ��iso-8859-1�����롣
		 */
		out.println(status);
		out.close();
		
	}
}








