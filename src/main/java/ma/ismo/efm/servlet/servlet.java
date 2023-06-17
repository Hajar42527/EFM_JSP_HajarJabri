package ma.ismo.efm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ismo.crjj.efm.beans.Etablissement;

import ma.ismo.crjj.efm.idao.IDao;
import ma.ismo.crjj.efm.idao.daoEtablissement;



@WebServlet("servlet", urlPatterns = { "/do/*" })
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IDao<Etablissement> dao=new daoEtablissement();
	
    public servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getPathInfo()) {
		case "/All":
			request.setAttribute("etablissement", dao.getAll());
			request.getRequestDispatcher("/pages/tableEtablissement.jsp").forward(request, response);
			break;
		case "/goAdd":
			request.getRequestDispatcher("/pages/AddEtablissement.jsp").forward(request, response);
			break;
		case "/add":
			Etablissement etabAdd = new Etablissement();
			etabAdd.setNom_Etab(request.getParameter("nom"));
			etabAdd.setAdresse_etab(request.getParameter("adress"));
			etabAdd.setTel_etab(request.getParameter("tele"));
			request.setAttribute("added", dao.save(etabAdd)==true? "added":"echec");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		case "/delete":
			Etablissement etabDelete = dao.getOne(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("deleted", dao.delete(etabDelete)==true? "delete":"echec");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
