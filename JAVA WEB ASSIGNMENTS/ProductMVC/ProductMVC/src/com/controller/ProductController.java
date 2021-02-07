package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Product;
import com.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		ProductService ps = new ProductService();
		List<Product> lisfOfRec = ps.getAllProduct();
		HttpSession hs = request.getSession();
		hs.setAttribute("productInfo",lisfOfRec);
		response.sendRedirect("retreiveProduct.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		
		String op = request.getParameter("product");
		ProductService ps = new ProductService();
		
		if(op.equals("insert")) {
		int id = Integer.parseInt(request.getParameter("pid"));
		String name = request.getParameter("pname");
		float price = Float.parseFloat(request.getParameter("price"));
		
		Product pro = new Product();
		pro.setPid(id);
		pro.setPname(name);
		pro.setPrice(price);
		
		
		String result = ps.storeProduct(pro);
		
		RequestDispatcher rd = request.getRequestDispatcher("insertProduct.jsp");
		pw.print(result);
		rd.include(request, response);
		}else if(op.equals("delete")) {
		int id = Integer.parseInt(request.getParameter("pid"));
		String res = ps.deleteProduct(id);
		pw.println(res);
		RequestDispatcher rd = request.getRequestDispatcher("deleteProduct.jsp");
		rd.include(request, response);
		}
	}

}
