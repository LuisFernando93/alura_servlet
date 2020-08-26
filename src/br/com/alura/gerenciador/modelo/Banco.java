package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer chaveSequencial = 1; 
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa1);
		lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("luis");
		u1.setSenha("1234");
		
		Usuario u2 = new Usuario();
		u2.setLogin("julia");
		u2.setSenha("1234");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		
		System.out.println(u1.getLogin() + " | " + u1.getSenha());
		System.out.println(u2.getLogin() + " | " + u2.getSenha());
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(chaveSequencial++);
		lista.add(empresa);
	}
	
	public List<Empresa> getLista() {
		return Banco.lista;
	}

	public void removaEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId() == id) {
				it.remove();
			}
		}
		
	}

	public Empresa buscaEmpresaById(Integer id) {
		
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
