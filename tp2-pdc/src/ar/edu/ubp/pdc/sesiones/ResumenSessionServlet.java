package ar.edu.ubp.pdc.sesiones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResumenSessionServlet
 */
@WebServlet("/ResumenSessionServlet")
public class ResumenSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResumenSessionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(true);

		out.println("" + "<div class=\"volver-container-resumen\">\n"
				+ "		<a onclick=\"volver_a_home()\" class=\"volver-a-comprar volver\">"
				+ "		<i class=\"fa fa-arrow-left flecha-volver\"></i> Volver a comprar</a>" + "</div>" + "<div>"
				+ "<div class=\"resumen-container\">" + "<div class=\"wrap-table-shopping-cart\">\n"
				+ "    <table class=\"table-shopping-cart\">\n" + "        <tr class=\"table_head\">\n" + "            "
				+ "            <th class=\"column-1\">Product0</th>\n"
				+ "            <th class=\"column-2\">Precio</th>\n"
				+ "            <th class=\"column-3\">Cantidad</th>\n"
				+ "            <th class=\"column-4\">Total</th>\n"
				+ "            <th class=\"column-5\">Eliminar</th>\n" + "        </tr>");
		float total = 0;
		String attrName;
		Enumeration<String> attrNames = session.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			attrName = attrNames.nextElement();
			Producto miproducto = (Producto) session.getAttribute(attrName);

			out.println("<tr class=\"table_row\">\n" + "            <td class=\"column-1\">\n"
					+ "              <input type=\"hidden\" name=\"hAttrName\" value=" + miproducto.getId() + ">"
					+ "              <div class=\"how-itemcart1\">\n" + "<img class=\"resume-image\"src="
					+ miproducto.getSrc_imagen() + " alt=\"IMG\"> </div>"
					+ "              <span class=\"product-name\">" + miproducto.getNombre() + "</span>"
					+ "            </td>" + "            <td class=\"column-2\">$" + miproducto.getPrecio() + "</td>\n"
					+ "            <td class=\"column-3\">" + miproducto.getCantidad() + "</td>\n"
					+ "            <td class=\"column-4\" id=\"total-producto-" + miproducto.getId() + "\">$"
					+ miproducto.getCantidad() * miproducto.getPrecio() + "</td>\n"
					+ "<td class=\"column-5\"><button type=\"button\" class=\"close btn-close color-red\" aria-label=\"Close\" onclick=eliminar_product_carrito(this)><span class=\"close-icon\" aria-hidden=\"true\">&times;</span></button></td></tr>");

			total += miproducto.getPrecio() * miproducto.getCantidad();
		}
		out.println("</table>");
		out.println("</div>");
		out.println(
				"<div class=\"total-container\"> <span class=\"total total-text d-inline-block\">Total </span><span class=\"d-inline-block total-number total\"id=\"total\"> "
						+ total + "</span> </div>");
		out.println("<div class=\"finalizar-compra-container\">"
				+ "<a onclick=\"confirmarCompra()\" id=\"ifinalizar-compra\" "
				+ "class=\"btn-finalizar-compra flex-c-m stext-101 size-101 bg10 bor1 hov-btn1 p-lr-15 trans-04\">Finalizar compra</a>"
				+ "<div>" + "<div>");

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
