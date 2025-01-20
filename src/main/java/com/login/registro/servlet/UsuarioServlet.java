package com.login.registro.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.login.registro.dao.UsuarioDAO;
import com.login.registro.model.Usuario;

import java.io.IOException;
import java.sql.SQLException;
public class UsuarioServlet extends HttpServlet {
    private UsuarioDAO contatoDAO = new UsuarioDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if ("inserir".equals(acao)) {
            Usuario contato = new Usuario();
            contato.setNome(request.getParameter("nome"));
            contato.setTelefone(request.getParameter("telefone"));
            contato.setEmail(request.getParameter("email"));
            try {
                contatoDAO.inserir(contato);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("atualizar".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario contato = new Usuario();
            contato.setId(id);
            contato.setNome(request.getParameter("nome"));
            contato.setTelefone(request.getParameter("telefone"));
            contato.setEmail(request.getParameter("email"));
            try {
                contatoDAO.atualizar(contato);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if ("excluir".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                contatoDAO.excluir(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}