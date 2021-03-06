package ar.edu.ubp.pdc.sesiones;

/* PARA ARREGLAR LA PORONGA DE IDE QUE ES ECLIPSE
 * (para solucionar el tema de que toma la version 1.8 de java)
 * 
 * Right click on project >> properties >> project facets >> click on java
 * Y ahi le cambiamos a la version 9.
 * 
 * Un saludos,
 * 
 * Junior.
 *
 * */

/*
 * */

/** TODO: Agregar un input (el template cozastore ya trae uno lindo cuando tocas un item) 
 *        para aniadir la cantidad de items que queres comprar.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoProductoServlet
 */
@WebServlet("/InfoProductoServlet")
public class InfoProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoProductoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("nombre") != null && request.getParameter("nombre") != "") {
			PrintWriter out = response.getWriter();
			String id = request.getParameter("id");
			String nom = request.getParameter("nombre");
			String desc = request.getParameter("descripcion");
			String valor = request.getParameter("precio");
			String src_imagen = request.getParameter("src_imagen");

			out.println(" <div id=item-" + id + " class=\"item\">\n"
					+ "<input type=\"hidden\" name=\"identificador\" value=" + id + ">"
					+ "<div class=\"volver-container\">\n"
					+ "		<a onclick=\"volver_a_home()\" class=\"volver-a-comprar volver\">"
					+ "		<i class=\"fa fa-arrow-left flecha-volver\"></i> Volver a comprar</a>" + "</div>"
					+ "            <div class=\"d-md-block media mb-4 text-center site-media site-animate  info-item\">\n"
					+ "              <img class=\"src_imagen img-fluid imagen-producto\" style=\"max-width:100%; height:auto;\" src="
					+ src_imagen + " alt=\"Free Template by colorlib.com\" class=\"img-fluid\">\n"
					+ "<h5 class=\"mt-0 h4 nombre\">" + nom
					+ "<span class=\"text-primary price-item\"><h5 class=\"precio\">" + valor + "</h5></span> </h5>"
					+ "<p class=\"mb-4 descripcion\">" + desc + "</p>\n" + "\n"
					+ "								<div class=\"flex-w add-to-cart\">\n"
					+ "									<div class=\"d-block flex-w flex-m respon6-next\">\n"
					+ "<div class=\"add-cantidad\"> "
					+ "<div class=\"cantidad\"> <h5 class=\"mt-0 h5 texto-cantidad\"> Cantidad </h5> </div>"
					+ "										<div class=\"wrap-num-product flex-w m-r-20 m-tb-10\">\n"
					+ "											<div class=\"btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m\" onclick=\"restar()\">\n"
					+ "												<i class=\"fs-16 zmdi zmdi-minus\"></i>\n"
					+ "											</div>\n" + "\n"
					+ "											<input class=\"mtext-104 cl3 txt-center num-product\" type=\"number\" name=\"num-product\" value=\"1\">\n"
					+ "\n"
					+ "											<div class=\"btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m\" onclick=\"sumar()\">\n"
					+ "												<i class=\"fs-16 zmdi zmdi-plus\"></i>\n"
					+ "											</div>\n"
					+ "										</div>" + "</div>" + "<hr/>"
					+ "<button class=\"col-sm-1 flex-c-m stext-101 cl0 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail btn-add\" onclick=\"add("
					+ id + ")\">\n	A&ntilde;adir al carrito\n </button>\n"
					+ "									</div>\n" + "								</div>"
					// + "<a type=\"button\" class=\"col-sm-1 col-md-3 btn btn-warning volver\"
					// href=\"index.jsp\">Volver</a>"
					+ "</div>");

		}
	}

}
