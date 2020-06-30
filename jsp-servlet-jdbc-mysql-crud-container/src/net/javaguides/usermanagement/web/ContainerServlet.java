package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.ContainerDAO;

import net.javaguides.usermanagement.model.Container;
import net.javaguides.usermanagement.dao.MovimentacaoDAO;
import net.javaguides.usermanagement.model.Movimentacao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class ContainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContainerDAO containerDAO;
    private MovimentacaoDAO movimentacaoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContainerServlet() {
       this.containerDAO = new ContainerDAO();
       this.movimentacaoDAO = new MovimentacaoDAO();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertContainer(request, response);
                  case "/insertMov":
                    insertMovimentacao(request, response);    
                    break;
                case "/delete":
                    deleteContainer(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/editMov":
                    showEditFormMov(request, response);
                    break;
                case "/update":
                    updateContainer(request, response);
                case "/list":
                    listContainer(request, response);
                    break;
                case "/listMov":
                    listMovimentacao(request, response);
                    break;    
                case "/newMov":
                    showNewFormMov(request, response);
                    break;
                case "/relatorio":
                    listContainer(request, response);
                    break;
                default:
                	showIndexpage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

	 private void listContainer(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Container > listContainer = containerDAO.selectAllContainer();
			        request.setAttribute("listContainer", listContainer);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("container-list.jsp");
			        dispatcher.forward(request, response);
			    }
	 
	 private void listMovimentacao(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        List < Movimentacao > listMovimentacao = movimentacaoDAO.selectAllMovimentacao();
			        request.setAttribute("listMovimentacao", listMovimentacao);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("movimentacao-list.jsp");
			        dispatcher.forward(request, response);
			    }
	 
	 			private void showIndexpage(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			        dispatcher.forward(request, response);
	 			}    

			    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher("container-form.jsp");
			        dispatcher.forward(request, response);
			    }
			    
			    private void showNewFormMov(HttpServletRequest request, HttpServletResponse response)
					    throws ServletException, IOException {
					        RequestDispatcher dispatcher = request.getRequestDispatcher("movimentacao-form.jsp");
					        dispatcher.forward(request, response);
					    }

			    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        int idcontainer = Integer.parseInt(request.getParameter("idcontainer"));
			        Container existingContainer = containerDAO.selectContainer(idcontainer);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("container-form.jsp");
			        request.setAttribute("container", existingContainer);
			        dispatcher.forward(request, response);
			    }    
			    private void showEditFormMov(HttpServletRequest request, HttpServletResponse response)
				  throws SQLException, ServletException, IOException {
				     int idmovimentacao = Integer.parseInt(request.getParameter("idmovimentacao"));
				      Movimentacao existingMovimentacao = movimentacaoDAO.selectMovimentacao(idmovimentacao);
				       RequestDispatcher dispatcher = request.getRequestDispatcher("movimentacao-form.jsp");
				       request.setAttribute("movimentacao", existingMovimentacao);
				       dispatcher.forward(request, response);

			    }

			    private void insertContainer(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String cliente = request.getParameter("cliente");
			        String numero = request.getParameter("numero");
			        String tipo = request.getParameter("tipo");
			        String status = request.getParameter("status");
			        String categoria = request.getParameter("categoria");
			        Container newContainer = new Container(cliente, numero, tipo, status, categoria);
			        containerDAO.insertContainer(newContainer);
			        response.sendRedirect("list");
			    }
			   private void insertMovimentacao(HttpServletRequest request, HttpServletResponse response)
					    throws SQLException, IOException {
				   							   			
					        String navio = request.getParameter("navio");
					        String tipo_mov = request.getParameter("tipo_mov");
					     
					        Movimentacao newMovimentacao = new Movimentacao(navio, tipo_mov, null, null);
					        movimentacaoDAO.insertMovimentacao(newMovimentacao);
					       // response.sendRedirect("listMov");
					    }
			    private void updateContainer(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int idcontainer = Integer.parseInt(request.getParameter("idcontainer"));
			        String cliente = request.getParameter("cliente");
			        String numero = request.getParameter("numero");
			        String tipo = request.getParameter("tipo");
			        String status = request.getParameter("status");
			        String categoria = request.getParameter("categoria");

			        Container book = new Container(idcontainer,cliente, numero, tipo, status, categoria);
			        containerDAO.updateContainer(book);
			       //response.sendRedirect("list");
			    }

			    private void deleteContainer(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int idcontainer = Integer.parseInt(request.getParameter("idcontainer"));
			        containerDAO.deleteContainer(idcontainer);
			        response.sendRedirect("list");

			    }
			}
