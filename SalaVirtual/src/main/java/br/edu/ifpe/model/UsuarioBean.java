package br.edu.ifpe.model;

import java.util.List;

import br.edu.ifpe.model.entity.Usuario;
import br.edu.ifpe.model.repositorio.UsuarioRepositorio;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class UsuarioBean {
	
	@EJB
	private UsuarioRepositorio usuarioRepositorio;
	
	public void adicionarUsuario(Usuario u) {
		if (u != null && u.getNome() != null &&
				!u.getNome().equals("")) {
			this.usuarioRepositorio.add(u);
		}
	}

	public List<Usuario> getUsuarios() {
		return this.usuarioRepositorio.getUsuarios();
	}

}
