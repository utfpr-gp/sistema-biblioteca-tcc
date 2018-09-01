/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Genero;
import br.edu.utfpr.model.dao.GeneroDAO;

/**
 *
 * @author Lucas
 */
public class GeneroService extends AbstractService<Long, Genero>{
    
    public GeneroService()
    {
        dao = new GeneroDAO();
    }
}    
