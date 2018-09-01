/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.LivroLiterario;
import br.edu.utfpr.model.dao.LivroLiterarioDAO;

/**
 *
 * @author Lucas
 */
public class LivroLiterarioService extends AbstractService<Long, LivroLiterario> {

    public LivroLiterarioService() 
    {
        dao = new LivroLiterarioDAO();
    }
}
    

