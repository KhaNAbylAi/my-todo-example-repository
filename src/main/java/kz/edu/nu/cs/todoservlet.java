package kz.edu.nu.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(urlPatterns = { "/todo" })
public class todoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> list = new ArrayList<String>();
       

    public todoservlet() {
        super();
        list.add("Start adding items!");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		Gson gson = new Gson();
		out.append(gson.toJson(list));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String meth = request.getParameter("method");
	    if(meth.equals("add")) {
	    	String text = request.getParameter("texttosend");
	    	list.add(text);
	    }
	    else if (meth.equals("set")) {
		    String elem = request.getParameter("newtext");
		    String index = request.getParameter("index");
		    int ind= Integer.parseInt(index);
	    	list.set(ind, elem);
	    }
	    else {
		    String index = request.getParameter("index");
		    int ind= Integer.parseInt(index);
	    	list.remove(ind);
	    }
	}

}