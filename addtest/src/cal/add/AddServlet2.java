package cal.add;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
 * Servlet implementation class AddServlet
 */
//@WebServlet("/add2")
public class AddServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(AddServlet2.class.getName());
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final String CONTENTTYPE_JSON = "application/json;charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pw = response.getWriter();

		Enumeration<String> parameterEnum = request.getParameterNames();
		String parameter = null;
		while (parameterEnum.hasMoreElements()) {
			parameter = parameterEnum.nextElement();
			LOGGER.info(parameter + "=" + request.getParameter(parameter));
		}

		// 파라미터 가져오기
		// num1: 값 1
		// num2: 값 2
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		int result = 0;
		// LOGGER.info(this.getClass().getResource("/aaa.txt").getPath());
		// Test Code Start - Start
		// Session session = HibernateUtil.getSessionFactory().openSession();
		// session.beginTransaction();
		AddServlet2 addcore = new AddServlet2();
		result = addcore.addNum(num1, num2);

		// Map<string, string=""> m = new HashMap<string, string="">();
		// JsonBuilderFactory factory = Json.createBuilderFactory(m);
		JSONObject jsonObj = new JSONObject();
		// createObjectBuilder는 하나씩 넣을 때, createArrayBuilder는 배열로 넣을 때.
		try {
			jsonObj.put("result", result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	public int addNum(String num1, String num2) {
		int sum = 0;
		sum = Integer.parseInt(num1) + Integer.parseInt(num2);
		
		return sum;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
