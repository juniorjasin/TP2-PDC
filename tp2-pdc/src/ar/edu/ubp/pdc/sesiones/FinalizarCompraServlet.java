package ar.edu.ubp.pdc.sesiones;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FinalizarCompraServlet
 */
@WebServlet("/FinalizarCompraServlet")
public class FinalizarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinalizarCompraServlet() {
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

		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();

		String nombre = "", apellido = "", mail = "", dirPostal = "";

		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cnombre")) {
					nombre = cookie.getValue();
				}
				if (cookie.getName().equals("capellido")) {
					apellido = cookie.getValue();

				}
				if (cookie.getName().equals("cmail")) {
					mail = cookie.getValue();
				}
				if (cookie.getName().equals("cdirPostal")) {
					dirPostal = cookie.getValue();
				}
			}
		}

		out.println("" + "<a onclick=\"volver_carrito()\" class=\"volver\">"
				+ "<i class=\"fa fa-arrow-left flecha-volver\"></i> Volver al carrito</a>"
				+ "<div class=\"section-form\">" + "<div class=\"col-sm-16 col-lg-16 p-b-50\">\n"
				+ "    <h4 class=\"stext-301 cl10 p-b-30\">Ingrese sus datos</h4>\n" + "\n"
				+ "    <form id=\"iform-confirmar\" action=\"javascript:void(null)\" onsubmit=\"procesarCompra(event)\">\n"
				+ "\n" + "        <div class=\"col-lg-6 wrap-input1 w-full p-b-4 fc-inombre\">\n"
				+ "            <input id=\"inombre\" class=\"input1 bg-none plh1 stext-107\" type=\"text\" name=\"nombre\" placeholder=\"Ingrese su nombre\" required value="
				+ nombre + ">\n" + "            <div class=\"focus-input1 trans-04\"></div>\n" + "        </div>\n"
				+ "        <div class=\"col-sm-6 col-lg-6 wrap-input1 w-full p-b-4 fc-iapellido\">\n"
				+ "            <input id=\"iapellido\" class=\"input1 bg-none plh1 stext-107\" type=\"text\" name=\"apellido\" placeholder=\"Ingrese su apellido\" required value="
				+ apellido + ">\n" + "            <div class=\"focus-input1 trans-04\"></div>\n" + "        </div>\n"
				+ "        <div class=\"col-sm-6 col-lg-6 wrap-input1 w-full p-b-4 fc-idirpostal\">\n"
				+ "                <input id=\"idirpostal\" class=\"input1 bg-none plh1 stext-107\" type=\"text\" name=\"dirPostal\" placeholder=\"Ingrese su direccion postal\" required value="
				+ dirPostal + ">\n" + "                <div class=\"focus-input1 trans-04\"></div>\n"
				+ "            </div>\n"
				+ "        <div class=\"col-sm-6 col-lg-6 wrap-input1 w-full p-b-4 fc-imail\">\n"
				+ "            <input id=\"imail\" class=\"input1 bg-none plh1 stext-107\" type=\"email\" name=\"email\" placeholder=\"email@example.com\" required value="
				+ mail + ">\n" + "            <div class=\"focus-input1 trans-04\"></div>\n" + "        </div>\n" + "\n"
				+ "        <div class=\"col-sm-6 col-lg-6 wrap-input1 w-full p-b-4\">\n"
				+ "            <input id=\"irecordar\" type=\"checkbox\" name=\"recordar\" checked>\n"
				+ "            <label class=\"lab-recordar\" for=\"irecordar\"> Recordar datos?  </label>"
				+ "            <div class=\"focus-input1 trans-04\"></div>" + "        </div>\n"
				+ "        <div class=\"p-t-18 btn-confirmar-compra-container\">\n"
				+ "            <button type=\"submit\" name=\"button\" id=\"ibutton\" class=\"btn-finalizar-compra flex-c-m stext-101 size-101 bg10 bor1 hov-btn1 p-lr-15 trans-04 btn-primary\">\n"
				+ "                Confirmar pedido</button>\n" + "        </div>\n" + "    </form>\n" + "</div>"
				+ "</div>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("entro a doPost");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();

		if (request.getParameter("nombre") != null && request.getParameter("nombre") != "") {

			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String mail = request.getParameter("mail");
			String dirPostal = request.getParameter("dirPostal");

			System.out.println("dirPostal: " + dirPostal);

			Cookie cooknombre = new Cookie("cnombre", nombre); // hacer constante el nombre de las cookies
			Cookie cookapellido = new Cookie("capellido", apellido);
			Cookie cookmail = new Cookie("cmail", mail);
			Cookie cookdirPostal = new Cookie("cdirPostal", dirPostal);

			response.addCookie(cooknombre);
			response.addCookie(cookapellido);
			response.addCookie(cookmail);
			response.addCookie(cookdirPostal);

		} else {

			Cookie cookies[] = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					System.out.println("cookie name:" + c.getName());
					System.out.println("cookie value:" + c.getValue());
					c = new Cookie(c.getName(), "");
					c.setMaxAge(0);
					response.addCookie(c);

				}
			}

		}

		// esto es lo que borra la session realmente
		session.invalidate();
		response.sendRedirect("./index.jsp");
	}

}
