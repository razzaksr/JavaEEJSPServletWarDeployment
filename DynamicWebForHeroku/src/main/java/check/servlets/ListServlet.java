package check.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/viewall")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<Candidates> model=new Vector<Candidates>();// db copy
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/place_buddy","root","");
			Connection con=DriverManager.getConnection("ec2-54-74-60-70.eu-west-1.compute.amazonaws.com:5432/d3lr7ih8pubb7m","lspgnzrpxbkvxi","d808900c579ee255fa35b18ab6f81c3cc5d2aafa3d9f4bbb965788a32a1d919f");
			String qry="select * from candidates";
			PreparedStatement state=con.prepareStatement(qry);
			ResultSet rs=state.executeQuery();
			while(rs.next())
			{
				Candidates can=new Candidates();
				// javaObject.setterMethod(resultSetObj.getType("tableColumnName"))
				can.setRegno(rs.getLong("regno"));
				can.setName(rs.getString("name"));
				can.setAddress(rs.getString("address"));
				can.setBatch(rs.getInt("batch"));
				can.setCareer(rs.getString("career"));
				can.setCgpa(rs.getDouble("cgpa"));
				can.setHsc(rs.getDouble("hsc"));
				can.setDiploma(rs.getDouble("diploma"));
				can.setSslc(rs.getDouble("sslc"));
				can.setContact(rs.getLong("contact"));
				can.setDept(rs.getString("dept"));
				can.setEmail(rs.getString("email"));
				can.setGender(rs.getString("gender"));
				can.setPlaced(rs.getString("placed"));
				can.setSkills(rs.getString("skills"));
				can.setStatus(rs.getString("status"));
				model.add(can);
			}
			RequestDispatcher dis=request.getRequestDispatcher("list.jsp");
			request.setAttribute("every", model);
			dis.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}