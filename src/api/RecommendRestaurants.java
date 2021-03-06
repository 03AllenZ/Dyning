package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class RecommendRestaurants
 */
@WebServlet(name = "recommendation", urlPatterns = { "/recommendation" })
public class RecommendRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendRestaurants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray array = new JSONArray();
		try {
			if(request.getParameterMap().containsKey("user_id")) {
				String user_id = request.getParameter("user_id");
				//return some fake restaurants
				JSONObject Napa = new JSONObject();
				Napa.put("name","Napa Flats");
				Napa.put("location", "Harvey Rd");
				Napa.put("city", "College Station");
				array.put(Napa);
				array.put(new JSONObject().put("name", "555Grill"));
			}
		} catch(JSONException e) {
			e.printStackTrace();
		}
		RpcParser.writeOutput(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
