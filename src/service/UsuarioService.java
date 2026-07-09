package service;

import DAO.UsuarioDAO;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public String autenticar(String usuario, String senha) {

        return dao.autenticar(usuario, senha);

    }

}
