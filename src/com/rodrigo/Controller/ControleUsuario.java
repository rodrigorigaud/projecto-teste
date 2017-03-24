package com.rodrigo.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rodrigo.DAO.UsuarioDao;
import com.rodrigo.Model.Usuario;

public class ControleUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERIR_EDITAR = "/js/usuario.jsp";
    private static String LISTA_USUARIO = "/js/listaUsuario.jsp";
    private UsuarioDao dao;

    public ControleUsuario() {
        super();
        dao = new UsuarioDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int idusuario = Integer.parseInt(request.getParameter("idusuario"));
            dao.deletarUsuario(idusuario);
            forward = LISTA_USUARIO;
            request.setAttribute("usuarios", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERIR_EDITAR;
            int userId = Integer.parseInt(request.getParameter("idusuario"));
            Usuario usuario = dao.getUserById(userId);
            request.setAttribute("usuarios", usuario);
        } else if (action.equalsIgnoreCase("listaUsuario")){
            forward = LISTA_USUARIO;
            request.setAttribute("usuarios", dao.getAllUsers());
        } else {
            forward = INSERIR_EDITAR;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setPrimeiroNome(request.getParameter("primeironome"));
        usuario.setUltimoNome(request.getParameter("ultimonome"));
        try {
            Date data = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("data"));
            usuario.setData(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        usuario.setEmail(request.getParameter("email"));
        String idUsuario = request.getParameter("idusuario");
        if(idUsuario == null || idUsuario.isEmpty())
        {
            dao.addUsuario(usuario);
        }
        else
        {
            usuario.setIdUsuario(Integer.parseInt(idUsuario));
            dao.updateUser(usuario);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTA_USUARIO);
        request.setAttribute("usuarios", dao.getAllUsers());
        view.forward(request, response);
    }
}